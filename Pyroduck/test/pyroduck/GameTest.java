package pyroduck;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.exceptions.PyroduckException;

/**
 *
 * @author all
 */
public class GameTest {
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
    public void setUp() throws PyroduckException {
        game = Game.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class Game.
     */
    @Test
    public void testGetInstance() throws Exception {
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
        try {
            game.getBoard().newGame();
        } catch (IOException ex) {
            Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Game.addBombRate(0);
        assertEquals(Game.bombRate, 1);
        Game.addBombRate(1);
        assertEquals(Game.bombRate, 2);
    }

    /**
     * Test of addBombRadius method, of class Game.
     */
    @Test
    public void testAddBombRadius() {
        System.out.println("addBombRadius");
        try {
            game.getBoard().newGame();
        } catch (IOException ex) {
            Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Game.addBombRadius(0);
        assertEquals(Game.bombRadius, 1);
        Game.addBombRadius(1);
        assertEquals(Game.bombRadius, 2);
    }

    /**
     * Test of addPlayerSpeed method, of class Game.
     */
    @Test
    public void testAddPlayerSpeed() {
        System.out.println("addPlayerSpeed");
        try {
            game.getBoard().newGame();
        } catch (IOException ex) {
            Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Game.addPlayerSpeed(0);
        assertEquals(Game.playerSpeed, 1.3,0);
        Game.addPlayerSpeed(1.0);
        assertEquals(Game.playerSpeed, 2.3,0);
    }

    /**
     * Test of decreasePlayerSpeed method, of class Game.
     */
    @Test
    public void testDecreasePlayerSpeed() {
        System.out.println("decreasePlayerSpeed");
        try {
            game.getBoard().newGame();
        } catch (IOException ex) {
            Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Game.decreasePlayerSpeed(0.5);
        assertEquals(Game.playerSpeed, 0.8,0);
    }

    /**
     * Test of getPlayerSpeed method, of class Game.
     */
    @Test
    public void testGetPlayerSpeed() {
        System.out.println("getPlayerSpeed");
        double expResult = 1.3;
        double result = Game.getPlayerSpeed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getBombRate method, of class Game.
     */
    @Test
    public void testGetBombRate() {
        System.out.println("getBombRate");
        int expResult = 1;
        int result = Game.getBombRate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBombRadius method, of class Game.
     */
    @Test
    public void testGetBombRadius() {
        System.out.println("getBombRadius");
        int expResult = 1;
        int result = Game.getBombRadius();
        assertEquals(expResult, result);
    }
}
