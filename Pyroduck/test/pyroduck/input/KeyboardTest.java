package pyroduck.input;

import java.awt.Button;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 
 */
public class KeyboardTest {
    
    private Keyboard keyboard = null;
    
    public KeyboardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        keyboard = Keyboard.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of keyPressed method, of class Keyboard.
     */
    @Test
    public void testKeyPressed(){
        Button a = new Button("click");
        KeyEvent e = new KeyEvent(a, 1, 20, 1, 10, 'a');
        keyboard.keyPressed(e);
        assertTrue(keyboard.keys[e.getKeyCode()]);
    }

    /**
     * Test of keyReleased method, of class Keyboard.
     */
    @Test
    public void testKeyReleased() {
        Button a = new Button("click");
        KeyEvent e = new KeyEvent(a, 1, 20, 1, 10, 'a');
        keyboard.keyReleased(e);
        assertFalse(keyboard.keys[e.getKeyCode()]);
    }

    /**
     * Test of getInstance method, of class Keyboard.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        assertSame(keyboard, Keyboard.getInstance());
    }
    
    
    /**
     * Test of setIce method, of class Keyboard.
     */
    @Test
    public void testSetIce(){
        System.out.println("setIce");
        keyboard.setIce(true);
        assertTrue(keyboard.isIce());
        keyboard.setIce(false);
        assertFalse(keyboard.isIce());
    }
    
    /**
     * Test of isIce method, of class Keyboard.
     */
    @Test
    public void testIsIce(){
        System.out.println("isIce");
        keyboard.setIce(true);
        assertTrue(keyboard.isIce());
        keyboard.setIce(false);
        assertFalse(keyboard.isIce());
    }
    
    /**
     * Test of releaseAll method, of class Keyboard.
     */
    @Test
    public void testReleaseAll(){
        System.out.println("releaseAll");
        keyboard.keys[0] = true;
        keyboard.keys[1] = true;
        keyboard.keys[2] = true;
        keyboard.releaseAll();
        assertFalse(keyboard.keys[0]);
        assertFalse(keyboard.keys[1]);
        assertFalse(keyboard.keys[2]);
    }
}