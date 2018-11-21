package pyroduck.entities.tile;

import pyroduck.entities.Entity;
import pyroduck.graphics.Sprite;

/**
 * Is the background tile on which each entity is placed.
 * @author Corbisiero, Ferrara, La Femina
 * @version 1.0
 */
public class GrassTile extends Tile {

    /**
     * Constructor that create an object of this class.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param sprite related to the tile.
     */
    public GrassTile(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    /**
     * Check if two entities can collide with each other.
     * Obviously for these entities the possibility of colliding is set false because each other entity must be able to move on it.
     * @param e is the entity with which is checked the collision.
     * @return true if the entities can collide with each other, false otherwise.
     */
    @Override
    public boolean collide(Entity e) {
        return false;
    }
}