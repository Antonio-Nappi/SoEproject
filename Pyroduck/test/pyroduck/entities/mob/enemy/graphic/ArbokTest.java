package pyroduck.entities.mob.enemy.graphic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Bini, Petruzzello
 */
public class ArbokTest {
    
    Arbok instance;
            
    public ArbokTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Arbok(1, 1);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of move method, of class Enemy.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        double xa = 0.0;
        double ya = 0.0;
        instance.canMove(xa, ya);
        assertEquals(instance.getDirection() , 0, 3);
        assertEquals(instance.getX(), 1.0,0);
        assertEquals(instance.getY(), 1.0,0);
    }
    
    /**
     * Test of canMove method, of class Enemy.
     */
    @Test
    public void testCanMove() {
        System.out.println("canMove");
        double x = 0.0;
        double y = 0.0;
        assertFalse(instance.canMove(x, y));
    }
    
    /**
     * Test of collide method, of class Enemy.
     */
    @Test
    public void testCollide() {
        System.out.println("collide");
        Entity e1 = new DirectionalExplosion(1, 2, 0, 1);
        Entity e2 = new Player(1, 1);
        Entity e3 = new BrickTile(1, 1, Sprite.brick);
        boolean des = instance.collide(e1);
        assertTrue(des);
        boolean d2 = instance.collide(e2);
        assertTrue(d2);
        boolean d3 = instance.collide(e3);
        assertFalse(d3);
    }
    
    /**
     * Test of afterKill method, of class Enemy.
     */
    @Test
    public void testAfterKill() {
        System.out.println("afterKill");
        assertEquals(20, instance.timeAfterDeath, 0);
        for(int i = 0; i<20; i++)
            instance.afterKill();
        assertEquals(0, instance.timeAfterDeath, 0);
        assertEquals(30, instance.finalAnimation, 0);
        for(int i = 0; i<30; i++)
            instance.afterKill();
        assertEquals(0, instance.finalAnimation, 0);
    }
}