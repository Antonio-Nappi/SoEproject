/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.tile.destroyable;

import static pyroduck.entities.tile.destroyable.BrickTile.brick;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.graphics.SpriteSheet;
import pyroduck.level.Coordinates;

/**
 *
 * @author Antonio
 */
public class BrickIceTile extends DestroyableTile{
    public static Sprite brickice = new Sprite(11, 0);
        public static Sprite brick_exploded = new Sprite(4, 0);
    public static Sprite brick_exploded1 = new Sprite(5, 0);
    public static Sprite brick_exploded2 = new Sprite(6, 0);
     /**
     * Creates an object of BrickTile.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param sprite related to the tile.
     */
    public BrickIceTile(int x, int y) {
        super(x, y, brickice);
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
