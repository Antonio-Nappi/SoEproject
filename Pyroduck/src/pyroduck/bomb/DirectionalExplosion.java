package pyroduck.bomb;

import pyroduck.Board;
import pyroduck.entities.Entity;
import pyroduck.graphics.Screen;

/**
 * Represent the related entity in the range of the explosion. It is used to
 * manage the range of explosion and related entities involved in it.
 *
 * @author Bini, Petruzzello
 */
public class DirectionalExplosion extends Entity {

    protected int direction;
    private final int radius;
    protected Explosion[] explosions;

    /**
     * Creates an explosion object setting each properties of the range.
     *
     * @param x horizontal coordinate in tiles
     * @param y vertical coordinate in tiles
     * @param direction propagation direction
     * @param radius explosion radius
     */
    public DirectionalExplosion(int x, int y, int direction, int radius) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.radius = radius;
        this.explosions = new Explosion[calculatePermitedDistance()];
        createExplosions();
    }

    /**
     * Generates the horizontally and vertically propagative explosion from the
     * point where it borns
     */
    private void createExplosions() {
        boolean last;
        int xt = (int) this.x;
        int yt = (int) this.y;
        for (int i = 0; i < explosions.length; i++) {
            last = (i == explosions.length - 1);
            switch (direction) {
                case 0:
                    yt--;
                    break;
                case 1:
                    xt++;
                    break;
                case 2:
                    yt++;
                    break;
                case 3:
                    xt--;
                    break;
            }
            explosions[i] = new Explosion(xt, yt, direction, last);
        }
    }

    /**
     * Returns an int meaning the range of the explosion in a certain position
     *
     * @return Return an int meaning the range of the explosion in a certain
     * position
     */
    private int calculatePermitedDistance() {
        int rad = 0;
        int xt = (int) this.x;
        int yt = (int) this.y;
        while (rad < radius) {
            if (direction == 0) {
                yt--;
            }
            if (direction == 1) {
                xt++;
            }
            if (direction == 2) {
                yt++;
            }
            if (direction == 3) {
                xt--;
            }
            Entity a = Board.getInstance().getEntity(xt, yt, null);
            if (a.collide(this) && !a.isMob()){
                break;
            }
            ++rad;
        }
        return rad;
    }

    /**
     * Return an Explosion if an explosion is appened in a certain position.
     *
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
     * Invokes the screen's method that provides to print on the screen the
     * different explosions
     *
     * @param screen on which the print is called.
     */
    @Override
    public void render(Screen screen) {
        for (Explosion explosion : explosions) {
            explosion.render(screen);
        }
    }

    /**
     * Checks if two entities collide with each other. returns false because the
     * collision between Mob and bomb must freeze the mob
     *
     * @param e is the entity with which is checked the collision.
     * @return always false
     */
    @Override
    public boolean collide(Entity e) {
        return false;
    }

    @Override
    public boolean isExplosion() {
        return true;
    }
}