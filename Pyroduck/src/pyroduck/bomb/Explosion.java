package pyroduck.bomb;

import pyroduck.Board;
import pyroduck.entities.Entity;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;

/**
 * Rappresenta la classe che gestisce la visualizzazione grafica delle esplosioni.
 * è utilizzata per settare le immagini di ogni casella coinvolta nell'esplosione.
 * @author Corbisiero, Ferrara, La Femina
 */
public class Explosion extends Entity {

    protected boolean last = false;
    protected Board board;
    protected Sprite sprite1, sprite2;

    public Explosion(int x, int y, int direction, boolean last, Board board) {
        this.x = x;
        this.y = y;
        this.last = last;
        this.board = board;
        switch (direction) {
            case 0:
                if(last == false) {
                    sprite = Sprite.explosion_vertical2;
                } else {
                    sprite = Sprite.explosion_vertical_top_last2;
                }
            break;
            case 1:
                if(last == false) {
                    sprite = Sprite.explosion_horizontal2;
                } else {
                    sprite = Sprite.explosion_horizontal_right_last2;
                }
                break;
            case 2:
                if(last == false) {
                    sprite = Sprite.explosion_vertical2;
                } else {
                    sprite = Sprite.explosion_vertical_down_last2;
                }
                break;
            case 3: 
                if(last == false) {
                    sprite = Sprite.explosion_horizontal2;
                } else {
                    sprite = Sprite.explosion_horizontal_left_last2;
                }
                break;
        }
    }

    /**
     * Invoca il metodo di screen che provvede a stampare a video ciascuna delle celle coinvolte nell'esplosione.
     * @param screen on which the print is called.
     */
    @Override
    public void render(Screen screen) {
        int xt = (int)x << 5;
        int yt = (int)y << 5;
        screen.renderEntity(xt, yt , this);
    }

    /**
     * Metodo non implementato.
     */
    @Override
    public void update() {}

    /**
     * Say if the explosion entity can collide with other entity.
     * @param e is the entity with which is checked the collision.
     * @return true sempre.
     */
    @Override
    public boolean collide(Entity e) {
        return true;
    }
}