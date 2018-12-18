package pyroduck;

import java.io.*;
import static java.lang.Math.abs;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import pyroduck.bomb.*;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.*;
import pyroduck.entities.mob.enemy.EnemyPower;
import pyroduck.entities.mob.enemy.graphic.Enemy;
import pyroduck.entities.tile.destroyable.*;
import pyroduck.graphics.Screen;
import pyroduck.gui.SettingsGame;
import pyroduck.input.*;
import pyroduck.level.*;

public class Board extends Observable implements Observer {

    protected FileLevel level;
    private Keyboard input;
    private Screen screen;
    public Entity[] entities;
    public List<Mob> mobs = new ArrayList<>();
    protected List<Bomb> bombs = new ArrayList<>();
    protected int lives = SettingsGame.getLives();
    private int points = 0;
    private String world = "";
    private int player;
    private Player oldPlayer;
    private final ContextDestroyable con;
    private final List<DestroyableIceTile> destroyableIceTiles = new ArrayList<>();
    protected boolean pause = false;
    private static Board instance = null;
    private int rightLives = 0;
    private Timer timer;

    private Board() {
        con = new ContextDestroyable();
        timer = new Timer();
        lives= SettingsGame.getLives();
    }

    /*
    |--------------------------------------------------------------------------
    | Render & Update
    |--------------------------------------------------------------------------
     */
    public void update() {
        if(lives <= 0){
            
        }
        
        
        updateEntities();
        updateMobs();
        updateBombs();
        for (int i = 0; i < mobs.size(); i++) {
            Mob a = mobs.get(i);
            if (((Entity) a).isRemoved()) {
                mobs.remove(i);
            }
        }
    }

