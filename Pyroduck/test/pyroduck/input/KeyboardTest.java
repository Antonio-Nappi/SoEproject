package pyroduck.input;

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
    
    Keyboard keyboard = null;
    
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
    }

    /**
     * Test of keyReleased method, of class Keyboard.
     */
    @Test
    public void testKeyReleased() {
    }

    /**
     * Test of getInstance method, of class Keyboard.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        assertSame(keyboard, Keyboard.getInstance());
    }
}