package pyroduck.entities.tile;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.enemy.graphic.Golbat;
import pyroduck.graphics.Sprite;

/**
 *
 * @author stefa
 */
public class PortalTileTest {
    
    PortalTile portal;
    
    public PortalTileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Game.getInstance();
        portal = new PortalTile(1, 1, Sprite.portal);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of collide method, of class PortalTile.
     */
    @Test
    public void testCollide() {
        System.out.println("collide");
        assertFalse(portal.collide(Board.getInstance().getPlayer()));
        assertTrue(portal.collide(new Golbat(32, 32)));
    }
    
}
