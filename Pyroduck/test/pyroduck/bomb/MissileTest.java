package pyroduck.bomb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.enemy.graphic.Arbok;
import pyroduck.entities.mob.enemy.graphic.Enemy;
import pyroduck.entities.mob.enemy.graphic.Golbat;
import pyroduck.level.FileLevel;

/**
 *
 * @author 
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
        missile = new Missile(1, 1, 2);
        Game.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Missile.
     */
    @Test
    public void testUpdate() {
        for(int i=0; i<51; i++){
            assertFalse(missile.isRemoved());
            missile.update();
        }
        assertTrue(missile.isRemoved());
    }

    /**
     * Test of render method, of class Missile.
     */
    @Test
    public void testRender() {
        
    }
    
    public void testMove(){
        Entity e = Board.getInstance().getEntities()[(1 + 1 * FileLevel.WIDTH)];
        assertFalse(e.collide(missile));
        Enemy e1 = new Arbok(32, 72);
        missile.move();
        assertFalse(missile.isExploded());
        assertTrue(e1.isAlive());
        missile.move();
        assertTrue(missile.isExploded());
        assertFalse(e1.isAlive());
    }

    /**
     * Test of collide method, of class Missile.
     */
    @Test
    public void testCollide() {
        Enemy e = new Golbat(32, 32);
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
