package pyroduck.entities.tile.destroyable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Montefusco
 */
public class WaterStateTest {
    
    private int x, y;
    private Sprite sprite;
    private WaterState water;
    
    public WaterStateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        x = 0;
        y = 0;
        sprite = Sprite.icebroken_4;
        water = new WaterState(x, y, sprite);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of collide method, of class WaterState.
     */
    @Test
    public void testCollide() {
        Entity e = new Player(x, y);
        boolean result = e.collide(water);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    /**
     * Test of nextState method, of class WaterState.
     */
    @Test
    public void testNextState() {
        ContextDestroyable context = new ContextDestroyable();
        DestroyableIceTile result = water.nextState(context);
        assertTrue(result instanceof WaterState);
    }   
}