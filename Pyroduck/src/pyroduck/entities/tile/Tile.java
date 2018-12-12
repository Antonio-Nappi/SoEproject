package pyroduck.entities.tile;

import pyroduck.entities.Entity;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.level.Coordinates;

/**
 * Represent the abstract class of each non-animated entity.
 * Is used to manage the interaction between these entities with the others.
 * @author Corbisiero, Ferrara, La Femina
 * @version 1.0
 */
public abstract class Tile extends Entity {

    /**
     * Creates an object of Tile.
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
     * The implementation of this method allows to update the state of the entity checking if something is changed.
     */
    @Override
    public void update() {}
    
    /**
     * Invokes the screen's method to print the entity on screen.
     * @param screen screen on which the print is called.
     */
    @Override
    public void render(Screen screen) {
        screen.renderEntity(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y), this);
    }
    
    /**
     * Checks if two entities collide with each other.
     * For these entities the possibility of colliding is set true by default, so these entities cannot overlap with the others.
     * @param e is the entity with which is checked the collision.
     * @return true if the entities can collide with each other, false otherwise.
     */
    @Override
    public boolean collide(Entity e) {
        return true;
    }
    
    public boolean isDestroyable() {
        return false;
    }
    
    @Override
    public boolean isTile(){
        return true;
    }
    
    public boolean isDestroyableIceTile(){
        return false;
    }
}