package pyroduck;

import java.util.Timer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.input.Keyboard;

/**
 *
 * @author all
 */
public class GameTest {
    Board board;
    Game game;
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        board = Board.getInstance();
        game = Game.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class Game.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Game result = Game.getInstance();
        assertSame(game, result);
    }

    /**
     * Test of addBombRate method, of class Game.
     */
    @Test
    public void testAddBombRate() {
        System.out.println("addBombRate");
        Game.getInstance().addBombRate(0);
        assertEquals(Game.getInstance().bombRate, 1);
        Game.getInstance().addBombRate(1);
        assertEquals(Game.getInstance().bombRate, 2);
    }

    /**
     * Test of addBombRadius method, of class Game.
     */
    @Test
    public void testAddBombRadius() {
        System.out.println("addBombRadius");
        Game.getInstance().addBombRadius(0);
        assertEquals(Game.getInstance().bombRadius, 1);
        Game.getInstance().addBombRadius(1);
        assertEquals(Game.getInstance().bombRadius, 2);
    }

    /**
     * Test of addPlayerSpeed method, of class Game.
     */
    @Test
    public void testAddPlayerSpeed() {
        System.out.println("addPlayerSpeed");
        Game.getInstance().addPlayerSpeed(0);
        assertEquals(Game.getInstance().playerSpeed, 1.3,0);
        Game.getInstance().addPlayerSpeed(1.0);
        assertEquals(Game.getInstance().playerSpeed, 2.3,0);
    }

    /**
     * Test of decreasePlayerSpeed method, of class Game.
     */
    @Test
    public void testDecreasePlayerSpeed() {
        System.out.println("decreasePlayerSpeed");
        Game.getInstance().decreasePlayerSpeed(0.5);
        assertEquals(Game.getInstance().playerSpeed, 0.8,0);
    }

    /**
     * Test of getPlayerSpeed method, of class Game.
     */
    @Test
    public void testGetPlayerSpeed() {
        System.out.println("getPlayerSpeed");
        double expResult = 1;
        double result = Game.getInstance().getPlayerSpeed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getBombRate method, of class Game.
     */
    @Test
    public void testGetBombRate() {
        System.out.println("getBombRate");
        int expResult = 1;
        int result = Game.getInstance().getBombRate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBombRadius method, of class Game.
     */
    @Test
    public void testGetBombRadius() {
        System.out.println("getBombRadius");
        int expResult = 1;
        int result = Game.getInstance().getBombRadius();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setSelected method, of class Game.
     */
    @Test
    public void testSetSelected() {
        int selected = 1;
        game.setSelected(selected);
        assertEquals(selected, Game.getInstance().playerSpeed, 0);
    }
    
    /**
     * Test of getSelected method, of class Game.
     */
    @Test
    public void testGetSelected() {
        assertEquals(game.getSelected(), 1.0, 0); 
    }
    
    /**
     * Test of reverseInput method, of class Game.
     */
    @Test
    public void testReverseInput() {
        assertFalse(Game.getInstance().reverse);
        game.reverseInput(true);
        assertTrue(game.reverse);
    }
      /**
     * Test of start method, of class Game.
     */
    @Test
    public void testStart() {
        game.start();
        assertSame(game.getInput(), Keyboard.getInstance());
    }
}