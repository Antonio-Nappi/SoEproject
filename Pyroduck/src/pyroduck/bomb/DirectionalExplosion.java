package pyroduck.bomb;

import pyroduck.Board;
import pyroduck.entities.Entity;
import pyroduck.entities.LayeredEntity;
import pyroduck.entities.mob.Mob;
import pyroduck.graphics.Screen;

/**
 * Represent the related entity in the range of the explosion. 
 * It is used to manage the range of explosion and related entities involved in it.
 * @author Bini, Petruzzello
 */
public class DirectionalExplosion extends Entity {

    protected int direction;
    private final int radius;
    protected int xOrigin, yOrigin;
    protected Explosion[] explosions;

    /**
     * Creates an explosion object setting each properties of the range.
     * @param x
     * @param y
     * @param direction
     * @param radius
     */
    public DirectionalExplosion(int x, int y, int direction, int radius ) {
        xOrigin = x;
        yOrigin = y;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.radius = radius;
        this.explosions = new Explosion[calculatePermitedDistance()];
        createExplosions();
    }

    /**
     *Generates the horizontally and vertically propagative explosion from the point where it borns
     */
    private void createExplosions() {
        boolean last;
        int x = (int)this.x; // qui c'e il problema
        int y = (int)this.y;
        for (int i = 0; i < explosions.length; i++) {
            last = (i == explosions.length -1);
            switch (direction) {
                case 0: y--; break;
                case 1: x++; break;
                case 2: y++; break;
                case 3: x--; break;
            }
            explosions[i] = new Explosion(x, y, direction, last);
        }
    }

    /**
    * Returns an int meaning the range of the explosion in a certain position
     * @return Return an int meaning the range of the explosion in a certain position
     */
    private int calculatePermitedDistance() {
        int rad = 0;
        int x = (int)this.x;
        int y = (int)this.y;
        while(rad < radius) {
            if(direction == 0) y--;
            if(direction == 1) x++;
            if(direction == 2) y++;
            if(direction == 3) x--;
            Entity a = Board.getInstance().getEntity(x, y, null);
            if(a instanceof Mob)
                ++rad; //explosion has to be below the mob
            if(a.collide(this))//cannot pass thru
                break;
            ++rad;
        }
        return rad;
    }

    /**
     * Return an Explosion if an explosion is appened in a certain position.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @return an Explosion if an explosion is appened in a certain position.
 */
    public Explosion explosionAt(int x, int y) {
        for (Explosion explosion : explosions) {
            if (explosion.getX() == x && explosion.getY() == y) {
                return explosion;
            }
        }
        return null;
    }

    /**
     * Not implemented method.
     */
    @Override
    public void update() {}

    /**
     * Invokes the screen's method that provides to print on the screen the different explosions    
     * @param screen on which the print is called.
     */
    @Override
    public void render(Screen screen) {
        for (Explosion explosion : explosions) {
            explosion.render(screen);
        }
    }

    /**
     * Checks if two entities collide with each other.
     * returns false because the collision between Mob and bomb must freeze the mob
     * @param e is the entity with which is checked the collision.
     * @return always false
     */
    @Override
    public boolean collide(Entity e) {
        return false;
    }
}