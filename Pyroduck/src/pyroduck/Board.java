package pyroduck;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import pyroduck.bomb.Bomb;
import pyroduck.bomb.Explosion;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.Player;
import pyroduck.exceptions.LoadLevelException;
import pyroduck.graphics.Screen;
import pyroduck.input.Keyboard;
import pyroduck.level.ContextLevel;
import pyroduck.level.FileLevel;
import pyroduck.level.GrassStrategy;
import pyroduck.level.IceStrategy;

public class Board {
    
    private ContextLevel clevel;
    private final Keyboard input;
    private final Screen screen;
    public Entity[] entities;
    public List<Mob> mobs = new ArrayList<>();
    private int screenToShow = -1; //1:endgame, 2:changelevel, 3:paused
    protected List<Bomb> bombs = new ArrayList<>();
    protected int lives = 3;
    private int points = 0;
    String world = "";
    public Board(Keyboard input, Screen screen) throws IOException {
        this.input = input;
        this.screen = screen;
        changeLevel(1); //start in level 1
    }

    /*
    |--------------------------------------------------------------------------
    | Render & Update
    |--------------------------------------------------------------------------
    */
    public void update() {       
        updateEntities();
        updateMobs();
        updateBombs();
        for (int i = 0; i < mobs.size(); i++) {
            Mob a = mobs.get(i);
            if(((Entity)a).isRemoved()) 
                mobs.remove(i);
        }
    }

