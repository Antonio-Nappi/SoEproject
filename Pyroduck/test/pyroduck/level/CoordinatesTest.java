package pyroduck.level;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Game;

/**
 *
 * @author 
 */
public class CoordinatesTest {
    
    public CoordinatesTest() {
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
     * Test of pixelToTile method, of class Coordinates.
     */
    @Test
    public void testPixelToTile() {
        System.out.println("pixelToTile");
        double i = 32.0;
        int size = Game.TILES_SIZE;
        int expResult = 1;
        int result = Coordinates.pixelToTile(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of tileToPixel method, of class Coordinates.
     */
    @Test
    public void testTileToPixel_int() {
        System.out.println("tileToPixel");
        int i = 0;
        int size = Game.TILES_SIZE;
        int expResult = 0;
        int result = Coordinates.tileToPixel(i);
        assertEquals(expResult, result); 
    }

    /**
     * Test of tileToPixel method, of class Coordinates.
     */
    @Test
    public void testTileToPixel_double() {
        System.out.println("tileToPixel");
        double i = 1.0;
        int size = Game.TILES_SIZE;
        int expResult = 32;
        int result = Coordinates.tileToPixel(i);
        assertEquals(expResult, result);
    }   
}
