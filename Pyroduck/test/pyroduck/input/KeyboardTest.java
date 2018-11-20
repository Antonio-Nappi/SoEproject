package pyroduck.input;

import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Nappi, Montefusco
 */
public class KeyboardTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Keyboard.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Keyboard instance = new Keyboard();
        instance.update();
    }

    /**
     * Test of keyTyped method, of class Keyboard.
     */
    @Test
    public void testKeyTyped() {
        System.out.println("keyTyped");
        KeyEvent e = null;
        Keyboard instance = new Keyboard();
        instance.keyTyped(e);
    }

    /**
     * Test of keyPressed method, of class Keyboard.
     */
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent e = null;
        Keyboard instance = new Keyboard();
        instance.keyPressed(e);
    }

    /**
     * Test of keyReleased method, of class Keyboard.
     */
    @Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent e = null;
        Keyboard instance = new Keyboard();
        instance.keyReleased(e);
    }
    
}