    public void render(Screen screen) {
        //only render the visible part of screen
        int x0 = Screen.xOffset >> 5; //tile precision, -> left X
        int x1 = (Screen.xOffset + screen.getWidth() + Game.TILES_SIZE) / Game.TILES_SIZE; // -> right X
        int y0 = Screen.yOffset >> 5;
        int y1 = (Screen.yOffset + screen.getHeight()) / Game.TILES_SIZE; //render one tile plus to fix black margins
        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                entities[x + y * FileLevel.WIDTH].render(screen);
            }
        }
        renderBombs(screen);
        renderMobs(screen);
    }

    /*
    |--------------------------------------------------------------------------
    | ChangeLevel
    |--------------------------------------------------------------------------
    */
    public void newGame() throws IOException {
        resetProperties();
        changeLevel(1);
    }

    @SuppressWarnings("static-access")
    private void resetProperties() {
        Game.playerSpeed = 1.3;
        Game.bombRadius = 1;
        Game.bombRate = 1;	
    }

    public void restartLevel() throws IOException {
        changeLevel(clevel.getFilelevel().getLevel() );
    }

    public void changeLevel(int numlevel) throws FileNotFoundException, IOException { // Livello 1-2: mondo 1; Livello 3-4: mondo 2
        screenToShow = 2;
        mobs.clear();
        bombs.clear();
        try {
            int combination = new Random().nextInt(3)+1;
            
            String path = "./resources/levels/Level" + numlevel + " " + combination + ".txt";
            
            BufferedReader in = new BufferedReader(new FileReader(path));
            String data = in.readLine();      //the first line of the ".txt" file-level has 3 int: 1->level, 2->map-height, 3->map-width
            StringTokenizer tokens = new StringTokenizer(data);  //because this int are separated from a space
            int level = Integer.parseInt(tokens.nextToken());
            world = tokens.nextToken();
            in.close();
            if(world.equals("G")){
                this.clevel = new ContextLevel(new GrassStrategy(path));
                entities = clevel.exectuteStrategy(this, world);
            }
            else{
                this.clevel = new ContextLevel(new IceStrategy(path));
                entities = clevel.exectuteStrategy(this, world);
            }
        } catch (LoadLevelException e) {
            System.out.println("LOAD LEVEL EXCEPTION !!!");
        } catch (NullPointerException e){
            System.out.println("LEVEL'S FILE .txt NOT FOUND");
        }
    }

    /*
    |--------------------------------------------------------------------------
    | Getters And Setters
    |--------------------------------------------------------------------------
     */
    public Entity getEntity(double x, double y, Mob m) {
        Entity res = null;
        res = getExplosionAt((int)x, (int)y);
        if( res != null) 
            return res;
        res = getBombAt(x, y);
        if( res != null) 
            return res;
        res = getMobAtExcluding((int)x, (int)y, m);
        if( res != null) 
            return res;
        res = getEntityAt((int)x, (int)y);
        return res;
    }

    public List<Bomb> getBombs() {
            return bombs;
    }

    public Bomb getBombAt(double x, double y) {
        Iterator<Bomb> bs = bombs.iterator();
        Bomb b;
        while(bs.hasNext()) {
            b = bs.next();
            if(b.getX() == (int)x && b.getY() == (int)y)
                return b;
        }
        return null;
    }

    public Player getPlayer() {
        Iterator<Mob> itr = mobs.iterator();

        Mob cur;
        while(itr.hasNext()) {
            cur = itr.next();
            if(cur instanceof Player)
                return (Player) cur;
        }
        return null;
    }
    
    public Mob getMobAtExcluding(int x, int y, Mob a) {
        Iterator<Mob> itr = mobs.iterator();
        Mob cur;
        while(itr.hasNext()) {
            cur = itr.next();
            if(cur == a) {
                continue;
            }
            if(cur.getXTile() == x && cur.getYTile() == y) {
                return cur;
            }
        }
        return null;
    }
    
    public Explosion getExplosionAt(int x, int y) {
        Iterator<Bomb> bs = bombs.iterator();
        Bomb b;
        while(bs.hasNext()) {
            b = bs.next();
            Explosion e = b.explosionAt(x, y);
            if(e != null)
                return e;
        }
        return null;
    }
    public Entity getEntityAt(double x, double y) {
        return entities[(int)x + (int)y * FileLevel.WIDTH];
    }

    /*
    |--------------------------------------------------------------------------
    | Adds and Removes
    |--------------------------------------------------------------------------
     */
    /**
     * Add the entity and the related position in the entity array.
     */
    public void addEntities() {
        entities = clevel.exectuteStrategy(this, world);
    }
    
    public void addEntitie(int pos, Entity e) {
		entities[pos] = e;
	}

    /**
     * 
     * @return 
     */
    public List<Mob> getMobs() {
        return mobs;
    }

    /**
     * 
     * @param e 
     */
    public void addMob(Mob e) {
        mobs.add(e);
    }
    /*
    |--------------------------------------------------------------------------
    | Renders
    |--------------------------------------------------------------------------
    */
    /*
    Possiamo unire i due metodi?
    */
    protected void renderEntities(Screen screen) {
        for (int i = 0; i < entities.length; i++) 
            entities[i].render(screen);
    }

    protected void renderMobs(Screen screen) {
        Iterator<Mob> itr = mobs.iterator();
        while(itr.hasNext())
            itr.next().render(screen);
    }

    /*
    |--------------------------------------------------------------------------
    | Updates
    |--------------------------------------------------------------------------
    */
    protected void updateMobs() {
        Iterator<Mob> itr = mobs.iterator();
        while(itr.hasNext())
            itr.next().update();
    }

    protected void updateEntities() {
        for (int i = 0; i < entities.length; i++) 
            entities[i].update();
    }
    
    /**
     * 
     */
    public void endGame() {
        screenToShow = 1;
    }

    /*
    |--------------------------------------------------------------------------
    | Getters & Setters
    |--------------------------------------------------------------------------
    */
    /**
     * 
     * @return 
     */
    public Keyboard getInput() {
        return input;
    }

    /**
     * 
     * @return 
     */
    public int getLevel() {
        return clevel.getFilelevel().getLevel();
    }

    /**
     * 
     */
    protected void updateBombs() {
        Iterator<Bomb> itr = bombs.iterator();
        while(itr.hasNext())
            itr.next().update();
    }

    /**
     * 
     * @param b 
     */
    public void addBomb(Bomb b) {
        bombs.add(b);    
    }
    
    /**
     * 
     * @param screen 
     */
    protected void renderBombs(Screen screen) {
        Iterator<Bomb> itr = bombs.iterator();
        while(itr.hasNext())
            itr.next().render(screen);
    }

    public int getLives() {
        return lives;
    }
    
    public void setLives(int i){
        lives=i;
    }

    /**
     * 
     * @param lives 
     */
    public void addLives(int lives) {
        this.lives += lives;
        Game.addLives(lives);
    }
 
    public void addPoints(int points) {
        this.points += points;
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return 
     */
    public Mob getMobAt(double x, double y) {
        Iterator<Mob> itr = mobs.iterator();

        Mob cur;
        while(itr.hasNext()) {
            cur = itr.next();
            if(cur.getXTile() == x && cur.getYTile() == y)
                return cur;
        }
        return null;
    }
}
