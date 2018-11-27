package pyroduck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pyroduck.bomb.Bomb;
import pyroduck.bomb.Explosion;
import pyroduck.entities.Entity;
import pyroduck.entities.Message;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.Player;
import pyroduck.exceptions.LoadLevelException;
import pyroduck.graphics.Screen;
import pyroduck.input.Keyboard;
import pyroduck.level.FileLevel;

public class Board {

    private FileLevel level;
    private final Keyboard input;
    private final Screen screen;
    public Entity[] entities;
    public List<Mob> mobs = new ArrayList<>();
    private int screenToShow = -1; //1:endgame, 2:changelevel, 3:paused
    protected List<Bomb> bombs = new ArrayList<>();
    protected int lives = 3;
<<<<<<< HEAD
    private int points = 0;
=======
    private List<Message> messages = new ArrayList<Message>();
>>>>>>> parent of 63a8edf... Add collision between "Player" and "Bomb"
            
    public Board(Keyboard input, Screen screen) {
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
    public void newGame() {
        resetProperties();
        changeLevel(1);
    }

    @SuppressWarnings("static-access")
    private void resetProperties() {
        Game.playerSpeed = 1.3;
        Game.bombRadius = 1;
        Game.bombRate = 1;	
    }

    public void restartLevel() {
        changeLevel(level.getLevel());
    }

    public void changeLevel(int level) {
        screenToShow = 2;
        mobs.clear();
        bombs.clear();
        try {
            this.level = new FileLevel("./resources/levels/Level" + level + ".txt");
            entities = this.level.createEntities(this);
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
    public Entity getEntity(double x, double y) {
        Entity res = getExplosionAt((int)x, (int)y);
        if( res != null) 
            return res;
        res = getBombAt(x, y);
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
    public Explosion getExplosionAt(int x, int y) {
        Iterator<Bomb> bs = bombs.iterator();
        Bomb b;
        while(bs.hasNext()) {
            b = bs.next();
            Explosion e = b.explosionAt(x, y);
            if(e != null) {
                return e;
            }
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
        entities = level.createEntities(this);
    }

    public List<Mob> getMobs() {
        return mobs;
    }

    public void addMob(Mob e) {
        mobs.add(e);
    }
<<<<<<< HEAD
=======
    
    /**
     * 
     * @param e 
     */
    public void addMessage(Message e) {
        messages.add(e);
    }
>>>>>>> parent of 63a8edf... Add collision between "Player" and "Bomb"

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

    /*
    |--------------------------------------------------------------------------
    | Getters & Setters
    |--------------------------------------------------------------------------
    */
    public Keyboard getInput() {
        return input;
    }

    public FileLevel getLevel() {
        return level;
    }

    protected void updateBombs() {
        Iterator<Bomb> itr = bombs.iterator();
        while(itr.hasNext())
            itr.next().update();
    }

    public void addBomb(Bomb b) {
        bombs.add(b);    
    }
    
    protected void renderBombs(Screen screen) {
        Iterator<Bomb> itr = bombs.iterator();
        while(itr.hasNext())
            itr.next().render(screen);
    }

    public int getLives() {
        return lives;
    }
    
    public void addLives(int lives) {
        this.lives += lives;
    }
    
    public void endGame() {
        screenToShow = 1;
    }
    
    public void addPoints(int points) {
        this.points += points;
    }
}