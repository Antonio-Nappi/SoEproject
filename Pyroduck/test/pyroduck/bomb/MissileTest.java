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
import pyroduck.entities.Entity;
import pyroduck.entities.mob.enemy.graphic.Arbok;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;

/**
 *
 * @author stefa
 */
public class MissileTest {
    
    Missile missile;
    
    public MissileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        missile = new Missile(32, 1, 2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Missile.
     */
    @Test
    public void testUpdate() {
        
    }

    /**
     * Test of render method, of class Missile.
     */
    @Test
    public void testRender() {
        
    }

    /**
     * Test of collide method, of class Missile.
     */
    @Test
    public void testCollide() {
        System.out.println("collide");
        Entity e = new Arbok(32, 32);
        boolean test = missile.collide(e);
        assertEquals(test, false);
    }

    /**
     * Test of isMissile method, of class Missile.
     */
    @Test
    public void testIsMissile() {
        boolean test = missile.isMissile();
        assertEquals(test, true);
        test = missile.isBomb();
        assertEquals(test, true);
        test = missile.isMob();
        assertEquals(test, false);
    }
}
