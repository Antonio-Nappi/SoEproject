package pyroduck.input;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Game;
import pyroduck.exceptions.PyroduckException;

public class GrassKeyboard extends Keyboard {
    private static GrassKeyboard grass= null;

    private GrassKeyboard(){}
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        try{
            keys[e.getKeyCode()] = true;
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
            keys[e.getKeyCode()] = false;                
        }catch(ArrayIndexOutOfBoundsException ex){}
    }
   public static GrassKeyboard getInstance(){
       if(grass == null)
           grass = new GrassKeyboard();
       return grass;
   }
}
