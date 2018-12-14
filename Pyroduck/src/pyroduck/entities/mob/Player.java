package pyroduck.entities.mob;

import java.util.*;
import java.util.logging.*;
import pyroduck.*;
import pyroduck.bomb.*;
import pyroduck.entities.Entity;
import pyroduck.entities.tile.Tile;
import pyroduck.entities.tile.destroyable.*;
import pyroduck.entities.tile.powerup.*;
import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.*;
import pyroduck.input.Keyboard;
import pyroduck.level.*;

/**
 * Describes the behavior of the player controllable via keyboard.
 * Is used to manage the behavior of the player calculating where it can move and directing the moviment.
 * it is also delegated to manage the undermining the bombs.
 * @author Montefusco, Nappi
 * @version 1.0
 */
public class Player extends Mob{

    protected Keyboard input;
    protected List<Bomb> bombs = null;
    protected int timeBetweenPutBombs = 0;
    public static List<Powerup> powerups = new ArrayList<Powerup>();
    protected int lives = 3;
    protected boolean done = false;
    public static int realWidth = 32, realHeight = 32;

    /**
     * Creates an instance of the player.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     */
    public Player(int x, int y) {
        super(x, y);
        bombs = Board.getInstance().getBombs();
        input = Board.getInstance().getInput();
        addObserver(Board.getInstance());
    }



    /*
    |--------------------------------------------------------------------------
    | Update & Render
    |--------------------------------------------------------------------------
     */

    /**
     * Allows to update the state of player checking if something is changed.
     * Updates the state of the bomb and the related animation at the player,
     * it calculates the movement and it checks if he has placed a bomb.
     */
    @Override
    public void update() {
        clearBombs();
        if(done == false){
            correctKeyboard();
            done = true;
        }
        if(alive == false) {
            afterKill();
            return;
        }
        if(timeBetweenPutBombs < -7500)
            timeBetweenPutBombs = 0;
        else
            --timeBetweenPutBombs;
        animate();
        calculateMove();
        detectPlaceBomb();
        updateTimerBreaker();
    }

