package pyroduck.entities.mob;

import java.util.*;
import java.util.logging.*;
import pyroduck.*;
import pyroduck.bomb.*;
import pyroduck.entities.*;
import pyroduck.entities.mob.enemy.graphic.*;
import pyroduck.entities.tile.destroyable.*;
import pyroduck.entities.tile.powerup.*;
import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.*;
import pyroduck.input.*;
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
    
    private final Sprite player_up = new Sprite(0, 2 );
        
    private final Sprite player_down = new Sprite(0, 1);

    private final Sprite player_left = new Sprite(0, 3 );
    private final Sprite player_right = new Sprite(0, 4);

    private final Sprite player_up_1 = new Sprite(1, 2);
    private final Sprite player_up_2 = new Sprite(2, 2);

    private final Sprite player_down_1 = new Sprite(1, 1);
    private final Sprite player_down_2 = new Sprite(2, 1);

    private final Sprite player_left_1 = new Sprite(1, 3);
    private final Sprite player_left_2 = new Sprite(2, 3);

    private final Sprite player_right_1 = new Sprite(1, 4);
    private final Sprite player_right_2 = new Sprite(2, 4);

    private final Sprite player_dead1 = new Sprite(3, 2);
    private final Sprite player_dead2 = new Sprite(3, 3);
    private final Sprite player_dead3 = new Sprite(3, 4);
    
    
     final Sprite player_upi = new Sprite(0, 6);
     final Sprite player_downi = new Sprite(0, 5);
     final Sprite player_lefti = new Sprite(0, 7);
     final Sprite player_righti = new Sprite(0, 8);

     final Sprite player_up_1i = new Sprite(1, 6);
     final Sprite player_up_2i = new Sprite(2, 6);

     final Sprite player_down_1i = new Sprite(1, 5);
     final Sprite player_down_2i = new Sprite(2, 5);

     final Sprite player_left_1i = new Sprite(1, 7);
     final Sprite player_left_2i = new Sprite(2, 7);

     final Sprite player_right_1i = new Sprite(1, 8);
     final Sprite player_right_2i = new Sprite(2, 8);

     final Sprite player_dead1i = new Sprite(3, 6);
     final Sprite player_dead2i = new Sprite(3, 7);
     final Sprite player_dead3i = new Sprite(3, 8 );

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
                    sprite = player_dead1;
                }
                else{
                    sprite = player_dead1i;
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
            move(xa * Game.getPlayerSpeed(), ya *Game.getPlayerSpeed());
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
            if(a instanceof DestroyableIceTile){ //new features here!!!- - - - - - - - - - - -
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
                            sprite = player_up;
                            if(moving) {
                                if(input.isIce())
                                    sprite = Sprite.movingSprite(player_up_1, player_up_1, animate, 30);
                                else
                                    sprite = Sprite.movingSprite(player_up_1, player_up_2, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = player_right;
                            if(moving) {
                                if(input.isIce())
                                    sprite = Sprite.movingSprite(player_right_1, player_right_1, animate, 30);
                                else
                                    sprite = Sprite.movingSprite(player_right_1, player_right_2, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = player_down;
                            if(moving) {
                                if(input.isIce())
                                    sprite = Sprite.movingSprite(player_down_1, player_down_1, animate, 30);
                                else
                                    sprite = Sprite.movingSprite(player_down_1, player_down_2, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = player_left;
                            if(moving) {
                                if(input.isIce())
                                    sprite = Sprite.movingSprite(player_left_1, player_left_1, animate, 30);
                                else
                                    sprite = Sprite.movingSprite(player_left_1, player_left_2, animate, 30);
                            }
                            break;
                        default:
                            sprite = player_right;
                            if(moving) {
                                if(input.isIce())
                                    sprite = Sprite.movingSprite(player_right_1, player_right_1, animate, 30);
                                else
                                    sprite = Sprite.movingSprite(player_right_1, player_right_1, animate, 30);
                            }
                            break;
                    }


            }else{
                    switch(direction) {
                        case 0:
                            sprite = player_upi;
                            if(moving) {
                                sprite = Sprite.movingSprite(player_up_1i, player_up_2i, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = player_righti;
                            if(moving) {
                                sprite = Sprite.movingSprite(player_right_1i, player_right_2i, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = player_downi;
                            if(moving) {
                                sprite = Sprite.movingSprite(player_down_1i, player_down_2i, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = player_lefti;
                            if(moving) {
                                sprite = Sprite.movingSprite(player_left_1i, player_left_2i, animate, 30);
                            }
                            break;
                        default:
                            sprite = player_righti;
                            if(moving) {
                                sprite = Sprite.movingSprite(player_right_1i, player_right_2i, animate, 30);
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
        if(e instanceof DirectionalExplosion) {
            kill();
            return true;
        }
        if(e instanceof Enemy) {
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
        if(input.space && Game.getBombRate() > 0 && timeBetweenPutBombs < 0) {
            int xt = Coordinates.pixelToTile(x + sprite.getSize() / 2);
            int yt = Coordinates.pixelToTile( (y + sprite.getSize() / 2) - sprite.getSize() ); //subtract half player height and minus 1 y position
            placeBomb(xt,yt);
            Game.addBombRate(-1);
            timeBetweenPutBombs = 30;
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
            b = bs.next();
            if(b.isRemoved())  {
                bs.remove();
                Game.addBombRate(1);
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
        if(p instanceof PowerupNotSlip){
            Board.getInstance().setInput();
            input = Board.getInstance().getInput();
        }
      
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
        try {
            Game.getInstance().addLives(-1);
        } catch (PyroduckException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        setChanged();
        notifyObservers();
    }

    /**
     *
     */
    @Override
    protected void afterKill() {
        Board.getInstance().resetPoints();
        if(timeAfter > 0)
            --timeAfter;
        else {
            if(bombs.isEmpty()) {
                if(Board.getInstance().getLives() == 0){
                    Board.getInstance().endGame();
                }else
                    Board.getInstance().restartLevel();
            }
        }
        Board.getInstance().resetProperties();
        
    }

    private void updateTimerBreaker(){
        for(DestroyableIceTile d : Board.getInstance().getDestroyableIceTile())
            if(d.getTimerBreak()>0)
                d.setTimerBreak(d.getTimerBreak()-1);
    }
}
