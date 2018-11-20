package pyroduck.entities.tile;

import pyroduck.entities.Entity;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.level.Coordinates;

/**
 * Represent the abstract class of each non-animated entity.
 * It is used to menage the interaction of this entities with the other.
 * @author 
 * @version 1.0
 */
public abstract class Tile extends Entity {

    /**
     * Constructor that create an object of this class.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param sprite related to the entity.
     */
    public Tile(int x, int y, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    /**
     * The implementation of this method it allow to update the state of entity to check if it is change something.
     */
    @Override
    public void update() {}
    
    /**
     * Invoke the screen's method to print the entity on screen.
     * @param screen screen on which the print is called.
     */
    @Override
    public void render(Screen screen) {
        screen.renderEntity(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y), this);
    }
    
    /**
     * Check if two entities can collide with each other.
     * For these entities the possibility of colliding is set true by default, so these entities cannot overlap with the others.
     * @param e is the entity with which is checked the collision.
     * @return true if the entities can collide with each other, false otherwise.
     */
    @Override
    public boolean collide(Entity e) {
        return true;
    }
}