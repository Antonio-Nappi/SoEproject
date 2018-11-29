package pyroduck.entities;

import java.util.Observable;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.level.Coordinates;

/**
 * The abstract class represents the entities' backbone
 * Fixs the main behavior of each entity appearable on the map.
 * @author Montefusco, Nappi
 * @version 1.0
*/
public abstract class Entity extends Observable{

    protected double x, y;
    protected boolean removed = false;
    protected Sprite sprite;

    /**
    * Allows to update the state of the entity and it checks if something is changed
     */
    public abstract void update();

    /**
     * The implementation of this method invokes the screen's method to print the entity on screen.
     * @param screen screen on which the print is called.
     */
    public abstract void render(Screen screen);

    /**
     * Set the entity as to be removed.
     */
    public void remove() {
        removed = true;
    }

    /**
     * Checks if the entity must be removed.
     * @return true if the entity must be removed, false otherwise.
     */
    public boolean isRemoved() {
        return removed;
    }

    /**
     * The implementation of this method checks if two entities collide with each other.
     * @param e is the entity with which is checked the collision.
     * @return true if the entities can collide with each other, false otherwise.
     */
    public abstract boolean collide(Entity e);

    /**
     * Returns the sprite of the entity.
     * @return the sprite related at the entity.
     */
    public Sprite getSprite() {
        return sprite;
    }
    
    /**
     * Returns the <b>x</b> coordinate of the entity on the screen.
     * @return the <b>x</b> coordinate of the entity on the screen.
     */
    public double getX() {
        return x;
    }

    /**
     * Return the <b>y</b> coordinate of the entity on the screen.
     * @return <b>y</b> coordinate of the entity on the screen.
     */
    public double getY() {
        return y;
    }
    
    /**
     * 
     * @return 
     */
    public int getXTile() {
        return Coordinates.pixelToTile(x + sprite.SIZE / 2); //plus half block for precision
    }
	
    /**
     * 
     * @return 
     */
    public int getYTile() {
        return Coordinates.pixelToTile(y - sprite.SIZE / 2); //plus half block
    }
}