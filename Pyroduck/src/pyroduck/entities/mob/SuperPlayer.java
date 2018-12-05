/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.mob;

import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Game;
import pyroduck.entities.tile.powerup.Powerup;

import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.Sprite;
import pyroduck.input.GrassKeyboard;


/**
 *
 * @author Gerry
 */
public class SuperPlayer extends Player{
    
    public SuperPlayer(Player player) {
        super((int)player.getX(), (int)player.getY(), player.board);
        this.input = GrassKeyboard.getInstance();
        this.lives = lives;
        this.done = false;
        
    }
    
    private void chooseSprite() {
        System.out.println("STAMPA CORRETTA");
        
        try {
            if( Game.getInstance().getSelected() == 0){
                    switch(direction) {
                        case 0:
                            sprite = Sprite.player_up;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = Sprite.player_right;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = Sprite.player_down;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_down_1, Sprite.player_down_2, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = Sprite.player_left;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_left_1, Sprite.player_left_2, animate, 30);
                            }
                            break;
                        default:
                            sprite = Sprite.player_right;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, animate, 30);
                            }
                            break;
                    }
                
                
            }else{
                    switch(direction) {
                        case 0:
                            sprite = Sprite.player_upi;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_up_1i, Sprite.player_up_2i, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = Sprite.player_righti;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1i, Sprite.player_right_2i, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = Sprite.player_downi;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_down_1i, Sprite.player_down_2i, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = Sprite.player_lefti;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_left_1i, Sprite.player_left_2i, animate, 30);
                            }
                            break;
                        default:
                            sprite = Sprite.player_righti;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.player_right_1i, Sprite.player_right_2i, animate, 30);
                            }
                            break;
                    }
                }
                
        } catch (PyroduckException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    protected void placeBomb(int x, int y) {    //NOW we can shoot missiles
        //Bomb b = new Bomb(x, y, board);
        //board.addBomb(b);
        //DEVE SPARARE MISSILI 
    }
    
    @Override
    public void addPowerup(Powerup p) {
        //nothing...
    }
    
    @Override
    protected void afterKill() {          //AGGIUNGERE PERDITA VEICOLO, QUINDI RESTART LEVEL SENZA POWERUP
        if(timeAfter > 0)
            --timeAfter;
        else {
            if(bombs.isEmpty()) {
                if(board.getLives() == 0){
                    board.endGame();  
                }else
                    board.restartLevel();
            }
        }
    }
}
    

