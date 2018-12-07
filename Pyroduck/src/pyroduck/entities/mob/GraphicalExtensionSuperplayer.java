/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.mob;

import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Game;
import pyroduck.entities.AnimatedEntity;
import pyroduck.entities.Entity;
import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Gerry
 */
public class GraphicalExtensionSuperplayer extends AnimatedEntity{
    
    private SuperPlayer superPlayer;
    private ExtensionSP leftExtension, rightExtension, up1Extension, up2Extension, up3Extension;
    
    public GraphicalExtensionSuperplayer(SuperPlayer superPlayer){
        this.superPlayer = superPlayer;
        this.leftExtension = new ExtensionSP(superPlayer.getX()-Game.TILES_SIZE, superPlayer.getY(), Sprite.articuno_up);
        this.rightExtension = new ExtensionSP(superPlayer.getX()+Game.TILES_SIZE, superPlayer.getY(), Sprite.articuno_up);
        this.up1Extension = new ExtensionSP(superPlayer.getX()-Game.TILES_SIZE, superPlayer.getY()-Game.TILES_SIZE, Sprite.articuno_up);
        this.up2Extension = new ExtensionSP(superPlayer.getX(), superPlayer.getY()-Game.TILES_SIZE, Sprite.articuno_up);
        this.up3Extension = new ExtensionSP(superPlayer.getX()+Game.TILES_SIZE, superPlayer.getY()-Game.TILES_SIZE, Sprite.articuno_up);
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
                    sprite = Sprite.player_dead1;
                }
                else{
                    sprite = Sprite.player_dead1i;
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
        System.out.println("leftMove: " + x_toMove + y_toMove);
        
        //calculate move right extension
        x_toMove = (x_sp + Game.TILES_SIZE) - rightExtension.getX();
        y_toMove = (y_sp) - rightExtension.getY();
        rightExtension.move(x_toMove, y_toMove);
        System.out.println("rightMove: " + x_toMove + y_toMove);
        
        //calculate move up1 extension
        x_toMove = (x_sp - Game.TILES_SIZE) - up1Extension.getX();
        y_toMove = (y_sp - Game.TILES_SIZE) - up1Extension.getY();
        up1Extension.move(x_toMove, y_toMove);
        System.out.println("up1Move: " + x_toMove + y_toMove);
        
        //calculate move up2 extension
        x_toMove = (x_sp) - up2Extension.getX();
        y_toMove = (y_sp - Game.TILES_SIZE) - up2Extension.getY();
        up2Extension.move(x_toMove, y_toMove);
        System.out.println("up2Move: " + x_toMove + y_toMove);
        
        //calculate move up3 extension
        x_toMove = (x_sp + Game.TILES_SIZE) - up3Extension.getX();
        y_toMove = (y_sp - Game.TILES_SIZE) - up3Extension.getY();
        up3Extension.move(x_toMove, y_toMove);
        System.out.println("up3Move: " + x_toMove + y_toMove);
        
    }

    private void chooseSprite() {
        try {
            if( Game.getInstance().getSelected() == 0){
                    switch(superPlayer.direction) {
                        case 0:
                            sprite = Sprite.articuno_up;
                            if(superPlayer.moving) {
                                sprite = Sprite.movingSprite(Sprite.articuno_up, Sprite.articuno_up, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = Sprite.articuno_up;
                            if(superPlayer.moving) {
                                sprite = Sprite.movingSprite(Sprite.articuno_up, Sprite.articuno_up, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = Sprite.articuno_up;
                            if(superPlayer.moving) {
                                sprite = Sprite.movingSprite(Sprite.articuno_up, Sprite.articuno_up, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = Sprite.articuno_up;
                            if(superPlayer.moving) {
                                sprite = Sprite.movingSprite(Sprite.articuno_up, Sprite.articuno_up, animate, 30);
                            }
                            break;
                        default:
                            sprite = Sprite.articuno_up;
                            if(superPlayer.moving) {
                                sprite = Sprite.movingSprite(Sprite.articuno_up, Sprite.articuno_up, animate, 30);
                            }
                            break;
                    }
                
                
            }else{
                    switch(superPlayer.direction) {
                        case 0:
                            sprite = Sprite.player_upi;
                            if(superPlayer.moving) {
                                sprite = Sprite.movingSprite(Sprite.player_up_1i, Sprite.player_up_2i, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = Sprite.player_righti;
                            if(superPlayer.moving) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1i, Sprite.player_right_2i, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = Sprite.player_downi;
                            if(superPlayer.moving) {
                                sprite = Sprite.movingSprite(Sprite.player_down_1i, Sprite.player_down_2i, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = Sprite.player_lefti;
                            if(superPlayer.moving) {
                                sprite = Sprite.movingSprite(Sprite.player_left_1i, Sprite.player_left_2i, animate, 30);
                            }
                            break;
                        default:
                            sprite = Sprite.player_righti;
                            if(superPlayer.moving) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1i, Sprite.player_right_2i, animate, 30);
                            }
                            break;
                    }
                }
                
        } catch (PyroduckException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
    
}
