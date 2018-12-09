package pyroduck.entities.tile;

import pyroduck.entities.Entity;
import pyroduck.graphics.Sprite;

/**
 * Is the background of the tile where each entity is placed.
 * @author Corbisiero, Ferrara, La Femina
 * @version 1.0
 */
public class GrassTile extends Tile {
    public static Sprite grass = new Sprite(1, 0);

    /**
     * Constructor that create an object of this class.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param sprite related to the tile.
     */
    public GrassTile(int x, int y) {
        super(x, y, grass);
    }

    /**
     * Return false 
     * Obviously for these entities the possibility of colliding is setted false because other entities can move on it.
     * @param e is the entity with which is checked the collision.
     * @return false.
     */
    @Override
    public boolean collide(Entity e) {
        return false;
    }
}