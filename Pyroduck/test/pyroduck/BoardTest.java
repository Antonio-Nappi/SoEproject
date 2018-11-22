package pyroduck;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pyroduck.bomb.Bomb;
import pyroduck.bomb.Explosion;
import pyroduck.entities.mob.Player;
import pyroduck.entities.tile.WallTile;
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
        board = new Board(new Keyboard(), new Screen());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Board.
     */
    @Test
    public void testUpdate() {
        board.addMob(new Player(0, 0, board));
        assertTrue(board.mobs.get(0) instanceof Player);
        board.mobs.get(0).remove();
        board.update();
        assertTrue(board.bombs.isEmpty());
    }

    /**
     * Test of newGame method, of class Board.
     */
    @Test
    public void testNewGame() {
        Game.addBombRadius(1);
        Game.addBombRate(1);
        Game.addPlayerSpeed(1);
        board.addMob(new Player(0, 0, board));
        assertTrue(board.mobs.get(0) instanceof Player);
        board.addBomb(new Bomb(0, 0, board));
        board.addBomb(new Bomb(0, 0, board));
        board.addBomb(new Bomb(0, 0, board));
        assertEquals(board.bombs.size(), 3);
        board.newGame();
        assertEquals(1, Game.bombRadius);
        assertEquals(1, Game.bombRate);
        assertEquals(1.3, Game.playerSpeed, 0);
        assertTrue(board.mobs.isEmpty());
        assertTrue(board.bombs.isEmpty());
    }

    /**
     * Test of getEntity method, of class Board.
     */
    @Test
    public void testGetEntity() {
        Bomb bomb = new Bomb(0, 0, board);
        Explosion explosion = new Explosion(1, 1, 2, false, board);
        Player player = new Player(1, 2, board);
        assertTrue(board.getEntity(0, 0)instanceof Bomb);
        assertTrue(board.getEntity(1, 1)instanceof Explosion);
        assertTrue(board.getEntity(1, 2)instanceof Player);
    }

    /**
     * Test of getBombAt method, of class Board.
     */
    @Test
    public void testGetBombAt() {
        Bomb bomb = new Bomb(0, 0, board);
        assertEquals(board.getBombAt(0, 0), bomb);
    }

    /**
     * Test of getPlayer method, of class Board.
     */
    @Test
    public void testGetPlayer() {
        Player player = new Player(1, 2, board);
        assertEquals(board.getPlayer(), player);
    }

    /**
     * Test of getExplosionAt method, of class Board.
     */
    @Test
    public void testGetExplosionAt() {
        Explosion explosion = new Explosion(1, 1, 2, false, board);
        assertTrue(board.getEntity(1, 1)instanceof Explosion);
    }

    /**
     * Test of getEntityAt method, of class Board.
     */
    @Test
    public void testGetEntityAt() {
        WallTile wall = new WallTile(0, 0, Sprite.wall);
        assertEquals(wall, board.getEntityAt(0, 0));
    }
}
