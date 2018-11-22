/*
 * THIS CLASS IMPLEMENTS KEYLISTENER INTERFACE BECAUSE IT MENAGES THE CONTROL COMMAND OF THE PLAYER
 */
package pyroduck.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private boolean[] keys = new boolean[256];
    public boolean up, down, left, right, space;

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
    
    /**
     * Method not implemented.
     * @param e 
     */
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        try{
            keys[e.getKeyCode()] = true;
        }catch(ArrayIndexOutOfBoundsException ex){}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try{
            keys[e.getKeyCode()] = false;
        }catch(ArrayIndexOutOfBoundsException ex){}
    }
}    
