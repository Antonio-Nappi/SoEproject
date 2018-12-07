package pyroduck.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Game;
import pyroduck.exceptions.PyroduckException;

/**
 *
 * @author 
 */
public class Keyboard implements KeyListener{
    
    protected static Keyboard keyboard;
    protected boolean[] keys = new boolean[256];
    public boolean up, down, left, right, space, isPaused=false, ice;
    private KeyEvent last;
    
    private Keyboard(){};
    
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
            if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT)
                last = e;
        }catch(ArrayIndexOutOfBoundsException ex){}
        
        if(e.getKeyCode() == KeyEvent.VK_P && isPaused==false){
            try {
                Game.getInstance().pause();           
                isPaused=true;
            } catch (PyroduckException ex) {
                Logger.getLogger(Keyboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_P && isPaused==true){
            try {
                Game.getInstance().resume();              
                isPaused=false;
            } catch (PyroduckException ex) {
                Logger.getLogger(Keyboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try{
            if(e.getKeyCode() == KeyEvent.VK_SPACE||e.getKeyCode() == KeyEvent.VK_X)
                keys[e.getKeyCode()] = false;
            else{
                try {
                    if(ice)
                        Thread.sleep(300);
                    keys[e.getKeyCode()] = false;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Keyboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(ArrayIndexOutOfBoundsException ex){}     
    }
    
    public void setIce(boolean ice){
        this.ice = ice;
    }
    
    public boolean isIce(){
        return ice;
    }
    
    public KeyEvent getLast(){
        return last;
    }
    
    public static Keyboard getInstance(){
        if(keyboard == null)
            keyboard = new Keyboard();
        return keyboard;
    }
}