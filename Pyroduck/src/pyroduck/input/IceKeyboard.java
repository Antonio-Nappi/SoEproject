package pyroduck.input;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Game;
import pyroduck.exceptions.PyroduckException;

public class IceKeyboard extends Keyboard {
    
    private KeyEvent last;
    private static IceKeyboard ice = null;
    
    private IceKeyboard(){};
    
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
                Logger.getLogger(IceKeyboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_P && isPaused==true){
            try {
                Game.getInstance().resume();              
                isPaused=false;
            } catch (PyroduckException ex) {
                Logger.getLogger(IceKeyboard.class.getName()).log(Level.SEVERE, null, ex);
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
                    Thread.sleep(300);
                    keys[e.getKeyCode()] = false;
                } catch (InterruptedException ex) {
                    Logger.getLogger(IceKeyboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(ArrayIndexOutOfBoundsException ex){}
        
       
            
    }
    public static IceKeyboard getInstance(){
        if (ice == null)
            ice = new IceKeyboard();
        return ice;
    }
    
    public KeyEvent getLast(){
        return last;
    }
}