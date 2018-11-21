package pyroduck.entities;

import java.util.LinkedList;

import pyroduck.entities.tile.destroyable.DestroyableTile;
import pyroduck.graphics.Screen;

/**
 * It is an array that can be overlapped on a single cell of the map.
 * It is used to overlap the entities between them.
 * @author 
 * @version 1.0
 */
public class LayeredEntity extends Entity {
	
    protected LinkedList<Entity> entities = new LinkedList<Entity>();

    /**
     * Initialize the object making a layered entity that contain all the entities localized in a specific coordinates.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param entities array of variable lenght that contain the entities to overlap, the entities must be passed from the bottom to the top.
     */
    public LayeredEntity(int x, int y, Entity ... entities) {      //... = significa che il metodo accetta una matrice di quel tipo di oggetti, ma quella matrice
                                                                // viene creata automaticamente quando si passano diversi oggetti di quel tipo separati da virgole
        this.x = x;
        this.y = y;
        for (int i = 0; i < entities.length; i++) {
            this.entities.add(entities[i]); 
            if(i > 1) { //Add to destroyable tiles the bellow sprite for rendering in explosion
                if(entities[i] instanceof DestroyableTile)
                   ((DestroyableTile)entities[i]).addBelowSprite(entities[i-1].getSprite());
            }
        }
    }

    /**
     * It allow to update the state of layered entity checking if the top entity must be replaced by the bottom one.
     */
    @Override
    public void update() {
        clearRemoved();
        getTopEntity().update();    //Because each type of entity has its update method
    }

    /**
     * Invoke the screen's method to print the top entity on screen.
     * @param screen screen on which the print is called.
     */
    @Override
    public void render(Screen screen) {
        getTopEntity().render(screen);
    }

    /**
     * Getter that release the top entity.
     * @return the top entity.
     */
    public Entity getTopEntity() {      
        return entities.getLast();
    }

    /**
     * Check if the top entity must be removed and eventually remove it.
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
     * Check if the top entity can collide with the one passed as a parameter.
     * @param e is the entity with which is checked the collision.
     * @return true if the entities can collide with each other, false otherwise.
     */
    @Override
    public boolean collide(Entity e) {
        return getTopEntity().collide(e);
    }
}
