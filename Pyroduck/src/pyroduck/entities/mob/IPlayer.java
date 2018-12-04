/*
 * IT IS THE COMPONENT INTERFACE
 */
package pyroduck.entities.mob;

import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Game;
import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Gerry
 */
public interface IPlayer {
    
    public abstract void render(Screen screen);
    
    public abstract void update();
    
    
}
