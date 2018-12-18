package pyroduck.entities.mob;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.bomb.Bomb;
import pyroduck.input.Keyboard;

/**
 *
 * @author 
 */
public class SuperPlayerTest {
    
    SuperPlayer superp;
    Player p;
    
    public SuperPlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p = new Player(1, 1);
        superp = new SuperPlayer(p);
    }
    
    @After
    public void tearDown() {
    }



    /**
     * Test of calculateMove method, of class SuperPlayer.
     */
    @Test
    public void testCalculateMove() {
        System.out.println("calculateMove");
        assertFalse(superp.moving);
    }

    /**
     * Test of placeBomb method, of class SuperPlayer.
     */
    @Test
    public void testPlaceBomb() {
        System.out.println("placeBomb");
        int x = 2;
        int y = 1;
        Bomb b = new Bomb(x, y);
        superp.placeBomb(x, y);
        assertFalse(b == superp.bombs.get(0)); 
    }

    /**
     * Test of correctKeyboard method, of class SuperPlayer.
     */
    @Test
    public void testCorrectKeyboard() {
        System.out.println("correctKeyboard");
        Board.getInstance().setPlayer(1);
        superp.correctKeyboard();
        assertEquals(superp.input, Keyboard.getInstance());  
    }

    /**
     * Test of isSuperPlayer method, of class SuperPlayer.
     */
    @Test
    public void testIsSuperPlayer() {
        System.out.println("isSuperPlayer");
        assertFalse(p.isSuperPlayer());
        assertTrue(superp.isSuperPlayer());
    }

    /**
     * Test of kill method, of class SuperPlayer.
     */
    @Test
    public void testKill() {
        System.out.println("kill");
        assertTrue(p.alive);
    } 
}