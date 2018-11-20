package pyroduck.entities;

import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;

/**
 * The abstract class that rapresent the backbone of each entity.
 * It fix the main behavior of all entities that can appear on the map.
 * @author
 * @version 1.0
*/
public abstract class Entity {

    protected double x, y;
    protected boolean removed = false;
    protected Sprite sprite;

    /**
     * It allow to update the state of entity to check if it is change something.
     */
    public abstract void update();

    /**
     * The implementation of this method invoke the screen's method to print the entity on screen.
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
     * Check if the entity must be removed.
     * @return true if the entity must be removed, false otherwise.
     */
    public boolean isRemoved() {
        return removed;
    }

    /**
     * The implementation of this method check if two entities can collide with each other.
     * @param e is the entity with which is checked the collision.
     * @return true if the entities can collide with each other, false otherwise.
     */
    public abstract boolean collide(Entity e);

    /**
     * Getter that return the sprite that represent the entity.
     * @return the sprite related at the entity.
     */
    public Sprite getSprite() {
        return sprite;
    }
    
    /**
     * Getter that return the <b>x</b> position of the entity on the screen.
     * @return <b>x</b> coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Getter that return the <b>y</b> position of the entity on the screen.
     * @return <b>y</b> coordinate.
     */
    public double getY() {
        return y;
    }
}