package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.Entity;
import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.Player;
import pyroduck.entities.mob.enemy.EnemyPower;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.level.Coordinates;

public abstract class Enemy extends Mob {

    protected int points;
    protected double speed;
    protected EnemyPower ep;
    protected final double MAX_STEPS;
    protected final double rest;
    protected double steps;
    protected int finalAnimation = 30;
    protected Sprite deadSprite;

    public Enemy(int x, int y, Board board, Sprite dead, double speed, int points) {
        super(x, y, board);
        this.points = points;
        this.speed = speed;
        MAX_STEPS = Game.TILES_SIZE / speed;
        rest = (MAX_STEPS - (int) MAX_STEPS) / MAX_STEPS;
        this.steps = MAX_STEPS;
        timeAfter = 20;
        deadSprite = dead;
    }

    /*
    |--------------------------------------------------------------------------
    | Mob Render & Update
    |--------------------------------------------------------------------------
     */
    @Override
    public void update() {
        animate();
        if(alive == false) {
            afterKill();
            return;
        }
        if(alive)
            calculateMove();
    }

    @Override
    public void render(Screen screen) {
        if(alive)
            chooseSprite();
        else {
            if(timeAfter > 0) {
                sprite = deadSprite;
                animate = 0;
            } else {
                sprite = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, animate, 60);
            }
        }
        screen.renderEntity((int)x, (int)y - sprite.SIZE, this);
    }

    /*
    |--------------------------------------------------------------------------
    | Mob Move
    |--------------------------------------------------------------------------
     */
    @Override
    public void calculateMove() {
        int xa = 0, ya = 0;
        if(steps <= 0){
            direction = ep.calculateDirection();
            steps = MAX_STEPS;
        }
        if(direction == 0) ya--; 
        if(direction == 2) ya++;
        if(direction == 3) xa--;
        if(direction == 1) xa++;
        if(canMove(xa, ya)) {
            steps -= 1 + rest;
            move(xa * speed, ya * speed);
            moving = true;
        } else {
            steps = 0;
            moving = false;
        }
    }

    @Override
    public void move(double xa, double ya) {
        if(!alive) return;
            y += ya;
            x += xa;
    }

    @Override
    public boolean canMove(double x, double y) {
        double xr = this.x, yr = this.y - 32; //subtract y to get more accurate results
        //the thing is, subract to 32 (sprite size), so if we add 1 tile we get the next pixel tile with this
        //we avoid the shaking inside tiles with the help of steps
        if(direction == 0) { 
            yr += sprite.getSize() -1 ; 
            xr += sprite.getSize()/2; 
        } 
        if(direction == 1) {
            yr += sprite.getSize()/2; 
            xr += 1;
        }
        if(direction == 2) {
            xr += sprite.getSize()/2; 
            yr += 1;
        }
        if(direction == 3) {
            xr += sprite.getSize() -1; 
            yr += sprite.getSize()/2;
        }
        int xx = Coordinates.pixelToTile(xr) +(int)x;
        int yy = Coordinates.pixelToTile(yr) +(int)y;
        Entity a = board.getEntity(xx, yy, this); //entity of the position we want to go
        return !a.collide(this);
    }

    /*
    |--------------------------------------------------------------------------
    | Mob Colide & Kill
    |--------------------------------------------------------------------------
     */
    @Override
    public boolean collide(Entity e) {
        if(e instanceof DirectionalExplosion) {
            kill();
            return true;
        }
        if(e instanceof Player) {
            ((Player) e).kill();
            return true;
        }
        return false;
    }

    @Override
    public void kill() {
        if(alive == false) 
            return;
        alive = false;
    }

    @Override
    protected void afterKill() {
        if(timeAfter > 0) --timeAfter;
        else {
            if(finalAnimation > 0) 
                --finalAnimation;
            else
                remove();
        }
    }
	
    protected abstract void chooseSprite();
}