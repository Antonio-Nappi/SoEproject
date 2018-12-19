package pyroduck;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pyroduck.bomb.Bomb;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.Player;
import pyroduck.entities.mob.enemy.graphic.Arbok;
import pyroduck.entities.tile.WallTile;
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
        board = Board.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Board.
     */
    @Test
    public void testUpdate() {
        board.addMob(new Player(0, 0));
        assertTrue(board.getMobs().get(0) instanceof Player);
        board.getMobs().get(0).remove();
        board.update();
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
     * Test of restartLevel method, of class Board.
     */
    public void testRestartLevel(){
        board.changeLevel(1);
        assertEquals(1, board.getLevel(), 0);
        board.changeLevel(2);
        board.restartLevel();
        assertEquals(2, board.getLevel(), 0);
    }
    
//    @Test
//    /**
//     * Test of nextLevel method, of class Board.
//     */
//    public void testNextLevel() throws IOException, LoadLevelException{
//        int aspected = board.clevel.getFilelevel().getLevel() + 1;
//        String path = "./resources/levels/Level" + 1 + " " + new Random(System.currentTimeMillis()).nextInt(3)+1 + ".txt";
//        board.clevel = new ContextLevel(new GrassStrategy(path, board));
//        board.nextLevel();
//        int real = board.clevel.getFilelevel().getLevel();
//        assertEquals(aspected, real);
//    }
    
    /**
     * Test of detectNoEnemies method, of class Board.
     */
    public void testDetectNoEnemies(){
        Player player = new Player(32, 32);
        Arbok enemy = new Arbok(32, 64);
        board.addMob(player);
        board.addMob(enemy);
        assertFalse(board.detectNoEnemies());
        for(int i=0; i<board.getMobs().size(); i++)
            board.getMobs().remove(i);
        assertTrue(board.detectNoEnemies());
    }

    /**
     * Test of getEntity method, of class Board.
     */
    @Test
    public void testGetEntity() {
        Bomb bomb = new Bomb(1, 1);
        board.addBomb(bomb);
        assertTrue(board.getEntity(1, 1, null) instanceof Bomb);
        Player p = new Player(32, 32);
        board.addMob(p);
        assertTrue(board.getMobAt(1, 1) instanceof Player);
        Arbok enemy = new Arbok(32, 97);
        board.addMob(enemy);
        assertTrue(board.getMobAt(1, 2) instanceof Mob);
        assertFalse(board.getEntities()[0] instanceof Mob);
        assertFalse(board.getEntities()[0] instanceof Bomb);
        assertTrue(board.getEntities()[0] instanceof Entity);
    }

    /**
     * Test of getBombAt method, of class Board.
     */
    @Test
    public void testGetBombAt() {
        Bomb bomb = new Bomb(0, 0);
        board.addBomb(bomb);
        assertTrue(board.getBombAt(0, 0) instanceof Bomb);
    }

    /**
     * Test of getPlayer method, of class Board.
     */
    @Test
    public void testGetPlayer() {
        Player player = new Player(1, 1);
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