    /**
     *
     * @param screen
     */
    @Override
    public void render(Screen screen) {
        calculateXOffset();
        if(alive)
            chooseSprite();
        else
            try {
                if(Game.getInstance().getSelected() == 0){
                    sprite = Sprite.player_dead1;
                }
                else{
                    sprite = Sprite.player_dead1i;
                }
        } catch (PyroduckException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        screen.renderEntity((int)x, (int)y - sprite.SIZE, this);
    }

    /**
     *
     */
    public void calculateXOffset() {
        int xScroll = Screen.calculateXOffset(this);
        Screen.setOffset(xScroll, 0);
    }

    /*
    |--------------------------------------------------------------------------
    | Mob Movement
    |--------------------------------------------------------------------------
     */
    /**
     *
     */
    @Override
    protected void calculateMove() {
        int xa = 0, ya = 0;
        if(input.up) ya--;
        if(input.down) ya++;
        if(input.left) xa--;
        if(input.right) xa++;
        if(xa != 0 || ya != 0)  {
            try {
                move(xa * Game.getInstance().getPlayerSpeed(), ya *Game.getInstance().getPlayerSpeed());
            } catch (PyroduckException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            moving = true;
        } else {
            moving = false;
        }
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean canMove(double x, double y) {
        for (int c = 0; c < 4; c++) { //colision detection for each corner of the player
            double xt = ((this.x + x) + c % 2 * 24 +2) / Game.TILES_SIZE; //
            double yt = ((this.y + y) + c / 2 * 15 - 16) / Game.TILES_SIZE; // the multiply factor control bottom collision and the additional factor control top collision
            Entity a = Board.getInstance().getEntity(xt, yt, this);
            DestroyableIceTile newState;
            ContextDestroyable con = Board.getInstance().getContextState();
            if(a.isTile() && (((Tile)a).isDestroyableIceTile())){ //new features here!!!- - - - - - - - - - - -
                con.setState((DestroyableIceTile)a);
                if(((DestroyableIceTile) a).getTimerBreak()<=0) { // differences to see if the player has moved out of the bomb, tested values
                    ((DestroyableIceTile) a).setTimerBreak(80);
                    newState = con.getState().nextState(con);
                    Board.getInstance().getDestroyableIceTile().add(newState);
                    Board.getInstance().entities[((int)xt + (int)yt * FileLevel.WIDTH)] = con.getState();
                }
            }
            if(a.collide(this))
                return false;
        }
        return true;
    }

    /**
     *
     * @param xa
     * @param ya
     */
    @Override
    public void move(double xa, double ya) {
        if(xa > 0)
            direction = 1;
        if(xa < 0)
            direction = 3;
        if(ya > 0)
            direction = 2;
        if(ya < 0)
            direction = 0;
        if(canMove(0, ya)) { //separate the moves for the player can slide when is colliding
            this.y += ya;
        }
        if(canMove(xa, 0)) {
            this.x += xa;
        }
    }

    /*
    |--------------------------------------------------------------------------
    | Mob Sprite
    |--------------------------------------------------------------------------
     */
    /**
     *
     */
    protected void chooseSprite() {
        try {
            if( Game.getInstance().getSelected() == 0){
                    switch(direction) {
                        case 0:
                            sprite = Sprite.player_up;
                            if(moving) {
                                if(input.isIce())
                                    sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_1, animate, 30);
                                else
                                    sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = Sprite.player_right;
                            if(moving) {
                                if(input.isIce())
                                    sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_1, animate, 30);
                                else
                                    sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = Sprite.player_down;
                            if(moving) {
                                if(input.isIce())
                                    sprite = Sprite.movingSprite(Sprite.player_down_1, Sprite.player_down_1, animate, 30);
                                else
                                    sprite = Sprite.movingSprite(Sprite.player_down_1, Sprite.player_down_2, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = Sprite.player_left;
                            if(moving) {
                                if(input.isIce())
                                    sprite = Sprite.movingSprite(Sprite.player_left_1, Sprite.player_left_1, animate, 30);
                                else
                                    sprite = Sprite.movingSprite(Sprite.player_left_1, Sprite.player_left_2, animate, 30);
                            }
                            break;
                        default:
                            sprite = Sprite.player_right;
                            if(moving) {
                                if(input.isIce())
                                    sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_1, animate, 30);
                                else
                                    sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, animate, 30);
                            }
                            break;
                    }


            }else{
                    switch(direction) {
                        case 0:
                            sprite = Sprite.player_upi;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_up_1i, Sprite.player_up_2i, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = Sprite.player_righti;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1i, Sprite.player_right_2i, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = Sprite.player_downi;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_down_1i, Sprite.player_down_2i, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = Sprite.player_lefti;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_left_1i, Sprite.player_left_2i, animate, 30);
                            }
                            break;
                        default:
                            sprite = Sprite.player_righti;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1i, Sprite.player_right_2i, animate, 30);
                            }
                            break;
                    }
                }

        } catch (PyroduckException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean collide(Entity e) {
        if(e.isExplosion()) {
            kill();
            return true;
        }
        if(e.isMob() && !(((Mob)e).isPlayer())) {
            if(checkRealCollision(e, 0.2)){
                kill();
                return true;
            }
        }
        return false;
    }

    /**
     *
     */
    protected void detectPlaceBomb() {
        try {
            if(input.space && Game.getInstance().getBombRate() > 0 && timeBetweenPutBombs < 0) {
                int xt = Coordinates.pixelToTile(x + sprite.getSize() / 2);
                int yt = Coordinates.pixelToTile( (y + sprite.getSize() / 2) - sprite.getSize() ); //subtract half player height and minus 1 y position
                placeBomb(xt,yt);
                Game.getInstance().addBombRate(-1);
                timeBetweenPutBombs = 30;
            }
        } catch (PyroduckException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param x
     * @param y
     */
    protected void placeBomb(int x, int y) {
        Bomb b = new Bomb(x, y);
        Board.getInstance().addBomb(b);
    }

    /**
     *
     */
    protected void clearBombs() {
        Iterator<Bomb> bs = bombs.iterator();
        Bomb b;
        while(bs.hasNext()) {
            b = (Bomb) bs.next();
            if(b.isRemoved())  {
                try {
                    bs.remove();
                    Game.getInstance().addBombRate(1);
                } catch (PyroduckException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     *
     */
    public void correctKeyboard(){
        if(Board.getInstance().getPlayerRight() == 1){
           Board.getInstance().setInput();
           input = Board.getInstance().getInput();
        }
    }

     /*
    |--------------------------------------------------------------------------
    | Powerups
    |--------------------------------------------------------------------------
     */
    /**
     *
     * @param p
     */
    public void addPowerup(Powerup p) {
        if(p instanceof PowerupVehicles){
            setChanged();
            notifyObservers();
        }      
        if(!p.isRemoved()) {
            powerups.add(p);
            p.setValues();
        }
    }

    /*
    |--------------------------------------------------------------------------
    | Mob Colide & Kill
    |--------------------------------------------------------------------------
     */
    /**
     *
     */
    @Override
    public void kill() {
        if(!alive)
            return;
        alive = false;
            Board.getInstance().changeLives(-1);
        setChanged();
        notifyObservers();
    }

    /**
     *
     */
    @Override
    protected void afterKill() {
        if(timeAfter > 0)
            --timeAfter;
        else {
            if(bombs.isEmpty()) {
                if(Board.getInstance().getLives() != 0){
                    Board.getInstance().restartLevel();
                }  
            }
        }
        Board.getInstance().resetProperties();      
    }

    protected void updateTimerBreaker(){
        for(DestroyableIceTile d : Board.getInstance().getDestroyableIceTile())
            if(d.getTimerBreak()>0)
                d.setTimerBreak(d.getTimerBreak()-1);
    }
    
    @Override
    public boolean isPlayer() {
        return true;
    }
    
    public void setInput(Keyboard k){
        input = k;
    }
    
    public boolean isSuperPlayer() {
        return false;
    }
}