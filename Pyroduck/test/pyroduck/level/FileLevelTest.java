package pyroduck.level;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.entities.Entity;
import pyroduck.entities.tile.WallTile;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.exceptions.LoadLevelException;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.input.Keyboard;

/**
 *
 * @author Corbisiero, Ferrara, La Femina
 */
public class FileLevelTest {
    
    public FileLevelTest() {
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
     * Test of loadLevel method, of class FileLevel.
     */
    @Test(expected = LoadLevelException.class)
    public void testLoadLevel() throws LoadLevelException{
        System.out.println("loadLevel");
        String path = "./resoucers/levels/Level1.txt";
        FileLevel instance = new FileLevel(path);
        instance.loadLevel(path);
    }

    /**
     * Test of createEntities method, of class FileLevel.
     */
    @Test(expected = LoadLevelException.class)
    public void testCreateEntities() throws LoadLevelException{
        System.out.println("createEntities");
        Board board = new Board(new Keyboard(), new Screen());
        FileLevel instance = new FileLevel("./resources/level/test.txt");
        Entity[] expResult = {new WallTile(0, 1, Sprite.wall),
                              new BrickTile(1, 1, Sprite.brick),
                              new WallTile(2, 1, Sprite.wall)};
        Entity[] result = instance.createEntities(board);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getLevel method, of class FileLevel.
     */
    @Test
    public void testGetLevel() throws LoadLevelException {
        System.out.println("getLevel");
        FileLevel instance = new FileLevel("./resources/levels/Level1.txt");
        int expResult = 1;
        int result = instance.getLevel();
        assertEquals(expResult, result);
    }  
}
