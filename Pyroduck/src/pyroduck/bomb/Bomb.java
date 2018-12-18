package pyroduck.bomb;

import pyroduck.*;
import pyroduck.entities.*;
import pyroduck.entities.mob.*;
import pyroduck.graphics.*;
import pyroduck.level.Coordinates;

/**
 * Represents the explosive entities Is used to manage explosion events.
 *
 * @author Bini, Petruzzello
 */
public class Bomb extends AnimatedEntity {

    protected double timeToExplode = 120; //2 seconds
    public int timeAfter = 20; //time to explosions disapear
    protected boolean allowedToPassThru = false;
    protected DirectionalExplosion[] explosions = null;
    protected boolean exploded = false;

    /**
     * Creates an instance of the Bomb.
     *
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordinate in pixels.
     */
    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
        sprite = Sprite.bomb;
    }

    /**
     * Allows to update the state of the bomb and it checks if something is
     * changed Particularly it updates the animation and checks if the explosion
     * timer is expired and manage the explosion and its removal.
     */
    @Override
    public void update() {
        if (timeToExplode > 0) {
            timeToExplode--;
        } else {
            if (!exploded) {
                explosion();
            } else {
                updateExplosions();
            }
            if (timeAfter > 0) {
                timeAfter--;
            } else {
                remove();
            }
        }
        animate();
    }

    /**
     * Checks which animation must appear on the screen. It also invokes the
     * method to print on the screen.
     *
     * @param screen screen on which the print is called.
     */
    @Override
    public void render(Screen screen) {
        if (exploded) {
            sprite = Sprite.bomb_exploded2;
            renderExplosions(screen);
        } else {
            sprite = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, animate, 30);
        }
        int xt = (int) x << 5;
        int yt = (int) y << 5;
        screen.renderEntity(xt, yt, this);
    }

    /**
     * Cares about printing of each interested tile in the explosion.
     *
     * @param screen
     */
    public void renderExplosions(Screen screen) {
        for (int i = 0; i < explosions.length; i++) {
            explosions[i].render(screen);
        }
    }

    /**
     *
     */
    public void updateExplosions() {
        for (int i = 0; i < explosions.length; i++) {
            explosions[i].update();
        }
    }

    /**
     * Manages the bomb explosion creating new DirectionalExplosion.
     */
    protected void explosion() {
        allowedToPassThru = false;
        exploded = true;
        Mob a = Board.getInstance().getMobAt(x, y);
        if (a != null) {
            a.kill();
        }
        explosions = new DirectionalExplosion[4];
        for (int i = 0; i < explosions.length; i++) {
            explosions[i] = new DirectionalExplosion((int) x, (int) y, i, Game.getInstance().getBombRadius());
        }
    }

    /**
     * Checks if an explosion is happend in a certain position.
     *
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @return the Explosion object present in a (x,y) coordinates.
     */
    
    
    /*Eventualmente da correggere*/
    public Explosion explosionAt(int x, int y) {
        if (exploded) {
            if (explosions != null) {
                for (int i = 0; i < explosions.length; i++) {
                    if (explosions[i] == null) {
                        return null;
                    }
                    Explosion e = explosions[i].explosionAt(x, y);
                    if (e != null) {
                        return e;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Checks if the bomb is exploded.
     *
     * @return true if the bomb is exploded, false otherwise.
     */
    public boolean isExploded() {
        return exploded;
    }

    /**
     * Return true if the entity is overlapped by the bomb, false otherwise.
     *
     * @param e e is the entity which must be checked for the collision.
     * @return true if the entity is overlapped by the bomb, false otherwise.
     */
    @Override
    public boolean collide(Entity e) {
        if (e.isMob() && (((Mob) e).isPlayer())) {
            double diffX = e.getX() - Coordinates.tileToPixel(getX());
            double diffY = e.getY() - Coordinates.tileToPixel(getY());
            if (!(diffX >= -26 && diffX < 30 && diffY >= 1 && diffY <= 47)) { // differences to see if the player has moved out of the bomb, tested values
                allowedToPassThru = true;
            }
            if(Game.getInstance().getDemo()){
                Message.setMessage("Press SPACE or X to place a bomb");
            }
            return allowedToPassThru;
        }
        if (e.isExplosion()) {
            timeToExplode = 0;
            return false;
        }
        return true;
    }

    @Override
    public boolean isBomb() {
        return true;
    }

    public boolean isMissile() {
        return false;
    }
}