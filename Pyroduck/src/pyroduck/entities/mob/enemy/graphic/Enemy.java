package pyroduck.entities.mob.enemy.graphic;

import java.util.ArrayList;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.bomb.Bomb;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.enemy.EnemyPower;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.level.Coordinates;

/**
 * The abstract class describes the behavior of each type of enemies.
 *
 * @author Bini, Petruzzello
 */
public abstract class Enemy extends Mob {

    protected int points;
    protected double speed;
    protected EnemyPower ep;
    protected final double MAX_STEPS;
    protected final double rest;
    protected double steps;
    protected int finalAnimation = 30;
    protected Sprite deadSprite;

    /**
     * Creates an instance of Enemy
     *
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordiante in pixels.
     * @param dead sprite to show when the enemy will die.
     * @param speed speed of the enemy.
     * @param points point to receve when the enemy will die.
     */
    public Enemy(int x, int y, Sprite dead, double speed, int points) {
        super(x, y);
        this.points = points;
        this.speed = speed;
        MAX_STEPS = Game.TILES_SIZE / speed;
        rest = (MAX_STEPS - (int) MAX_STEPS) / MAX_STEPS;
        this.steps = MAX_STEPS;
        timeAfterDeath = 20;
        deadSprite = dead;
    }

    /*
    |--------------------------------------------------------------------------
    | Mob Render & Update
    |--------------------------------------------------------------------------
     */
    /**
     * Allows to update the state of the enemy checking if something is changed.
     * Checks if the enemy is dead and if it is not calls the function that
     * calcolates the movement.
     */
    @Override
    public void update() {
        animate();
        if (alive == false) {
            afterKill();
            return;
        }
        if (alive) {
            calculateMove();
        }
    }

    /**
     * Manage the print on screen of the right enemy sprite. Invoke the screen
     * method.
     *
     * @param screen screen on which the print is called.
     */
    @Override
    public void render(Screen screen) {
        if (alive) {
            chooseSprite();
        } else {
            if (timeAfterDeath > 0) {
                sprite = deadSprite;
                animate = 0;
            } else {
                sprite = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, animate, 30);
            }
        }
        screen.renderEntity((int) x, (int) y - sprite.SIZE, this);
    }

    /*
    |--------------------------------------------------------------------------
    | Mob Move
    |--------------------------------------------------------------------------
     */
    /**
     * Calculates of each pixels the enemy have to move.
     */
    @Override
    public void calculateMove() {
        int xa = 0, ya = 0;
        if (steps <= 0) {
            direction = ep.calculateDirection();
            steps = MAX_STEPS;
        }
        if (direction == 0) {
            ya--;
        }
        if (direction == 2) {
            ya++;
        }
        if (direction == 3) {
            xa--;
        }
        if (direction == 1) {
            xa++;
        }
        if (canMove(xa, ya)) {
            steps -= 1 + rest;
            move(xa * speed, ya * speed);
            moving = true;
        } else {
            steps = 0;
            moving = false;
        }
    }

    /**
     * Changes the enemy position if it is alive.
     *
     * @param xa horizontal coordinate in pixels.
     * @param ya vertical coordinate in pixels.
     */
    @Override
    public void move(double xa, double ya) {
        if (alive) {
            y += ya;
            x += xa;
        }
    }

    /**
     * Return a boolean that say whether the enemy can move in a specific
     * coordinate or not.
     *
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordinate in pixels.
     * @return true if the enemy can move in <b>(x, y)</b> coordinate, false
     * otherwise.
     */
    @Override
    public boolean canMove(double x, double y) {
        double xr = this.x, yr = this.y - 32; //subtract y to get more accurate results
        //the thing is, subract to 32 (sprite size), so if we add 1 tile we get the next pixel tile with this
        //we avoid the shaking inside tiles with the help of steps
        if (direction == 0) {
            yr += sprite.getSize() - 1;
            xr += sprite.getSize() / 2;
        }
        if (direction == 1) {
            yr += sprite.getSize() / 2;
            xr += 1;
        }
        if (direction == 2) {
            xr += sprite.getSize() / 2;
            yr += 1;
        }
        if (direction == 3) {
            xr += sprite.getSize() - 1;
            yr += sprite.getSize() / 2;
        }
        int xx = Coordinates.pixelToTile(xr) + (int) x;
        int yy = Coordinates.pixelToTile(yr) + (int) y;
        Entity a = Board.getInstance().getEntity(xx, yy, this); //entity of the position we want to go
        return !a.collide(this);
    }

    /*
    |--------------------------------------------------------------------------
    | Mob Colide & Kill
    |--------------------------------------------------------------------------
     */
    /**
     * Manage the collision between two entities.
     *
     * @param e instance of the entity which the enemy collide.
     * @return true if the entities cannot overlap between them, false
     * otherwise.
     */
    @Override
    public boolean collide(Entity e) {
        if (e.isExplosion() || (e.isBomb() && (((Bomb) e).isMissile()))) {
            kill();
            ArrayList<Mob> m = Board.getInstance().getMobsAtExcluding(this.getXTile(), this.getYTile(), this);
            for (Mob mob1 : m) {
                if (mob1.isAlive()) {
                    mob1.kill();
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Set the state of the enemy to dead.
     */
    @Override
    public void kill() {
        alive = false;
        Board.getInstance().setPoints(points);
    }

    /**
     * Manage the deth of the enemy.
     */
    @Override
    protected void afterKill() {
        if (timeAfterDeath > 0) {
            --timeAfterDeath;
        } else {
            if (finalAnimation > 0) {
                --finalAnimation;
            } else {
                remove();
            }
        }
    }

    /**
     * Chooses the sprite to show on the screen.
     */
    protected abstract void chooseSprite();

    public EnemyPower getEp() {
        return ep;
    }
}
