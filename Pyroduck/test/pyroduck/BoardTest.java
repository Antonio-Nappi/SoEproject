package pyroduck;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.bomb.Bomb;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.Player;
import pyroduck.entities.tile.WallTile;
import pyroduck.entities.tile.destroyable.ContextDestroyable;
import pyroduck.entities.tile.destroyable.DestroyableIceTile;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.input.Keyboard;

/**
 *
 * @author stefa
 */
public class BoardTest {
    Board board;
    
    public BoardTest() {
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
        board.changeLevel(1);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Board.
     */
    @Test
    public void testUpdate_0args() {
        System.out.println("update");
        Board instance = null;
        instance.update();
    }


    /**
     * Test of setLives method, of class Board.
     */
    @Test
    public void testSetLives() {
        System.out.println("setLives");
        int lives = 1;
        board.setLives(lives);
        assertEquals(lives, board.getLives(), 0);
    }

    /**
     * Test of restartLevel method, of class Board.
     */
    @Test
    public void testRestartLevel() {
        System.out.println("restartLevel");
        int l = board.getLevel();
        board.restartLevel();
        assertEquals(l, board.getLevel(), 0);
    }

    /**
     * Test of changeLevel method, of class Board.
     */
    @Test
    public void testChangeLevel() {
        System.out.println("changeLevel");
        int numlevel = 2;
        board.changeLevel(numlevel);
        assertEquals(numlevel, board.getLevel(), 0);
    }

    /**
     * Test of detectNoEnemies method, of class Board.
     */
    @Test
    public void testDetectNoEnemies() {
        System.out.println("detectNoEnemies");
        boolean result = board.detectNoEnemies();
        assertFalse(result);
    }

    /**
     * Test of getEntity method, of class Board.
     */
    @Test
    public void testGetEntity() {
        System.out.println("getEntity");
        double x = 0.0;
        double y = 0.0;
        Mob m = null;
        Entity result = board.getEntity(x, y, m);
        assertTrue(result instanceof WallTile);
    }

    /**
     * Test of getBombs method, of class Board.
     */
    @Test
    public void testGetBombs() {
        System.out.println("getBombs");
        assertEquals(board.bombs, board.getBombs());
    }

    /**
     * Test of getBombAt method, of class Board.
     */
    @Test
    public void testGetBombAt() {
        System.out.println("getBombAt");
        double x = 0.0;
        double y = 0.0;
        Bomb result = board.getBombAt(x, y);
        assertNull(result);
    }

    /**
     * Test of getPlayer method, of class Board.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        Player expResult = new Player(0, 0);
        Player result = board.getPlayer();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getMobsAtExcluding method, of class Board.
     */
    @Test
    public void testGetMobsAtExcluding() {
        System.out.println("getMobsAtExcluding");
        int x = 1;
        int y = 1;
        Mob a = board.getPlayer();
        ArrayList<Mob> result = board.getMobsAtExcluding(x, y, a);
        assertEquals(0,result.size(), 0);
    }

    /**
     * Test of getEntityAt method, of class Board.
     */
    @Test
    public void testGetEntityAt() {
        System.out.println("getEntityAt");
        double x = 0.0;
        double y = 0.0;
        assertTrue(board.getEntityAt(x, y) instanceof WallTile);
    }

    /**
     * Test of getMobs method, of class Board.
     */
    @Test
    public void testGetMobs() {
        System.out.println("getMobs");
        List<Mob> result = board.getMobs();
        assertEquals(8,result.size(),0);
    }

    /**
     * Test of getEntities method, of class Board.
     */
    @Test
    public void testGetEntities() {
        System.out.println("getEntities");
        int expResult = 403;
        int result = board.getEntities().length;
        assertEquals(expResult, result);
    }

    /**
     * Test of addMob method, of class Board.
     */
    @Test
    public void testAddMob() {
        System.out.println("addMob");
        board.addMob(new Player(0, 0));
        int newSize = 9;
        int size = board.getMobs().size();
        assertEquals(newSize, size,0);
    }

    /**
     * Test of getInput method, of class Board.
     */
    @Test
    public void testGetInput() {
        System.out.println("getInput");
        board.setInput();
        Keyboard result = board.getInput();
        assertSame(Keyboard.getInstance(), result);
    }

    /**
     * Test of getLevel method, of class Board.
     */
    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        int expResult = 1;
        int result = board.getLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of addBomb method, of class Board.
     */
    @Test
    public void testAddBomb() {
        System.out.println("addBomb");
        Bomb b = new Bomb(0, 0);
        board.bombs.clear();
        assertEquals(0, board.bombs.size(), 0);
        board.addBomb(b);
        assertEquals(1, board.bombs.size(), 0);
    }

    /**
     * Test of getLives method, of class Board.
     */
    @Test
    public void testGetLives() {
        System.out.println("getLives");
        int expResult = 3;
        int result = board.getLives();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPoints method, of class Board.
     */
    @Test
    public void testSetPoints() {
        System.out.println("setPoints");
        int points = 100;
        board.setPoints(points);
        int exp = board.getPoints();
        assertEquals(100, exp, 0);
    }

    /**
     * Test of getMobAt method, of class Board.
     */
    @Test
    public void testGetMobAt() {
        System.out.println("getMobAt");
        double x = 1.0;
        double y = 1.0;
        Mob result = board.getMobAt(x, y);
        assertNotNull(result instanceof Player);
    }

    /**
     * Test of setInput method, of class Board.
     */
    @Test
    public void testSetInput() {
        System.out.println("setInput");
        board.setInput();
        assertFalse(board.getInput().isIce());
    }

    /**
     * Test of getPlayerRight method, of class Board.
     */
    @Test
    public void testGetPlayerRight() {
        System.out.println("getPlayerRight");
        int expResult = 0;
        int result = board.getPlayerRight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPoints method, of class Board.
     */
    @Test
    public void testGetPoints() {
        System.out.println("getPoints");
        int expResult = 100;
        int result = board.getPoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of getContextState method, of class Board.
     */
    @Test
    public void testGetContextState() {
        System.out.println("getContextState");
        assertTrue(board.getContextState() instanceof ContextDestroyable);
    }

    /**
     * Test of getDestroyableIceTile method, of class Board.
     */
    @Test
    public void testGetDestroyableIceTile() {
        System.out.println("getDestroyableIceTile");
        List<DestroyableIceTile> result = board.getDestroyableIceTile();
        assertEquals(0, result.size(),0);
    }

    /**
     * Test of isPause method, of class Board.
     */
    @Test
    public void testIsPause() {
        System.out.println("isPause");
        assertFalse(board.isPause());
    }

    /**
     * Test of setPause method, of class Board.
     */
    @Test
    public void testSetPause() {
        System.out.println("setPause");
        boolean pause = false;
        board.setPause(pause);
        assertFalse(board.pause);
    }
    
    /**
     * Test of setPlayer method, of class Board.
     */
    @Test
    public void testSetPlayer() {
        System.out.println("setPlayer");
        board.setPlayer(0);
        assertEquals(0, board.getPlayerRight(),0);
    }

    /**
     * Test of getInstance method, of class Board.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Board result = Board.getInstance();
        assertEquals(board, result);
    }

    /**
     * Test of setBoard method, of class Board.
     */
    @Test
    public void testSetBoard() {
        System.out.println("setBoard");
        Board.setBoard();
        Board instance = Board.getInstance();
        assertNotEquals(board,instance);
    }

    /**
     * Test of resetPoints method, of class Board.
     */
    @Test
    public void testResetPoints() {
        System.out.println("resetPoints");
        testSetPoints();
        board.resetPoints();
        int expResult = 0;
        int result = board.getPoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRightLives method, of class Board.
     */
    @Test
    public void testGetRightLives() {
        System.out.println("getRightLives");
        int expResult = 0;
        int result = board.getRightLives();
        assertEquals(expResult, result);
    }

    /**
     * Test of changeLives method, of class Board.
     */
    @Test
    public void testChangeLives() {
        System.out.println("changeLives");
        int lives = 1;
        board.changeLives(lives);
        assertEquals(4, board.getLives(), 0);
    }
    
}
