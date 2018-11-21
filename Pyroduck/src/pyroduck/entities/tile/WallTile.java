package pyroduck.entities.tile;

import pyroduck.graphics.Sprite;

/**
 * Is the tile that marks the end and the inaccessible areas of the map.
 * @author Corbisiero, Ferrara, La Femina
 * @version 1.0
 */
public class WallTile extends Tile {

    /**
     * Constructor that create an object of this class.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param sprite related to the tile.
     */
    public WallTile(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }
}