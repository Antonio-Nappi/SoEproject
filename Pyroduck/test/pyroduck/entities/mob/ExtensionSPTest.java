package pyroduck.entities.mob;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.entities.Entity;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.graphics.Sprite;

/**
 *
 * @author 
 */
public class ExtensionSPTest {
    
    private ExtensionSP instance;
    
    public ExtensionSPTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ExtensionSP(0, 0, Sprite.brick);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of collide method, of class ExtensionSP.
     */
    @Test
    public void testCollide() {
        Entity e = new Player(1, 1);
        assertFalse(instance.collide(e));
        Entity e1 = new BrickTile(2, 2, Sprite.brick);
        assertFalse(instance.collide(e1));
    }

    /**
     * Test of move method, of class ExtensionSP.
     */
    @Test
    public void testMove() {
        instance.move(2.0, 2.0);
        assertEquals(instance.getX(), 2.0, 0);
        assertEquals(instance.getY(), 2.0, 0);
    }
}