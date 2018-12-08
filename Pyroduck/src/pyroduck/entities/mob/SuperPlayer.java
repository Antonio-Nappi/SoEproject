package pyroduck.entities.mob;

import java.util.logging.*;
import pyroduck.*;
import pyroduck.entities.tile.powerup.Powerup;

import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.*;
import pyroduck.level.Coordinates;

/**
 *
 * @author 
 */
public class SuperPlayer extends Player{
    
    private GraphicalExtensionSuperplayer graphicalExtensionSP = null;
    
    public SuperPlayer(Player player) {
        super((int)player.getX(), (int)player.getY());
        this.input = player.input;
        this.lives = player.lives;
        this.done = false;   //It has just correct keyboard   
    }
    
    @Override
    public void render(Screen screen) {
        super.render(screen);
        graphicalExtensionSP.render(screen);
    }
    
    @Override
    protected void calculateMove() {
        super.calculateMove();
        graphicalExtensionSP.calculateMove();
    }
    
    @Override
    protected void chooseSprite() {
        try {
            if(Game.getInstance().getSelected() == 0){
                switch(direction) {
                    case 0:
                        sprite = Sprite.articuno_up;
                        if(moving) {
                            sprite = Sprite.movingSprite(Sprite.articuno_up1, Sprite.articuno_up2, animate, 30);
                        }
                        break;
                    case 1:
                        sprite = Sprite.articuno_right;
                        if(moving) {
                            sprite = Sprite.movingSprite(Sprite.articuno_right1, Sprite.articuno_right2, animate, 30);
                        }
                        break;
                    case 2:
                        sprite = Sprite.articuno_down;
                        if(moving) {
                            sprite = Sprite.movingSprite(Sprite.articuno_down1, Sprite.articuno_down2, animate, 30);
                        }
                        break;
                    case 3:
                        sprite = Sprite.articuno_left;
                        if(moving) {
                            sprite = Sprite.movingSprite(Sprite.articuno_left1, Sprite.articuno_left2, animate, 30);
                        }
                        break;
                    default:
                        sprite = Sprite.articuno_down;
                        if(moving) {
                            sprite = Sprite.movingSprite(Sprite.articuno_down1, Sprite.articuno_down2, animate, 30);
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
        }catch (PyroduckException ex){
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    @Override
    protected void placeBomb(int x, int y) {    //NOW we can shoot missiles
        //Bomb b = new Bomb(x, y);
        //Board.getInstance().addBomb(b);
        //DEVE SPARARE MISSILI
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
    public void addPowerup(Powerup p) {    }
    
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
        
    public void setGraphicalExtension(SuperPlayer superPlayer){
        this.graphicalExtensionSP = new GraphicalExtensionSuperplayer(superPlayer);
    }
    
    public int getAnimate(){
        return this.animate;
    }
}