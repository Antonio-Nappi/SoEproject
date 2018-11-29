/*
 * THIS CLASS IMPLEMENTS KEYLISTENER INTERFACE BECAUSE IT MENAGES THE CONTROL COMMAND OF THE PLAYER
 */
package pyroduck.input;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IceKeyboard extends Keyboard {
private static IceKeyboard ice = null;
    private IceKeyboard(){};
    /**
     * Method not implemented.
     * @param e 
     */
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        try{
            keys[e.getKeyCode()] = true;
        }catch(ArrayIndexOutOfBoundsException ex){}
    }

    public void keyReleased(KeyEvent e) {
        try{
            if(e.getKeyCode() == KeyEvent.VK_SPACE||e.getKeyCode() == KeyEvent.VK_X)
            keys[e.getKeyCode()] = false;
            else{
                try {
                    Thread.sleep(240);
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
}    

