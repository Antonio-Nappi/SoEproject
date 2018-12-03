package pyroduck.graphics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.mob.Player;

/**
 *
 * @author Bini, Corbisiero, Petruzzello
 */
public class ScreenTest {
    
    public ScreenTest() {
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
     * Test of clear method, of class Screen.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Screen instance = new Screen();
        instance.clear();
        for(int i=0; i<instance.pixels.length; i++){
            assertEquals(0, instance.pixels[i]);
        }  
    }

    /**
     * Test of setOffset method, of class Screen.
     */
    @Test
    public void testSetOffset() {
        System.out.println("setOffset");
        int xO = 10;
        int yO = 5;
        Screen.setOffset(xO, yO);
        assertEquals(xO, Screen.xOffset);
        assertEquals(yO, Screen.yOffset);
    }

    /**
     * Test of calculateXOffset method, of class Screen.
     */
    @Test
    public void testCalculateXOffset() {
        System.out.println("calculateXOffset");
        Board board = new Board(new Screen());
        Player player = new Player(1, 0, board, 32, 32);
        int expResult = 0;
        int result = Screen.calculateXOffset(board, player);
        assertEquals(expResult, result);
    }

    /**
     * Test of getWidth method, of class Screen.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Screen instance = new Screen();
        int expResult = Game.WIDTH;
        int result = instance.getWidth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHeight method, of class Screen.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Screen instance = new Screen();
        int expResult = Game.HEIGHT;
        int result = instance.getHeight();
        assertEquals(expResult, result);
    }
    
}
