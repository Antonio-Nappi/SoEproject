package pyroduck.entities.tile.powerup;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.graphics.Sprite;

/**
 *
 * @author 
 */
public class PowerupNotSlipTest {
    
    PowerupNotSlip instance;
    
    public PowerupNotSlipTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Board.getInstance().setInput();
        Player player = new Player(1, 1);
        Board.getInstance().addMob(player);
        Board.getInstance().getInput().setIce(true);
        instance = new PowerupNotSlip(1, 1, Sprite.brick);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of collide method, of class PowerupNotSlip.
     */
    @Test
    public void testCollide() {
        System.out.println("collide");
        Entity e1 = new Player(1, 1);      
        Entity e2 = new BrickTile(1, 1, Sprite.brick);
        boolean d1 = instance.collide(e1);
        assertTrue(d1);
        assertEquals(instance.isRemoved(), true);
        boolean d2 = instance.collide(e2);
        assertFalse(d2);
    }

    /**
     * Test of setValues method, of class PowerupNotSlip.
     */
    @Test
    public void testSetValues() {
        System.out.println("setValues");
        assertTrue(Board.getInstance().getInput().isIce());
        instance.setValues();
        assertFalse(Board.getInstance().getInput().isIce());
    }  
}