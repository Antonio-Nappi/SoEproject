package pyroduck;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pyroduck.bomb.Bomb;
import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.Player;
import pyroduck.entities.mob.enemy.graphic.Arbok;
import pyroduck.entities.tile.WallTile;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;

/**
 *
 * @author all
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
        board = new Board(new Screen());
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
        board.addMob(new Player(32, 32, board));
        assertTrue(board.mobs.get(0) instanceof Player);
        board.addBomb(new Bomb(32, 32, board));
        board.addBomb(new Bomb(64, 32, board));
        board.addBomb(new Bomb(32, 64, board));
        assertEquals(board.bombs.size(), 3);
        try {
            board.newGame();
        } catch (IOException ex) {
            Logger.getLogger(BoardTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(1, Game.bombRadius);
        assertEquals(1, Game.bombRate);
        assertEquals(1.3, Game.playerSpeed, 0);
        assertTrue(board.mobs.size() == 1);
        assertTrue(board.bombs.isEmpty());
    }
    
    @Test
    /**
     * Test of setLives method, of class Board.
     */
    public void testSetLives(){
        board.setLives(3);
        assertEquals(3, board.lives);
    }
    
    @Test
    /**
     * Test of nextLevel method, of class Board.
     */
    public void testNextLevel() throws IOException{
        int aspected = board.clevel.getFilelevel().getLevel() + 1;
        board.nextLevel();
        int real = board.clevel.getFilelevel().getLevel();
        assertEquals(aspected, real);
    }
    
    /**
     * Test of detectNoEnemies method, of class Board.
     */
    public void testDetectNoEnemies(){
        Player player = new Player(32, 32, board);
        Arbok enemy = new Arbok(32, 64, board);
        board.addMob(player);
        board.addMob(enemy);
        assertFalse(board.detectNoEnemies());
        for(int i=0; i<board.mobs.size(); i++)
            board.mobs.remove(i);
        assertTrue(board.detectNoEnemies());
    }

    /**
     * Test of getEntity method, of class Board.
     */
    @Test
    public void testGetEntity() {
        Bomb bomb = new Bomb(32, 32, board);
        board.addBomb(bomb);
        assertTrue(board.getEntity(32, 32, null) instanceof Bomb);
        Player p = new Player(64, 64, board);
        board.addMob(p);
        assertTrue(board.getEntity(0, 0, null) instanceof Mob);
        Arbok enemy = new Arbok(32, 64, board);
        board.addMob(enemy);
        assertTrue(board.getEntity(32, 64, null) instanceof Mob);
        WallTile wt = new WallTile(0, 0, Sprite.brick);
        board.addEntitie(0, wt);
        assertFalse(board.getEntity(0, 0, null) instanceof Mob);
        assertFalse(board.getEntity(0, 0, null) instanceof Bomb);
        assertTrue(board.getEntity(0, 0, null) instanceof Entity);
    }

    /**
     * Test of getBombAt method, of class Board.
     */
    @Test
    public void testGetBombAt() {
        Bomb bomb = new Bomb(32, 32, board);
        board.addBomb(bomb);
        assertTrue(board.getBombAt(32, 32) instanceof Bomb);
    }

    /**
     * Test of getPlayer method, of class Board.
     */
    @Test
    public void testGetPlayer() {
        Player player = new Player(32, 32, board);
        board.addMob(player);
        assertTrue(board.getPlayer() instanceof Player);
    }

    /**
     * Test of getEntityAt method, of class Board.
     */
    @Test
    public void testGetEntityAt() {
        WallTile wall = new WallTile(0, 0, Sprite.wall);
        assertTrue(board.getEntityAt(0, 0) instanceof WallTile);
    }
}
