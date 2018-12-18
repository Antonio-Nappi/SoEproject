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
 * @author La Femina, Petruzzello
 */
public class PowerupBombsTest {
    
    public PowerupBombsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Board.getInstance().addMob(new Player(0, 0));
        Game.getInstance().setBombRate(1);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of collide method, of class PowerupBombs.
     */
    @Test
    public void testCollide() {
        System.out.println("collide");
        Entity e1 = new Player(1, 1);      
        Entity e2 = new BrickTile(1, 1, Sprite.brick);
        PowerupBombs instance = new PowerupBombs(1, 1, Sprite.brick);
        boolean d1 = instance.collide(e1);
        assertTrue(d1);
        assertEquals(instance.isRemoved(), true);
        boolean d2 = instance.collide(e2);
        assertFalse(d2);
    }

    /**
     * Test of setValues method, of class PowerupBombs.
     */
    @Test
    public void testSetValues() {
        System.out.println("setValues");
        PowerupBombs instance = new PowerupBombs(1, 1, Sprite.brick);
        assertEquals(1, Game.getInstance().getBombRate(), 0);
        instance.setValues();
        assertEquals(2, Game.getInstance().getBombRate(), 0);
    }  
}