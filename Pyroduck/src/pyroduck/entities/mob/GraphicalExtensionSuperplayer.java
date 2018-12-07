/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.mob;

import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Game;
import pyroduck.entities.Entity;
import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Gerry
 */
public class GraphicalExtensionSuperplayer extends Entity{
    
    private SuperPlayer superPlayer;

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
        screen.renderEntity((int)x, (int)y - sprite.SIZE, this);
    }

    @Override
    public boolean collide(Entity e) {
        return false;
    }

    private void animate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void calculateMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void chooseSprite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
