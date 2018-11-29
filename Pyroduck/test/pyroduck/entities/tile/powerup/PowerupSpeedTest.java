package pyroduck.entities.tile.powerup;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.input.IceKeyboard;

/**
 *
 * @author La Femina, Petruzzello
 */
public class PowerupSpeedTest {
    
    public PowerupSpeedTest() {
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
     * Test of collide method, of class PowerupSpeed.
     */
    @Test
    public void testCollide() {
        System.out.println("collide");
        Board b = new Board(new IceKeyboard(), new Screen());
        Entity e1 = new DirectionalExplosion(1, 2, 0, 1, b);
        Entity e2 = new Player(1, 1, b);
        Entity e3 = new BrickTile(1, 1, Sprite.brick);
        PowerupSpeed instance = new PowerupSpeed(1, 1, Sprite.brick);
        boolean des = instance.collide(e1);
        assertFalse(des);
        assertTrue(instance.isDestroyed());
        boolean d2 = instance.collide(e2);
        assertTrue(d2);
        assertEquals(instance.isRemoved(), true);
        boolean d3 = instance.collide(e3);
        assertFalse(d3);
    }

    /**
     * Test of setValues method, of class PowerupSpeed.
     */
    @Test
    public void testSetValues() {
        System.out.println("setValues");
        PowerupSpeed instance = new PowerupSpeed(1, 1, Sprite.brick);
        assertEquals(2, Game.getPlayerSpeed(), 0);
        instance.setValues();
        assertEquals(2.7, Game.getPlayerSpeed(), 0);
    }   
}
