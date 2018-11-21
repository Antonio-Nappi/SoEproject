package pyroduck.entities;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.entities.tile.GrassTile;
import pyroduck.entities.tile.WallTile;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.graphics.Sprite;

/**
 * 
 * @author Montefusco, Nappi
 */
public class LayeredEntityTest {
    
    private LayeredEntity le;
    private LinkedList<Entity> entities = new LinkedList<Entity>();
    private int x, y;
    
    public LayeredEntityTest() {
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
        le = new LayeredEntity(x, y, new GrassTile(x ,y, Sprite.grass), new WallTile(x ,y, Sprite.wall));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class LayeredEntity.
     */
    @Test
    public void testUpdate() {
        Entity e = le.getTopEntity();
        e.remove();
        le.update();
        assertTrue(le.getTopEntity() instanceof GrassTile);
    }

    /**
     * Test of getTopEntity method, of class LayeredEntity.
     */
    @Test
    public void testGetTopEntity() {
        assertTrue(le.getTopEntity() instanceof WallTile);
    }

    /**
     * Test of collide method, of class LayeredEntity.
     */
    @Test
    public void testCollide() {
        Entity e = new BrickTile(x ,y, Sprite.brick);
        assertEquals(le.getTopEntity().collide(e), le.collide(e));
    }  
}