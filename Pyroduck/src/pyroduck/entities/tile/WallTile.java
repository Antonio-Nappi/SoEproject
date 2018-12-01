package pyroduck.entities.tile;

import pyroduck.graphics.Sprite;

/**
 * Is the inaccessible tile on the map where the Player can't pass through it.
 * @author Corbisiero, Ferrara, La Femina
 * @version 1.0
 */
public class WallTile extends Tile {

    /**
     * Creates an object of the WallTile.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param sprite related to the tile.
     */
    public WallTile(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }
}
