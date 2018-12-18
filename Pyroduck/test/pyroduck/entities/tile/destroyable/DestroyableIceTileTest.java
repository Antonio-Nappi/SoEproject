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
public class DestroyableIceTileTest {
    
    private int timerBreak;
    private DestroyableIceTile instance;
    
    public DestroyableIceTileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new IntactState(1, 1, Sprite.ice);
        timerBreak = 2;
        instance.setTimerBreak(timerBreak);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of collide method, of class DestroyableIceTile.
     */
    @Test
    public void testCollide() {
        Entity e = new Player(1, 1);
        boolean expResult = false;
        boolean result = instance.collide(e);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTimerBreak method, of class DestroyableIceTile.
     */
    @Test
    public void testGetTimerBreak() {
        int expResult = 2;
        int result = instance.getTimerBreak();
        assertEquals(expResult, result);
    }

    /**
     * Test of decreaseTimerBreak method, of class DestroyableIceTile.
     */
    @Test
    public void testDecreaseTimerBreak() {
        instance.setTimerBreak(4);
        assertEquals(4, instance.timerBreak,0);
        instance.decreaseTimerBreak();
        assertEquals(3, instance.timerBreak,0);
  
    }

    /**
     * Test of setTimerBreak method, of class DestroyableIceTile.
     */
    @Test
    public void testSetTimerBreak() {
        instance.setTimerBreak(5);
        assertTrue(instance.getTimerBreak() == 5);
    }
 
}