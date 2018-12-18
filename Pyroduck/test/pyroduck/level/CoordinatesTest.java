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
 * @author Corbisiero, Ferrara, La Femina
 */
public class CoordinatesTest {
    
    private int size;
    
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
        size = Game.TILES_SIZE;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of pixelToTile method, of class Coordinates.
     */
    @Test
    public void testPixelToTile() {
        double i = 32.0;    
        int expResult = 1;
        int result = Coordinates.pixelToTile(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of tileToPixel method, of class Coordinates.
     */
    @Test
    public void testTileToPixel_int() {
        int i = 0;
        int expResult = 0;
        int result = Coordinates.tileToPixel(i);
        assertEquals(expResult, result); 
    }

    /**
     * Test of tileToPixel method, of class Coordinates.
     */
    @Test
    public void testTileToPixel_double() {
        double i = 1.0;
        int expResult = 32;
        int result = Coordinates.tileToPixel(i);
        assertEquals(expResult, result);
    }   
}