    public void render() {
        int x0 = Screen.xOffset >> 5; //tile precision, -> left X
        int x1 = (Screen.xOffset + screen.getWidth() + Game.TILES_SIZE) / Game.TILES_SIZE; // -> right X
        int y0 = Screen.yOffset >> 5;
        int y1 = (Screen.yOffset + screen.getHeight()) / Game.TILES_SIZE; //render one tile plus to fix black margins
        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                entities[x + y * FileLevel.WIDTH].render(screen);
            }
        }
        renderBombs();
        renderMobs();
    }

    /*
    |--------------------------------------------------------------------------
    | ChangeLevel
    |--------------------------------------------------------------------------
     */

    public void setLives(int lives) {
        this.lives = lives;
        setChanged();
        notifyObservers();
    }

    public void restartLevel() {
        changeLevel(level.getLevel());
    }

    public void nextLevel() throws IOException {
        int i = level.getLevel() + 1;
        if(i==1){ //change demo to level1
             Game.getInstance().setDemo(false);
             return;
        }
        if (i >= 5) {
            rightLives = getLives();
            setLives(0);
        }
        changeLevel(i);
        try {
            Game.getInstance().renderScreen();
            Game.getInstance().changeAudioLevel(i);
            Game.getInstance().pause();
            Thread.sleep(2500);
            Game.getInstance().resume();//wait 2,5 sec and often shows the next level
        } catch (InterruptedException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void changeLevel(int numlevel) { // Livello 1-2: mondo 1; Livello 3-4: mondo 2
        mobs = new ArrayList<>();
        bombs = new ArrayList<>();
        if (numlevel < 5) {
            try {
                int combination = new Random(System.currentTimeMillis()).nextInt(2) + 1;
                String path;
                 if (numlevel == 0) {
                    path = "./resources/levels/Demo.txt";
                } else {
                    path = "./resources/levels/nextlevel/Level" + numlevel + " " + combination + ".txt";
                }
                BufferedReader in;
                String data;
                in = new BufferedReader(new FileReader(path));
                data = in.readLine();
                StringTokenizer tokens = new StringTokenizer(data);
                int l = Integer.parseInt(tokens.nextToken());
                world = tokens.nextToken();
                input = getRightKeyboard();
                if (world.equals("G")) {
                    level = new GrassFileLevel(path, in, l);
                } else {
                    level = new IceFileLevel(path, in, l);
                }
                in.close();
                entities = level.createEntities();
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Level's file .txt not found", "alert", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Loading file not successfully done", "alert", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "File syntax not correct", "alert", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Return a boolean that say if there is enemies alive in the map or not.
     *
     * @return true if there is not enemies alive in the map, false otherwise.
     */
    public boolean detectNoEnemies() {
        return mobs.size() == 1;
    }

    /*
    |--------------------------------------------------------------------------
    | Getters And Setters
    |--------------------------------------------------------------------------
     */
    public Entity getEntity(double x, double y, Mob m) {
        Entity res = null;
        res = getExplosionAt((int) x, (int) y);
        if (res != null) {
            return res;
        }
        res = getBombAt(x, y);
        if (res != null) {
            return res;
        }
        ArrayList<Mob> list = getMobsAtExcluding((int) x, (int) y, m);
        if (!list.isEmpty()) {
            res = list.get(0);
        }
        if (res != null) {
            return res;
        }
        res = getEntityAt((int) x, (int) y);
        return res;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    protected Bomb getBombAt(double x, double y) {
        Iterator<Bomb> bs = bombs.iterator();
        Bomb b;
        while (bs.hasNext()) {
            b = bs.next();
            if (b.getX() == (int) x && b.getY() == (int) y) {
                return b;
            }
        }
        return null;
    }

    public Player getPlayer() {
        return (Player) mobs.get(0);
    }

    public ArrayList<Mob> getMobsAtExcluding(int x, int y, Mob a) {
        Iterator<Mob> itr = mobs.iterator();
        ArrayList<Mob> mobs1 = new ArrayList();
        Mob cur;
        while (itr.hasNext()) {
            cur = itr.next();
            if (cur == a) {
                continue;
            }
            if (cur.getXTile() == x && cur.getYTile() == y) {
                mobs1.add(cur);
            }
        }
        return mobs1;
    }

    private Explosion getExplosionAt(int x, int y) {
        Iterator<Bomb> bs = bombs.iterator();
        Bomb b;
        while (bs.hasNext()) {
            b = bs.next();
            Explosion e = b.explosionAt(x, y);
            if (e != null) {
                return e;
            }
        }
        return null;
    }

    protected Entity getEntityAt(double x, double y) {
        return entities[(int) x + (int) y * FileLevel.WIDTH];
    }

    /*
    |--------------------------------------------------------------------------
    | Adds and Removes
    |--------------------------------------------------------------------------
     */
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
    protected void renderMobs() {
        Iterator<Mob> itr = mobs.iterator();
        while (itr.hasNext()) {
            itr.next().render(screen);
        }
    }

    /*
    |--------------------------------------------------------------------------
    | Updates
    |--------------------------------------------------------------------------
     */
    private void updateMobs() {
        ListIterator<Mob> itr = mobs.listIterator(mobs.size());
        while (itr.hasPrevious()) {
            itr.previous().update();
        }
    }

    private void updateEntities() {
        for (int i = 0; i < entities.length; i++) {
            entities[i].update();
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
        return level.getLevel();
    }

    /**
     *
     */
    private void updateBombs() {
        Iterator<Bomb> itr = bombs.iterator();
        while (itr.hasNext()) {
            itr.next().update();
        }
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
     */
    private void renderBombs() {
        Iterator<Bomb> itr = bombs.iterator();
        while (itr.hasNext()) {
            itr.next().render(screen);
        }
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
        while (itr.hasNext()) {
            cur = itr.next();
            if (cur.getXTile() == x && cur.getYTile() == y) {
                return cur;
            }
        }
        return null;
    }

    private Keyboard getRightKeyboard() {
        if (player == 1 || world.equals("G")) {
            Keyboard.getInstance().setIce(false);
            return Keyboard.getInstance();
        }
        Keyboard.getInstance().setIce(true);
        return Keyboard.getInstance();
    }

    @Override
    public void update(Observable o, Object arg) {
        Player pl = (Player) o;
        if (pl.isSuperPlayer()) {
            double x = mobs.get(0).getX();
            double y = mobs.get(0).getY();
            oldPlayer.setX(x);
            oldPlayer.setY(y);
            oldPlayer.setInput(getRightKeyboard());
            Game.getInstance().resetProperties();
            for (Mob m : mobs) {
                if (!m.isPlayer()) {
                    if (Coordinates.pixelToTile(abs(x - m.getX())) < 1 && Coordinates.pixelToTile(abs(y - m.getY())) < 1) {
                        m.kill();
                    }
                }
            }
            mobs.set(0, oldPlayer);
            for (int i = 1; i < mobs.size(); i++) {
                EnemyPower enemyPower = ((Enemy) mobs.get(i)).getEp();
                if (enemyPower.isPlayerReferenceUpdatable()) {
                    enemyPower.updateReferencePlayer(oldPlayer);
                }
            }
            timer.cancel();
            timer = new Timer();
        } else {
            if (pl.isAlive()) {
                Player p = getPlayer();
                p = new SuperPlayer(p);
                oldPlayer = (Player) mobs.set(0, p);
                //player is the first element of the list mobs
                for (int i = 1; i < mobs.size(); i++) {
                    EnemyPower enemyPower = ((Enemy) mobs.get(i)).getEp();
                    if (enemyPower.isPlayerReferenceUpdatable()) {
                        enemyPower.updateReferencePlayer(p);
                    }
                }
                ((SuperPlayer) p).setGraphicalExtension((SuperPlayer) p);
                timer.schedule(new ScheduleTask(), 30000);
            } else {
//                if (getLevel() == 0 && Game.getInstance().getDemo()) {
//                    resetPoints();
//                    lives = SettingsGame.getLives();
//                    try {
//                        Game.getInstance().setDemo(false);
//                        nextLevel();             
//                    } catch (IOException ex) {
//                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    Game.getInstance().restartGame();
//                    setChanged();
//                    notifyObservers();
//                } else {
                    setChanged();
                    notifyObservers();
//                }
            }
        }
    }

    public void setInput() {
        Keyboard.getInstance().setIce(false);
        input = Keyboard.getInstance();
    }

    public void setPlayer(int p) {
        player = p;
    }

    public int getPlayerRight() {
        return player;
    }

    public int getPoints() {
        return points;
    }

    public ContextDestroyable getContextState() {
        return con;
    }

    public List<DestroyableIceTile> getDestroyableIceTile() {
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

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }
    
    public static void setBoard(){
        instance=null;
        instance=getInstance();
    }

    public void resetPoints() {
        points = 0;
    }

    public int getRightLives() {
        return rightLives;
    }

    public void changeLives(int lives) {
        this.lives += lives;
        setChanged();
        notifyObservers();
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            double x = mobs.get(0).getX();
            double y = mobs.get(0).getY();
            oldPlayer.setX(x);
            oldPlayer.setY(y);
            oldPlayer.setInput(getRightKeyboard());
            Game.getInstance().resetProperties();
            mobs.set(0, oldPlayer);
            for (int i = 1; i < mobs.size(); i++) {
                EnemyPower enemyPower = ((Enemy) mobs.get(i)).getEp();
                if (enemyPower.isPlayerReferenceUpdatable()) {
                    enemyPower.updateReferencePlayer(oldPlayer);
                }
            }
        }
    }
}
