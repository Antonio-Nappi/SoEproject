package pyroduck.entities.tile.destroyable;

import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.level.Coordinates;

/**
 * Represents the blocked tile which can be destroyed by the bomb.
 * @author Bini, Petruzzello
 * @version 1.0
 */
public class BrickTile extends DestroyableTile {
    public static Sprite brick = new Sprite(3, 0);

    /**
     * Creates an object of BrickTile.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param sprite related to the tile.
     */
    public BrickTile(int x, int y) {
        super(x, y, brick);
    }

    /**
     * Checks what should be shown on the screen and it invokes the screen's method to print the entity.
     * During the animation must be shown both top and bottom sprite.
     * @param screen screen on which the print is called.
     */
    @Override
    public void render(Screen screen) {
        int x = Coordinates.tileToPixel(this.x);
        int y = Coordinates.tileToPixel(this.y);
        if(!destroyed)
            screen.renderEntity( x, y, this);
        else{
            sprite = movingSprite(brick_exploded, brick_exploded1, brick_exploded2);
            screen.renderEntityWithBelowSprite(x, y, this, belowSprite);
        }       
    }  
}