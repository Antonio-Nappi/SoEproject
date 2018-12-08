package pyroduck.entities.mob;

import java.util.logging.*;
import pyroduck.Game;
import pyroduck.entities.*;
import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.*;

/**
 *
 * @author
 */
public class GraphicalExtensionSuperplayer extends AnimatedEntity{

    private SuperPlayer superPlayer;
    private ExtensionSP leftExtension, rightExtension, up1Extension, up2Extension, up3Extension;
    public static Sprite articuno_up = new Sprite(15, 2);
      protected Sprite player_dead1 = new Sprite(3, 2);
    protected Sprite player_dead2 = new Sprite(3, 3);
    protected Sprite player_dead3 = new Sprite(3, 4);


    protected Sprite player_upi = new Sprite(0, 6);
    protected Sprite player_downi = new Sprite(0, 5);
    protected Sprite player_lefti = new Sprite(0, 7);
    protected Sprite player_righti = new Sprite(0, 8);

    protected Sprite player_up_1i = new Sprite(1, 6);
    protected Sprite player_up_2i = new Sprite(2, 6);

    protected Sprite player_down_1i = new Sprite(1, 5);
    protected Sprite player_down_2i = new Sprite(2, 5);

    protected Sprite player_left_1i = new Sprite(1, 7);
    protected Sprite player_left_2i = new Sprite(2, 7);

    protected Sprite player_right_1i = new Sprite(1, 8);
    protected Sprite player_right_2i = new Sprite(2, 8);

    protected Sprite player_dead1i = new Sprite(3, 6);
    protected Sprite player_dead2i = new Sprite(3, 7);
    protected Sprite player_dead3i = new Sprite(3, 8);

    public GraphicalExtensionSuperplayer(SuperPlayer superPlayer){
        this.superPlayer = superPlayer;
        this.leftExtension = new ExtensionSP(superPlayer.getX()-Game.TILES_SIZE, superPlayer.getY(), Sprite.articuno_up_left);
        this.rightExtension = new ExtensionSP(superPlayer.getX()+Game.TILES_SIZE, superPlayer.getY(), Sprite.articuno_up_right);
        this.up1Extension = new ExtensionSP(superPlayer.getX()-Game.TILES_SIZE, superPlayer.getY()-Game.TILES_SIZE, Sprite.articuno_up_up1);
        this.up2Extension = new ExtensionSP(superPlayer.getX(), superPlayer.getY()-Game.TILES_SIZE, Sprite.articuno_up_up2);
        this.up3Extension = new ExtensionSP(superPlayer.getX()+Game.TILES_SIZE, superPlayer.getY()-Game.TILES_SIZE, Sprite.articuno_up_up3);
    }

    @Override
    public void update() {
        animate();
        calculateMove();
    }

    @Override
    public void render(Screen screen) {
        if(superPlayer.alive)
            chooseSprite();
        else
            try {
                if(Game.getInstance().getSelected() == 0){
                    sprite = player_dead1;
                }
                else{
                    sprite = player_dead1i;
                }
        } catch (PyroduckException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        screen.renderEntity((int)leftExtension.getX(), (int)leftExtension.getY() - sprite.SIZE, leftExtension);
        screen.renderEntity((int)rightExtension.getX(), (int)rightExtension.getY() - sprite.SIZE, rightExtension);
        screen.renderEntity((int)up1Extension.getX(), (int)up1Extension.getY() - sprite.SIZE, up1Extension);
        screen.renderEntity((int)up2Extension.getX(), (int)up2Extension.getY() - sprite.SIZE, up2Extension);
        screen.renderEntity((int)up3Extension.getX(), (int)up3Extension.getY() - sprite.SIZE, up3Extension);
    }

    @Override
    public boolean collide(Entity e) {
        return false;
    }

    public void calculateMove() {
        double x_sp = superPlayer.getX();
        double y_sp = superPlayer.getY();
        //calculate move left extension
        double x_toMove = (x_sp - Game.TILES_SIZE) - leftExtension.getX();
        double y_toMove = (y_sp) - leftExtension.getY();
        leftExtension.move(x_toMove, y_toMove);
        //calculate move right extension
        x_toMove = (x_sp + Game.TILES_SIZE) - rightExtension.getX();
        y_toMove = (y_sp) - rightExtension.getY();
        rightExtension.move(x_toMove, y_toMove);
        //calculate move up1 extension
        x_toMove = (x_sp - Game.TILES_SIZE) - up1Extension.getX();
        y_toMove = (y_sp - Game.TILES_SIZE) - up1Extension.getY();
        up1Extension.move(x_toMove, y_toMove);
        //calculate move up2 extension
        x_toMove = (x_sp) - up2Extension.getX();
        y_toMove = (y_sp - Game.TILES_SIZE) - up2Extension.getY();
        up2Extension.move(x_toMove, y_toMove);
        //calculate move up3 extension
        x_toMove = (x_sp + Game.TILES_SIZE) - up3Extension.getX();
        y_toMove = (y_sp - Game.TILES_SIZE) - up3Extension.getY();
        up3Extension.move(x_toMove, y_toMove);
    }

    private void chooseSprite() {
        try {
            if( Game.getInstance().getSelected() == 0){
                switch(superPlayer.direction) {
                    case 0:
                        sprite = articuno_up;
                        if(superPlayer.moving) {
                            sprite = Sprite.movingSprite(articuno_up, articuno_up, animate, 30);
                        }
                        break;
                    case 1:
                        sprite = articuno_up;
                        if(superPlayer.moving) {
                            sprite = Sprite.movingSprite(articuno_up, articuno_up, animate, 30);
                        }
                        break;
                    case 2:
                        sprite = articuno_up;
                        if(superPlayer.moving) {
                            sprite = Sprite.movingSprite(articuno_up, articuno_up, animate, 30);
                        }
                        break;
                    case 3:
                        sprite = articuno_up;
                        if(superPlayer.moving) {
                            sprite = Sprite.movingSprite(articuno_up, articuno_up, animate, 30);
                        }
                        break;
                    default:
                        sprite = articuno_up;
                        if(superPlayer.moving) {
                            sprite = Sprite.movingSprite(articuno_up, articuno_up, animate, 30);
                        }
                        break;
                }
            }else{
                switch(superPlayer.direction) {
                    case 0:
                        sprite = player_upi;
                        if(superPlayer.moving) {
                            sprite = Sprite.movingSprite(player_up_1i, player_up_2i, animate, 30);
                        }
                        break;
                    case 1:
                        sprite = player_righti;
                        if(superPlayer.moving) {
                            sprite = Sprite.movingSprite(player_right_1i, player_right_2i, animate, 30);
                        }
                        break;
                    case 2:
                        sprite = player_downi;
                        if(superPlayer.moving) {
                            sprite = Sprite.movingSprite(player_down_1i, player_down_2i, animate, 30);
                        }
                        break;
                    case 3:
                        sprite = player_lefti;
                        if(superPlayer.moving) {
                            sprite = Sprite.movingSprite(player_left_1i, player_left_2i, animate, 30);
                        }
                        break;
                    default:
                        sprite = player_righti;
                        if(superPlayer.moving) {
                            sprite = Sprite.movingSprite(player_right_1i, player_right_2i, animate, 30);
                        }
                        break;
                }
            }
        } catch (PyroduckException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
