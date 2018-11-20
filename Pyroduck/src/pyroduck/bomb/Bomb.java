package pyroduck.bomb;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.AnimatedEntity;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.level.Coordinates;

/**
 * Represent the entities able to explode.
 * It is used to manage explosion events.
 * @author Bini, Petruzzello
 */
public class Bomb extends AnimatedEntity {

    protected double timeToExplode = 120; //2 seconds
    public int timeAfter = 20; //time to explosions disapear
    protected Board board;
    protected boolean allowedToPassThru = false;
    protected DirectionalExplosion[] explosions = null;
    protected boolean exploded = false;

    /**
     * Constructor creates an instance of the Bomb.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param board ...
     */
    public Bomb(int x, int y,Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
        sprite = Sprite.bomb;
    }

    /**
     * It allow to update the state of bomb to check if it is change something.
     * In particulary it updates the animation, checks if the explosion timer is expired and commands the explosion and removal.
     */
    @Override
    public void update() {
        if(timeToExplode > 0) 
            timeToExplode--;
        else {
            if(!exploded) 
                explosion();
            if(timeAfter > 0) 
                timeAfter--;
            else
                remove();
        }
        animate();
    }

    /**
     * Check which animation must be appear on the screen and invoke the method for the screen print.
     * @param screen screen on which the print is called. 
     */
    @Override
    public void render(Screen screen) {
        if(exploded) {
            sprite =  Sprite.bomb_exploded2;
            renderExplosions(screen);
        } else
            sprite = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, animate, 30);
        int xt = (int)x << 5;
        int yt = (int)y << 5;
        screen.renderEntity(xt, yt , this);
    }

    /**
     * Command the print of each tile related at the explosion range.
     * @param screen 
     */
    public void renderExplosions(Screen screen) {
        for (int i = 0; i < explosions.length; i++) {
            explosions[i].render(screen);
        }
    }

    /**
     * Manage the bomb explosion creating new DirectionalExplosion.
     */
    protected void explosion() {
        allowedToPassThru = false;
        exploded = true;
        explosions = new DirectionalExplosion[4];
        for (int i = 0; i < explosions.length; i++) {
            explosions[i] = new DirectionalExplosion((int)x, (int)y, i, Game.getBombRadius(), board);
        }
    }

    /**
     * Check if an explosion occurred in a certain position.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @return the Explosion object present in a (x,y) coordinates.
     */
    public Explosion explosionAt(int x, int y) {
        if(!exploded) 
            return null;
        for (int i = 0; i < explosions.length; i++) {
            if(explosions[i] == null) 
                return null;
            Explosion e = explosions[i].explosionAt(x, y);
            if(e != null) 
                return e;
        }
        return null;
    }

    /**
     * Check if the bomb is exploded.
     * @return true if the bomb is exploded, false otherwise.
     */
    public boolean isExploded() {
            return exploded;
    }

    /**
     * Check if an entity can overlap with the bomb.
     * @param e entity with which must be check the collision.
     * @return true if the entity can overlap with the bomb, false otherwise.
     */
    @Override
    public boolean collide(Entity e) {
        if(e instanceof Player) {
            double diffX = e.getX() - Coordinates.tileToPixel(getX());
            double diffY = e.getY() - Coordinates.tileToPixel(getY());
            if(!(diffX >= -26 && diffX < 32 && diffY >= 1 && diffY <= 47)) { // differences to see if the player has moved out of the bomb, tested values
                allowedToPassThru = true;
            }
            return allowedToPassThru;
        }
        if(e instanceof DirectionalExplosion) {
            timeToExplode = 0;
            return false;
        }
        return true;
    }
}