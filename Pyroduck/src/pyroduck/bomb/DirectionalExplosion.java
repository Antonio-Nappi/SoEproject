package pyroduck.bomb;

import pyroduck.Board;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.graphics.Screen;

/**
 * Represent the related entity in the range of the explosion. 
 * It is used to manage the range of explosion and related entities involved in it.
 * @author Bini, Petruzzello
 */
public class DirectionalExplosion extends Entity {

    protected Board board;
    protected int direction;
    private int radius;
    protected int xOrigin, yOrigin;
    protected Explosion[] explosions;

    /**
     * Creates an explosion object setting each properties of the range.
     * @param x
     * @param y
     * @param direction
     * @param radius
     * @param board 
     */
    public DirectionalExplosion(int x, int y, int direction, int radius, Board board) {
        xOrigin = x;
        yOrigin = y;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.radius = radius;
        this.board = board;
        this.explosions = new Explosion[calculatePermitedDistance()];
        createExplosions();
    }

    /**
     *Generates the horizontally and vertically propagative explosion from the point where it borns
     */
    private void createExplosions() {
        boolean last = false;
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
            explosions[i] = new Explosion(x, y, direction, last, board);
        }
    }

    /**
    * Returns an int meaning the range of the explosion in a certain position
     * @return Return an int meaning the range of the explosion in a certain position
     */
    private int calculatePermitedDistance() {
        int radius = 0;
        int x = (int)this.x;
        int y = (int)this.y;
        while(radius < this.radius) {
            if(direction == 0) y--;
            if(direction == 1) x++;
            if(direction == 2) y++;
            if(direction == 3) x--;
            Entity a = board.getEntity(x, y);
            if(a instanceof Mob) 
                ++radius; //explosion has to be below the mob
            if(a.collide(this) == true) //cannot pass thru
                break;
            ++radius;
        }
        return radius;
    }

    /**
     * Return an Explosion if an explosion is appened in a certain position.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @return an Explosion if an explosion is appened in a certain position.
 */
    public Explosion explosionAt(int x, int y) {
        for (int i = 0; i < explosions.length; i++) {
            if(explosions[i].getX() == x && explosions[i].getY() == y) 
                return explosions[i];
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
        for (int i = 0; i < explosions.length; i++) {
            explosions[i].render(screen);
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