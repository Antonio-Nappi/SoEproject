package pyroduck;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.audio.AudioPlayer;
import pyroduck.gui.Frame;
import pyroduck.input.Keyboard;

/**
 *
 * @author
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
    public void setUp() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        game = Game.getInstance();
        game.setSelected(0);
        game.setMusicOn(false);
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
     * Test of setGame method, of class Game.
     */
    @Test
    public void testSetGame() {
        System.out.println("setGame");
        Game.setGame();
        assertNotEquals(game, Game.getInstance());
    }

    /**
     * Test of restartGame method, of class Game.
     */
    @Test
    public void testRestartGame() {
        System.out.println("restartGame");
        game.restartGame();
        assertEquals(1, Board.getInstance().getLevel(), 0);
        testResetProperties();
    }

    /**
     * Test of resume method, of class Game.
     */
    @Test
    public void testResume() {
        System.out.println("resume");
        game.resume();
        assertFalse(Board.getInstance().isPause());
    }

    /**
     * Test of pause method, of class Game.
     */
    @Test
    public void testPause() {
        System.out.println("pause");
        game.pause();
        assertTrue(Board.getInstance().isPause());
    }

    /**
     * Test of resetProperties method, of class Game.
     */
    @Test
    public void testResetProperties() {
        game.resetProperties();
        assertEquals(1.3, game.getPlayerSpeed(), 0);
        assertEquals(1, game.getBombRadius(), 0);
        assertEquals(1, game.getBombRate(), 0);
        assertFalse(Game.getInstance().reverse);
    }

    /**
     * Test of addBombRate method, of class Game.
     */
    @Test
    public void testAddBombRate() {
        System.out.println("addBombRate");
        int i = 1;
        game.addBombRate(i);
        assertEquals(2, game.getBombRate(), 0);    }

    /**
     * Test of addBombRadius method, of class Game.
     */
    @Test
    public void testAddBombRadius() {
        System.out.println("addBombRadius");
        int i = 1;
        game.addBombRadius(i);
        assertEquals(2, game.getBombRadius(), 0);
    }

    /**
     * Test of addPlayerSpeed method, of class Game.
     */
    @Test
    public void testAddPlayerSpeed() {
        System.out.println("addPlayerSpeed");
        double i = 1.0;
        game.addPlayerSpeed(i);
        assertEquals(2.3, game.getPlayerSpeed(), 0);
    }

    /**
     * Test of decreasePlayerSpeed method, of class Game.
     */
    @Test
    public void testDecreasePlayerSpeed() {
        System.out.println("decreasePlayerSpeed");
        double i = 1.0;
        game.decreasePlayerSpeed(i);
        assertEquals(0.3, game.getPlayerSpeed(), 0.1);
    }

    /**
     * Test of reverseInput method, of class Game.
     */
    @Test
    public void testReverseInput() {
        System.out.println("reverseInput");
        boolean b = false;
        Game instance = null;
        game.reverseInput(b);
        assertFalse(game.reverse);
    }

    /**
     * Test of activeTimerEnd method, of class Game.
     */
    @Test
    public void testActiveTimerEnd() throws IOException {
        System.out.println("activeTimerEnd");
        Frame frame = new Frame();
        game.activeTimerEnd(frame);
        assertTrue(game.ending);
        assertEquals(frame, game.frameToHidden);
        assertEquals(0, game.timerEnd,0);
    }

    /**
     * Test of getPlayerSpeed method, of class Game.
     */
    @Test
    public void testGetPlayerSpeed() {
        System.out.println("getPlayerSpeed");
        double expResult = 1.3;
        double result = game.getPlayerSpeed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getBombRate method, of class Game.
     */
    @Test
    public void testGetBombRate() {
        System.out.println("getBombRate");
        int expResult = 1;
        int result = game.getBombRate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBombRadius method, of class Game.
     */
    @Test
    public void testGetBombRadius() {
        System.out.println("getBombRadius");
        int expResult = 1;
        int result = game.getBombRadius();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSelected method, of class Game.
     */
    @Test
    public void testGetSelected() {
        System.out.println("getSelected");
        int expResult = 0;
        int result = game.getSelected();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDemo method, of class Game.
     */
    @Test
    public void testGetDemo() {
        System.out.println("getDemo");
        boolean expResult = false;
        boolean result = game.getDemo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSelected method, of class Game.
     */
    @Test
    public void testSetSelected() {
        System.out.println("setSelected");
        int selected = 0;
        game.setSelected(selected);
        assertEquals(selected, game.getSelected(), 0);
    }

    /**
     * Test of setBombRate method, of class Game.
     */
    @Test
    public void testSetBombRate() {
        System.out.println("setBombRate");
        int bombRate = 1;
        game.setBombRate(bombRate);
        assertEquals(1, game.getBombRate(), 0);
    }

    /**
     * Test of setBombRadius method, of class Game.
     */
    @Test
    public void testSetBombRadius() {
        System.out.println("setBombRadius");
        int bombRadius = 1;
        game.setBombRate(bombRadius);
        assertEquals(1, game.getBombRadius(), 0);
    }

    /**
     * Test of setPlayerSpeed method, of class Game.
     */
    @Test
    public void testSetPlayerSpeed() {
        System.out.println("setPlayerSpeed");
        double playerSpeed = 0.0;
        game.setPlayerSpeed(playerSpeed);
        assertEquals(0, game.getPlayerSpeed(), 0);
    }

    /**
     * Test of setDemo method, of class Game.
     */
    @Test
    public void testSetDemo() {
        System.out.println("setDemo");
        boolean demo = false;
        game.setDemo(demo);
        assertFalse(game.getDemo());
    }

    /**
     * Test of setMusicOn method, of class Game.
     */
    @Test
    public void testSetMusicOn() throws Exception {
        System.out.println("setMusicOn");
        boolean music = true;
        game.setMusicOn(music);
        assertTrue(game.getMusicOn());
    }

    /**
     * Test of getMusicOn method, of class Game.
     */
    @Test
    public void testGetMusicOn() {
        System.out.println("getMusicOn");
        boolean result = game.getMusicOn();
        assertFalse(result);
    }

}
