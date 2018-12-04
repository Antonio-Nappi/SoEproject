/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.tile.powerup;

import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Game;
import pyroduck.entities.mob.IPlayer;
import pyroduck.entities.mob.Player;
import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.input.GrassKeyboard;

/**
 *
 * @author Gerry
 */
public class PowerupKingIce extends Powerup implements IPlayer{

    Player playerComponent;
    
    public PowerupKingIce(int x, int y, Sprite sprite, Player playerComponent) {
        super(x, y, sprite);
        this.playerComponent = playerComponent;
    }

    @Override
    public void setValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void render(Screen screen){
        playerComponent.calculateXOffset();
        if(playerComponent.isAlive())
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
        screen.renderEntity((int)x, (int)y - sprite.SIZE, this);
    }
    
    
    @Override
    public void update(){
       playerComponent.update();
    }
    
    
    private void chooseSprite() {
        try {
            if( Game.getInstance().getSelected() == 0){
              
                    
                
                    switch(playerComponent.getDirection()) {
                        case 0:
                            sprite = Sprite.player_upi;
                            if(playerComponent.isMoving()) {
                                sprite = Sprite.movingSprite(Sprite.player_up_1i, Sprite.player_up_2i, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = Sprite.player_righti;
                            if(playerComponent.isMoving()) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1i, Sprite.player_right_2i, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = Sprite.player_downi;
                            if(playerComponent.isMoving()) {
                                sprite = Sprite.movingSprite(Sprite.player_down_1i, Sprite.player_down_2i, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = Sprite.player_lefti;
                            if(playerComponent.isMoving()) {
                                sprite = Sprite.movingSprite(Sprite.player_left_1i, Sprite.player_left_2i, animate, 30);
                            }
                            break;
                        default:
                            sprite = Sprite.player_righti;
                            if(playerComponent.isMoving()) {
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
    
    


    
