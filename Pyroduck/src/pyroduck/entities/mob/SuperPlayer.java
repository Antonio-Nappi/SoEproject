/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.mob;

import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.bomb.Bomb;
import pyroduck.entities.tile.powerup.Powerup;

import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.Sprite;
import pyroduck.level.Coordinates;


/**
 *
 * @author Gerry
 */
public class SuperPlayer extends Player{
     public static Sprite articuno_up = new Sprite(15, 2);
        
    public SuperPlayer(Player player) {
        super((int)player.getX(), (int)player.getY());
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
                            sprite = articuno_up;
                            if(moving) {
                                sprite = Sprite.movingSprite(articuno_up, articuno_up, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = articuno_up;
                            if(moving) {
                                sprite = Sprite.movingSprite(articuno_up, articuno_up, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = articuno_up;
                            if(moving) {
                                sprite = Sprite.movingSprite(articuno_up, articuno_up, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = articuno_up;
                            if(moving) {
                                sprite = Sprite.movingSprite(articuno_up, articuno_up, animate, 30);
                            }
                            break;
                        default:
                            sprite = articuno_up;
                            if(moving) {
                                sprite = Sprite.movingSprite(articuno_up, articuno_up, animate, 30);
                            }
                            break;
                    }
                
            }else{
                    switch(direction) {
                        case 0:
                            sprite = player_upi;
                            if(moving) {
                                sprite = Sprite.movingSprite(player_up_1i, player_up_2i, animate, 30);
                            }
                            break;
                        case 1:
                            sprite = player_righti;
                            if(moving) {
                                sprite = Sprite.movingSprite(player_right_1i, player_right_2i, animate, 30);
                            }
                            break;
                        case 2:
                            sprite = player_downi;
                            if(moving) {
                                sprite = Sprite.movingSprite(player_down_1i, player_down_2i, animate, 30);
                            }
                            break;
                        case 3:
                            sprite = player_lefti;
                            if(moving) {
                                sprite = Sprite.movingSprite(player_left_1i, player_left_2i, animate, 30);
                            }
                            break;
                        default:
                            sprite = player_righti;
                            if(moving) {
                                sprite = Sprite.movingSprite(player_right_1i, player_right_2i, animate, 30);
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
        //Bomb b = new Bomb(x, y);
        //Board.getInstance().addBomb(b);
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
                if(Board.getInstance().getLives() == 0){
                    Board.getInstance().endGame();  
                }else
                    Board.getInstance().restartLevel();
            }
        }
    }
    @Override
        public void correctKeyboard(){
        
           Board.getInstance().setInput();
           input = Board.getInstance().getInput();
        
    }
}
    

