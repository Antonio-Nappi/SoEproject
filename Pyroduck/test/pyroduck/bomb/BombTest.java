/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import pyroduck.input.Keyboard;

/**
 *
 * 
 */
public class BombTest {
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Bomb.
     */
    @Test
    public void testUpdate() {
        Bomb b = new  Bomb(1, 1, new Board(new Keyboard(),new Screen(2, 2)));
        b.update();
        assertEquals(119.0, b.timeToExplode,0);
        assertEquals(20, b.timeAfter, 0);
        boolean t = b.isExploded();
        assertEquals(t, false);
        for(int i = 0; i<119; i++){
            b.update();
        }
        assertEquals(0.0, b.timeToExplode,0);
        assertEquals(20, b.timeAfter, 0);
        t = b.isExploded();
        assertEquals(t, false);
        for(int i = 0; i<20; i++){
            b.update();
        }
        assertEquals(0, b.timeAfter, 0);
        t = b.isExploded();
        assertEquals(t, true);
    }

    /**
     * Test of explosion method, of class Bomb.
     */
    @Test
    public void testExplosion() {
        System.out.println("explosion");
        Bomb instance = new Bomb(1, 1, new Board(new Keyboard(),new Screen(2, 2)));
        instance.explosion();
        boolean t = instance.isExploded();
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
        Bomb instance = new Bomb(1, 1, new Board(new Keyboard(),new Screen(2, 2)));;
        Explosion expResult = null;
        Explosion result = instance.explosionAt(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of isExploded method, of class Bomb.
     */
    @Test
    public void testIsExploded() {
        System.out.println("isExploded");
        Bomb instance = new Bomb(1, 1, new Board(new Keyboard(),new Screen(2, 2)));
        boolean expResult = false;
        boolean result = instance.isExploded();
        assertEquals(expResult, result);
    }

    /**
     * Test of collide method, of class Bomb.
     */
    @Test
    public void testCollide() {
        System.out.println("collide");
        Entity e = new Player(2, 1, new Board(new Keyboard(), new Screen(2, 2)));
        Bomb b = new Bomb(2, 1, new Board(new Keyboard(), new Screen(2, 2)));
        boolean test = b.collide(e);
        assertEquals(test, true);
        Entity e1 = new DirectionalExplosion(2, 1, 1,1,new Board(new Keyboard(), new Screen(2, 2)));
        boolean test1 = b.collide(e1);
        assertEquals(test1, false);
        Entity e2 = new BrickTile(2, 2, Sprite.brick);
        boolean test2 = b.collide(e2);
        assertEquals(test2, true);
        
    }
    
}
