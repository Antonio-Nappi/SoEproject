/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.mob;

import pyroduck.Board;
import pyroduck.entities.Entity;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;


/**
 *
 * @author Gerry
 */
public class ExtensionSP extends Entity{

    public ExtensionSP(double x, double y, Sprite sprite){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }
    
    
    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Screen screen) {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean collide(Entity e) {
        return false;     
    }
    
    public void move(double xa, double ya) {
            this.y += ya;
            this.x += xa;
    }
    
    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }
      
}
