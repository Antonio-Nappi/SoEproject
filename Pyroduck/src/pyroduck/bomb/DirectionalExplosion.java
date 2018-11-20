package pyroduck.bomb;

import pyroduck.Board;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.graphics.Screen;

/**
 * Represent the entity related at the explosion range. 
 * It is used to manage each direction in which a bomb can be explode and the collisions related. 
 * @author Bini, Petruzzello
 */
public class DirectionalExplosion extends Entity {

    protected Board board;
    protected int direction;
    private int radius;
    protected int xOrigin, yOrigin;
    protected Explosion[] explosions;

    /**
     * Costruisce un esplosione.
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
     * Genera l'esplosione che si propaga verticalmente e orizzontalmente al punto di esplosione.
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
     * Restituisce il raggio di esposione in una determinata direzione.
     * @return un intero relativo al raggio di esplosione in una determinata direzione.
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
            Entity a = board.getEntity(x, y, null);
            if(a instanceof Mob) ++radius; //explosion has to be below the mob
            if(a.collide(this) == true) //cannot pass thru
                break;
            ++radius;
        }
        return radius;
    }

    /**
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
     * Metodo non implementato.
     */
    @Override
    public void update() {}

    /**
     * Invoca il metodo di screen che provede a stampare a video le varie esplosioni.
     * @param screen on which the print is called.
     */
    @Override
    public void render(Screen screen) {
        for (int i = 0; i < explosions.length; i++) {
            explosions[i].render(screen);
        }
    }

    /**
     * Check if two entities can collide with each other.
     * Restituisce sempre false poichè la collisione di un mob con tale oggetto deve provocare il suo immobilizzamento.
     * @param e is the entity with which is checked the collision.
     * @return false sempre
     */
    @Override
    public boolean collide(Entity e) {
        return false;
    }
}
