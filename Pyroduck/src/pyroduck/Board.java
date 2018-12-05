package pyroduck;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pyroduck.bomb.Bomb;
import pyroduck.bomb.Explosion;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.Player;
import pyroduck.entities.tile.destroyable.ContextDestroyable;
import pyroduck.entities.tile.destroyable.DestroyableIceTile;
import pyroduck.exceptions.LoadLevelException;
import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.Screen;
import pyroduck.input.*;
import pyroduck.level.*;

public class Board extends Observable implements Observer {

    protected ContextLevel clevel;
    private Keyboard input;
    private final Screen screen;
    public Entity[] entities;
    public List<Mob> mobs = new ArrayList<>();
    private int screenToShow = -1; //1:endgame, 2:changelevel, 3:paused
    protected List<Bomb> bombs = new ArrayList<>();
    protected int lives = 3;
    private int points = 0;
    private String world = "";
    private int player;

    private final ContextDestroyable con;
    private List<DestroyableIceTile> destroyableIceTiles = new ArrayList<>();

    protected boolean pause=false;


    
    public Board(Screen screen) {
        this.screen = screen;
        con = new ContextDestroyable();
        changeLevel(2); //start in level 1
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
    public void resetProperties() {
        if(this.getPlayerRight() == 0){
            Game.playerSpeed = 1.3;
            Game.bombRadius = 1;
            Game.bombRate = 1;
        }
        else if(this.getPlayerRight() == 1){
            Game.playerSpeed = 1;
            Game.bombRadius = 1;
            Game.bombRate = 1;
        }
    }

    public void setLives(int lives) {
        this.lives = lives;
        setChanged();
        notifyObservers();
    }

    public void restartLevel() {
        changeLevel(clevel.getFilelevel().getLevel() );
    }

    public void nextLevel() throws IOException {
	changeLevel(clevel.getFilelevel().getLevel() + 1);
        try {
            Game.getInstance().renderScreen();
            Thread.sleep(2500);
            Game.getInstance().resume();//wait 2,5 sec and often shows the next level
        } catch (PyroduckException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void changeLevel(int numlevel) { // Livello 1-2: mondo 1; Livello 3-4: mondo 2
        screenToShow = 2;
        mobs = new ArrayList<>();
        bombs.clear();
        try {
            int combination = new Random(System.currentTimeMillis()).nextInt(3)+1;
            String path = "./resources/levels/Level" + numlevel + " " + combination + ".txt";
            BufferedReader in = null;
            String data = null;
            try {
                in = new BufferedReader(new FileReader(path));
                data = in.readLine();
                in.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Loading file not successfully done", "alert", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex){
                JOptionPane.showMessageDialog(null, "File syntax not correct", "alert", JOptionPane.ERROR_MESSAGE);
            }
            StringTokenizer tokens = new StringTokenizer(data); 
            tokens.nextToken();
            world = tokens.nextToken();     
            input = getRightKeyboard();
            if(world.equals("G")){
                this.clevel = new ContextLevel(new GrassStrategy(path, this));
                entities = clevel.executeStrategy(this); 
            }
            else{
                this.clevel = new ContextLevel(new IceStrategy(path, this));
                entities = clevel.executeStrategy(this);
            }
            
            destroyableIceTiles = createDestroyableIceTile();
        } catch (LoadLevelException e) {
            System.out.println("LOAD LEVEL EXCEPTION !!!");
        } catch (NullPointerException e){
            System.out.println("LEVEL'S FILE .txt NOT FOUND!");
        }
    }

  

    /*
    |--------------------------------------------------------------------------
    | Detections
    |--------------------------------------------------------------------------
    */
    
    /**
     * Return a boolean that say if there is enemies alive in the map or not.
     * @return true if there is not enemies alive in the map, false otherwise.
     */
    public boolean detectNoEnemies() {
        int total = 0;
        for (int i = 0; i < mobs.size(); i++) {
            if(mobs.get(i) instanceof Player == false)
                ++total;
        }
        return total == 0;
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
        entities = clevel.executeStrategy(this);
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
        ListIterator<Mob> itr = mobs.listIterator(mobs.size());
        while(itr.hasPrevious()){
            itr.previous().update();
        }
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
        setPause(true);
    }
    
    /*
    |--------------------------------------------------------------------------
    | Screens
    |--------------------------------------------------------------------------
     */
    public void drawScreen(Graphics g) {
        switch (screenToShow) {
            case 1:
                //screen.drawEndGame(g, points, level.getActualCode());
                break;
            case 2:
                screen.drawChangeLevel(g, clevel.getFilelevel().getLevel());
                break;
            case 3:
                //screen.drawPaused(g);
                break;
        }
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
    
    public List<DestroyableIceTile> createDestroyableIceTile(){
        for(Entity e : entities){
            if (e instanceof DestroyableIceTile)
                destroyableIceTiles.add((DestroyableIceTile) e);       
        }
        return destroyableIceTiles;
    }

    public int getLives() {
        return this.lives;
    }



    public void setPoints(int points) {
        this.points += points;
        setChanged();
        notifyObservers();
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

    private Keyboard getRightKeyboard() {
        if(player == 1){
            return GrassKeyboard.getInstance();
        }
        if(world.equals("G"))
            return GrassKeyboard.getInstance();
        return IceKeyboard.getInstance();
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }

    public void setInput() {
        input = GrassKeyboard.getInstance();
    }
    
    public void setPlayer(int p){
        player = p;
    }
    
    public int getPlayerRight(){
        return player;
    }

    public int getPoints() {
        return points;
    }
    
    public ContextDestroyable getContextState(){
        return con;
    }
    
    public List<DestroyableIceTile> getDestroyableIceTile(){
        return destroyableIceTiles;
    }

    public boolean isPause() {
        return this.pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
        setChanged();
        notifyObservers();
    }
}
