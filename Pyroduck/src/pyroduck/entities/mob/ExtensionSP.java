package pyroduck.entities.mob;

import pyroduck.entities.Entity;
import pyroduck.graphics.*;

/**
 *
 * @author 
 */
public class ExtensionSP extends Entity{

    public ExtensionSP(double x, double y, Sprite sprite){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }
    
    @Override
    public void update() {}

    @Override
    public void render(Screen screen) {}

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