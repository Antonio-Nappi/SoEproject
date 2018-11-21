package pyroduck.bomb;

import pyroduck.Board;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.graphics.Screen;

/**
 * Represent the related entity at the explosion range. 
 * It is used to manage the range of explosion.
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
     * Generates an horizontal and vertical explosion.
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
     * Return the range of the explosion in a certain position.
     * @return the range of the explosion in a certain position.
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
     * Return an Explosion if it's happened an explosion in a certain point 
     * Resctituisce un Explosion se è avvenuta un esplosione in quello specifico punto.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @return un Explosion se è avvenuta un esplosione in quello specifico punto.
     */
    public Explosion explosionAt(int x, int y) {
        for (int i = 0; i < explosions.length; i++) {
            if(explosions[i].getX() == x && explosions[i].getY() == y) 
                return explosions[i];
        }
        return null;
    }

    /**
     * Method not implemented.
     */
    @Override
    public void update() {}

    /**
     * Invokes the screen method that provide to show several explosion
     * @param screen on which the print is called.
     */
    @Override
    public void render(Screen screen) {
        for (int i = 0; i < explosions.length; i++) {
            explosions[i].render(screen);
        }
    }

    /**
     * Checks if two entities can collide with each other.
     * returns always false because the collision of mob with this object that provides the ...
     * Restituisce sempre false poichè la collisione di un mob con tale oggetto deve provocare il suo immobilizzamento.
     * @param e is the entity with which is checked the collision.
     * @return always false
     */
    @Override
    public boolean collide(Entity e) {
        return false;
    }
}