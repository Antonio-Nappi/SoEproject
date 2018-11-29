/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.input;

import java.awt.event.KeyEvent;

/**
 *
 * @author Antonio
 */
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
