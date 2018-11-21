package pyroduck.entities.tile.destroyable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.bomb.DirectionalExplosion;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.input.Keyboard;

/**
 *
 * @author Bini, Petruzzello
 */
public class BrickTileTest {
    
    private int x, y;
    BrickTile brick;
    
    public BrickTileTest() {
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
        brick = new BrickTile(x, y, Sprite.brick);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class BrickTile.
     */
    @Test
    public void testUpdate() {
        brick.collide(new DirectionalExplosion(x, y+1, 2, 1, new Board(new Keyboard(), new Screen())));
        for(int i=0; i<21; i++){
            assertFalse(brick.isRemoved());
            brick.update();
        }
        assertTrue(brick.isRemoved());
    }

    /**
     * Test of collide method, of class BrickTile.
     */
    @Test
    public void testMovingSprite() {
        brick.collide(new DirectionalExplosion(x, y+1, 2, 1, new Board(new Keyboard(), new Screen())));
        for(int i=0; i<10; i++){
            assertEquals(Sprite.brick_exploded, brick.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2));
            brick.update();
        }
        for(int i=0; i<10; i++){
            assertEquals(Sprite.brick_exploded1, brick.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2));
            brick.update();
        }
        assertEquals(Sprite.brick_exploded2, brick.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2));
    }
    
    /**
     * Test of collide method, of class BrickTile.
     */
    @Test
    public void testCollide() {
        assertFalse(brick.isDestroyed());
        brick.collide(new DirectionalExplosion(x, y, 2, 1, new Board(new Keyboard(), new Screen())));
        assertTrue(brick.isDestroyed());
    }
}
