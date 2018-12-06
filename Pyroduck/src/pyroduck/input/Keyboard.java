package pyroduck.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author 
 */
public abstract class Keyboard implements KeyListener{
    
    protected boolean[] keys = new boolean[256];
    public boolean up, down, left, right, space,isPaused=false;
      
    /**
     * Setta quale comando è stato premuto.
     */
    public void update() {
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        space = keys[KeyEvent.VK_SPACE] || keys[KeyEvent.VK_X];
    }
    
    public void updateReverse() {
        down = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        up = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        right = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        left = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        space = keys[KeyEvent.VK_SPACE] || keys[KeyEvent.VK_X];
    }
}