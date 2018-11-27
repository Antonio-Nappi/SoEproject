package pyroduck.entities.mob;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.bomb.Bomb;
import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.Entity;
<<<<<<< HEAD
import pyroduck.entities.mob.enemy.Enemy;
=======
import pyroduck.entities.Message;
>>>>>>> parent of 63a8edf... Add collision between "Player" and "Bomb"
import pyroduck.entities.tile.powerup.Powerup;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.input.Keyboard;
import pyroduck.level.Coordinates;

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

    /**
     * Creates an instance of the player.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param board to take the keyboard related at the player commands.
     */
    public Player(int x, int y, Board board) {
        super(x, y, board);
        bombs = board.getBombs();
        this.input = board.getInput();
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
        if(timeBetweenPutBombs < -7500) 
            timeBetweenPutBombs = 0; 
        else 
            --timeBetweenPutBombs;
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
        chooseSprite();
        screen.renderEntity((int)x, (int)y - sprite.SIZE, this);
    }

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
            move(xa * Game.getPlayerSpeed(), ya * Game.getPlayerSpeed());
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
            Entity a = board.getEntity(xt, yt);
            if(a.collide(this))
                return false;
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
        switch(direction) {
            case 0:
                sprite = Sprite.player_up;
                if(moving) {
                    sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, animate, 20);
                }
                break;
            case 1:
                sprite = Sprite.player_right;
                if(moving) {
                    sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, animate, 20);
                }
                break;
            case 2:
                sprite = Sprite.player_down;
                if(moving) {
                    sprite = Sprite.movingSprite(Sprite.player_down_1, Sprite.player_down_2, animate, 20);
                }
                break;
            case 3:
                sprite = Sprite.player_left;
                if(moving) {
                    sprite = Sprite.movingSprite(Sprite.player_left_1, Sprite.player_left_2, animate, 20);
                }
                break;
            default:
                sprite = Sprite.player_right;
                if(moving) {
                    sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, animate, 20);
                }
                break;
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
        if(!alive) return;
        alive = false;
        board.addLives(-1);
        Message msg = new Message("-1 LIVE", getXMessage(), getYMessage(), 2, Color.white, 14);
        board.addMessage(msg);
    }

    @Override
    protected void afterKill() {
        if(timeAfter > 0) --timeAfter;
        else {
            if(bombs.size() == 0) {
                if(board.getLives() == 0)
                    board.endGame();
                else
                    board.restartLevel();
            }
        }
    }
}