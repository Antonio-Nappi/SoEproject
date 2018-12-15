package pyroduck.entities;

import java.util.LinkedList;
import pyroduck.entities.tile.Tile;
import pyroduck.entities.tile.destroyable.DestroyableTile;
import pyroduck.graphics.Screen;

/**
 * Is an array which allows the overlapping of the single tile in the map.
 * It is used to overlap the entities between them on a single tile.
 * @author Montefusco, Nappi
 * @version 1.0
 */
public class LayeredEntity extends Entity {
	
    protected LinkedList<Entity> entities = new LinkedList<>();

    /**
     * Initializes the object making a layered entity that contain all the entities localized in a specific coordinates.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param entities array of variable lenght that contain the entities to overlap, the entities must be passed from the bottom to the top.
     */
    public LayeredEntity(int x, int y, Entity ... entities) {
        this.x = x;
        this.y = y;
        for (int i = 0; i < entities.length; i++) {
            this.entities.add(entities[i]); 
            if(i > 1) { //Add to destroyable tiles the bellow sprite for rendering in explosion
                if(entities[i].isTile() && ((Tile)entities[i]).isDestroyable())
                   ((DestroyableTile)entities[i]).addBelowSprite(entities[i-1].getSprite());
            }
        }
    }

    /**
     * Allows to update the state of layered entity checking if the top entity should be replaced by the bottom one.
     */
    @Override
    public void update() {
        clearRemoved();
        getTopEntity().update();    //Because each type of entity has its update method
    }

    /**
     * Invokes the screen's method to print the top entity on screen.
     * @param screen screen on which the print is called.
     */
    @Override
    public void render(Screen screen) {
        getTopEntity().render(screen);
    }

    /**
     * Return the top entity.
     * @return the top entity.
     */
    public Entity getTopEntity() {      
        return entities.getLast();
    }

    /**
     * Checks if the top entity must be removed and eventually it removes.
     */
    private void clearRemoved() {
        Entity top = getTopEntity();
        if(top.isRemoved())  {
            entities.removeLast();
        }
    }
    
    public void addBeforeTop(Entity e) {
	entities.add(entities.size() - 1, e);
    }
    
    /**
     * Checks if the top entity collides with the one passed as a parameter.
     * @param e is the entity with which is checked the collision.
     * @return true if the entities can collide with each other, false otherwise.
     */
    @Override
    public boolean collide(Entity e) {
        return getTopEntity().collide(e);
    }
}
