package pyroduck.entities.tile.destroyable;

import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.Entity;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.level.Coordinates;

/**
 * Represent the tile that block the passage of the mobs, but can be destroyed with the bombs.
 * @author 
 * @version 1.0
 */
public class BrickTile extends DestroyableTile {

    /**
     * Constructor that create an object of this class.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param sprite related to the tile.
     */
    public BrickTile(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    /**
     * Check if the tile has been destroyed and if so, menage the animation related.
     */
    @Override
    public void update() {
        super.update();
    }

    /**
     * Check what must be shown on the screen and invoke the screen's method to print the entity.
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
            sprite = movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2);
            screen.renderEntityWithBelowSprite(x, y, this, belowSprite);
        }       
    }
    
    @Override
    public boolean collide(Entity e){
        if (e instanceof DirectionalExplosion)
            destroyed = true;
        return true;
    }
}