package pyroduck.entities.mob;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.bomb.Bomb;
import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.enemy.graphic.Enemy;
import pyroduck.entities.tile.destroyable.ContextDestroyable;
import pyroduck.entities.tile.destroyable.DestroyableIceTile;
import pyroduck.entities.tile.powerup.Powerup;
import pyroduck.entities.tile.powerup.PowerupLife;
import pyroduck.entities.tile.powerup.PowerupNotSlip;
import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.input.GrassKeyboard;
import pyroduck.input.Keyboard;
import pyroduck.level.Coordinates;
import pyroduck.level.FileLevel;

/**
 * Describes the behavior of the player controllable via keyboard.
 * Is used to manage the behavior of the player calculating where it can move and directing the moviment.
 * it is also delegated to manage the undermining the bombs.
 * @author Montefusco, Nappi
 * @version 1.0
 */
public class Player extends Mob {
	
    protected Keyboard input;
    protected List<Bomb> bombs = null;
    protected int timeBetweenPutBombs = 0;
    public static List<Powerup> powerups = new ArrayList<Powerup>();
    private int lives = 3;
    private ContextDestroyable con;
    /**
     * Creates an instance of the player.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param board to take the keyboard related at the player commands.
     */
    public Player(int x, int y, Board board) {
        super(x, y, board);
        bombs = board.getBombs();
        input = board.getInput();
        con = new ContextDestroyable();
        addObserver(board);
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
        if(alive == false) {
            afterKill();
            return;
        }
        if(timeBetweenPutBombs < -7500) 
            timeBetweenPutBombs = 0; 
        else 
            --timeBetweenPutBombs;

        animate(); 
//        if(level==2)
//            calculateMoveIce();

        animate();

        calculateMove();
        detectPlaceBomb();
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
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        screen.renderEntity((int)x, (int)y - sprite.SIZE, this);
    }

    /**
     * 
     */
    public void calculateXOffset() {
        int xScroll = Screen.calculateXOffset(board, this);
        Screen.setOffset(xScroll, 0);
    }

    /*
    |--------------------------------------------------------------------------
    | Mob Movement
    |--------------------------------------------------------------------------
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

    @Override
    public boolean canMove(double x, double y) {
        for (int c = 0; c < 4; c++) { //colision detection for each corner of the player
            double xt = ((this.x + x) + c % 2 * 24 +2) / Game.TILES_SIZE; // 
            double yt = ((this.y + y) + c / 2 * 15 - 16) / Game.TILES_SIZE; // the multiply factor control bottom collision and the additional factor control top collision
            Entity a = board.getEntity(xt, yt, this);
            double diffX = a.getX() - Coordinates.tileToPixel(getX());
            double diffY = a.getY() - Coordinates.tileToPixel(getY());
            if(a instanceof DestroyableIceTile){ //new features here!!!- - - - - - - - - - - -               
                con.setState((DestroyableIceTile)a);
                if((!(diffX >= -26 && diffX < 30 && diffY >= 1 && diffY <= 47)) && con.getState().getChange()) { // differences to see if the player has moved out of the bomb, tested values
                    con.getState().nextState(con);
                    con.getState().setChange(false);
                    board.entities[((int)xt + (int)yt * FileLevel.WIDTH)] = con.getState();
                }              
            }

            
            if(a.collide(this)){
                return false;
            }       
        }
        return true;
    }

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
    private void chooseSprite() {
        try {
            if( Game.getInstance().getSelected()==0){
                if(input instanceof GrassKeyboard){
                    switch(direction) {
                        case 0:
                            sprite = Sprite.player_up;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = Sprite.player_right;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = Sprite.player_down;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_down_1, Sprite.player_down_2, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = Sprite.player_left;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_left_1, Sprite.player_left_2, animate, 30);
                            }
                            break;
                        default:
                            sprite = Sprite.player_right;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, animate, 30);
                            }
                            break;
                    }
                }
                else{
                    switch(direction) {
                        case 0:
                            sprite = Sprite.player_up;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_1, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = Sprite.player_right;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_1, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = Sprite.player_down;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_down_1, Sprite.player_down_1, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = Sprite.player_left;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_left_1, Sprite.player_left_1, animate, 30);
                            }
                            break;
                        default:
                            sprite = Sprite.player_right;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_1, animate, 30);
                            }
                            break;
                    }
                }
            }else{
                if(input instanceof GrassKeyboard){
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
                else{
                    switch(direction) {
                        case 0:
                            sprite = Sprite.player_upi;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_up_1i, Sprite.player_up_1i, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = Sprite.player_righti;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1i, Sprite.player_right_1i, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = Sprite.player_downi;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_down_1i, Sprite.player_down_1i, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = Sprite.player_lefti;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_left_1i, Sprite.player_left_1i, animate, 30);
                            }
                            break;
                        default:
                            sprite = Sprite.player_righti;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1i, Sprite.player_right_1i, animate, 30);
                            }
                            break;
                    }
                }
            }
        } catch (PyroduckException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public boolean collide(Entity e) {
        if(e instanceof DirectionalExplosion) {
            kill();
            return true;
        }
        if(e instanceof Enemy) {
            kill();
            return false;
        }
        return false;
    }
    
    private void detectPlaceBomb() {
        if(input.space && Game.getBombRate() > 0 && timeBetweenPutBombs < 0) {
            int xt = Coordinates.pixelToTile(x + sprite.getSize() / 2);
            int yt = Coordinates.pixelToTile( (y + sprite.getSize() / 2) - sprite.getSize() ); //subtract half player height and minus 1 y position
            placeBomb(xt,yt);
            Game.addBombRate(-1);
            timeBetweenPutBombs = 30;
        }
    }

    protected void placeBomb(int x, int y) {
        Bomb b = new Bomb(x, y, board);
        board.addBomb(b);
    }

    private void clearBombs() {
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
    
     /*
    |--------------------------------------------------------------------------
    | Powerups
    |--------------------------------------------------------------------------
     */
    public void addPowerup(Powerup p) {
        if(p instanceof PowerupNotSlip){
            board.setInput();
            input = board.getInput();
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
    @Override
    public void kill() {
        if(!alive) 
            return;
        alive = false;
        try {
            Game.getInstance().addLives(-1);
        } catch (PyroduckException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        setChanged();
        notifyObservers();
    }

    @Override
    protected void afterKill() {
        if(timeAfter > 0) 
            --timeAfter;
        else {
            if(bombs.isEmpty()) {
                if(board.getLives() == 0){
                    board.endGame();
                }else
                    try {
                        board.restartLevel();
                } catch (IOException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}