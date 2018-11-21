package pyroduck.bomb;

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
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.input.Keyboard;

/**
 *
 * @author 
 */
public class BombTest {
    
    Bomb bomb;
    
    public BombTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bomb = new  Bomb(1, 1, new Board(new Keyboard(),new Screen()));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Bomb.
     */
    @Test
    public void testUpdate() {
        bomb.update();
        assertEquals(119.0, bomb.timeToExplode,0);
        assertEquals(20, bomb.timeAfter, 0);
        boolean t = bomb.isExploded();
        assertEquals(t, false);
        for(int i = 0; i<119; i++){
            bomb.update();
        }
        assertEquals(0.0, bomb.timeToExplode,0);
        assertEquals(20, bomb.timeAfter, 0);
        t = bomb.isExploded();
        assertEquals(t, false);
        for(int i = 0; i<20; i++){
            bomb.update();
        }
        assertEquals(0, bomb.timeAfter, 0);
        t = bomb.isExploded();
        assertEquals(t, true);
    }

    /**
     * Test of explosion method, of class Bomb.
     */
    @Test
    public void testExplosion() {
        System.out.println("explosion");
        bomb.explosion();
        boolean t = bomb.isExploded();
        assertEquals(t, true);
        
    }

    /**
     * Test of explosionAt method, of class Bomb.
     */
    @Test
    public void testExplosionAt() {
        System.out.println("explosionAt");
        int x = 0;
        int y = 0;
        Explosion expResult = null;
        Explosion result = bomb.explosionAt(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of isExploded method, of class Bomb.
     */
    @Test
    public void testIsExploded() {
        System.out.println("isExploded");
        boolean expResult = false;
        boolean result = bomb.isExploded();
        assertEquals(expResult, result);
    }

    /**
     * Test of collide method, of class Bomb.
     */
    @Test
    public void testCollide() {
        System.out.println("collide");
        Entity e = new Player(2, 1, new Board(new Keyboard(), new Screen()));
        boolean test = bomb.collide(e);
        assertEquals(test, true);
        Entity e1 = new DirectionalExplosion(2, 1, 1,1,new Board(new Keyboard(), new Screen()));
        boolean test1 = bomb.collide(e1);
        assertEquals(test1, false);
        Entity e2 = new BrickTile(2, 2, Sprite.brick);
        boolean test2 = bomb.collide(e2);
        assertEquals(test2, true);    
    } 
}
