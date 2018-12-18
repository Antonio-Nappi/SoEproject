package pyroduck.entities.tile.powerup;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.graphics.Sprite;

/**
 *
 * @author 
 */
public class PowerupVehiclesTest {
    
    PowerupVehicles instance;
    
    public PowerupVehiclesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new PowerupVehicles(1, 1, Sprite.brick);
        Board.getInstance().addMob(new Player(0, 0));
        Game.getInstance().setPlayerSpeed(5);
        Game.getInstance().setBombRadius(4);
        Game.getInstance().setBombRate(3);
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of collide method, of class PowerupVehicles.
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
     * Test of setValues method, of class PowerupVehicles.
     */
    @Test
    public void testSetValues() {
        System.out.println("setValues");
        instance.setValues();    
        assertEquals(1.3, Game.getInstance().getPlayerSpeed(), 0);
        assertEquals(1, Game.getInstance().getBombRadius(), 0);
        assertEquals(1, Game.getInstance().getBombRate(), 0);
    }
}