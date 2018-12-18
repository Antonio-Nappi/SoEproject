package pyroduck.graphics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Corbisiero, Ferrara, La Femina
 */
public class SpriteTest {
    
    public SpriteTest() {
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
     * Test of movingSprite method, of class Sprite.
     */
    @Test
    public void testMovingSprite_5args() {
        System.out.println("movingSprite");
        Sprite normal = Sprite.bomb;
        Sprite x1 = Sprite.bomb_1;
        Sprite x2 = Sprite.bomb_2;
        int animate = 10;
        int time = 5;
        Sprite expResult = Sprite.bomb;
        Sprite result = Sprite.movingSprite(normal, x1, x2, animate, time);
        assertEquals(expResult, result);
    }

    /**
     * Test of movingSprite method, of class Sprite.
     */
    @Test
    public void testMovingSprite_4args() {
        System.out.println("movingSprite");
        Sprite x1 = Sprite.bomb;
        Sprite x2 = Sprite.bomb_1;
        int animate = 10;
        int time = 5;
        Sprite expResult = Sprite.bomb_1;
        Sprite result = Sprite.movingSprite(x1, x2, animate, time);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class Sprite.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Sprite instance = Sprite.bomb;
        int expResult = 32;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPixel method, of class Sprite.
     */
    @Test
    public void testGetPixel() {
        System.out.println("getPixel");
        int i = 2;
        Sprite instance = Sprite.player_dead1;
        int expResult = -65281;
        int result = instance.getPixel(i);
        assertEquals(expResult, result);
    } 
}