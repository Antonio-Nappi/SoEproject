/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.mob;

import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Game;
import pyroduck.bomb.Bomb;
import pyroduck.entities.tile.powerup.Powerup;

import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.Sprite;
import pyroduck.input.GrassKeyboard;
import pyroduck.level.Coordinates;


/**
 *
 * @author Gerry
 */
public class SuperPlayer extends Player{
    
    public SuperPlayer(Player player) {
        super((int)player.getX(), (int)player.getY(), player.board);
        this.input = player.input;
        this.lives = player.lives;
        this.done = false;   //It has just correct keyboard
        
    }
    
    @Override
    protected void chooseSprite() {
        
        try {
            if( Game.getInstance().getSelected() == 0){
                    switch(direction) {
                        case 0:
                            sprite = Sprite.articuno_up;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.articuno_up, Sprite.articuno_up, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = Sprite.articuno_up;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.articuno_up, Sprite.articuno_up, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = Sprite.articuno_up;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.articuno_up, Sprite.articuno_up, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = Sprite.articuno_up;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.articuno_up, Sprite.articuno_up, animate, 30);
                            }
                            break;
                        default:
                            sprite = Sprite.articuno_up;
                            if(moving) {
                                sprite = Sprite.movingSprite(Sprite.articuno_up, Sprite.articuno_up, animate, 30);
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
        System.out.println("Missile Sparato!");
        Game.addBombRate(1);
    }
    
    @Override
    protected void detectPlaceBomb() {
        if(input.space && timeBetweenPutBombs < 0) {
            int xt = Coordinates.pixelToTile(x + sprite.getSize() / 2);
            int yt = Coordinates.pixelToTile( (y + sprite.getSize() / 2) - sprite.getSize() ); //subtract half player height and minus 1 y position
            placeBomb(xt,yt);
            Game.addBombRate(-1);
            timeBetweenPutBombs = 30;
        }
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
    @Override
        public void correctKeyboard(){
        
           board.setInput();
           input = board.getInput();
        
    }
}
    

