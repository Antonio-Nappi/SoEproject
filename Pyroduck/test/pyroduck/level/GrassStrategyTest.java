package pyroduck.level;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.entities.Entity;
import pyroduck.exceptions.LoadLevelException;
import pyroduck.graphics.Screen;

/**
 *
 * @author 
 */
public class GrassStrategyTest {
    
    public GrassStrategyTest() {
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
        FileLevel instance = new GrassStrategy(path, new Board(new Screen()));
        instance.loadLevel(path);
    }
    
    /**
     * Test of createEntities method, of class GrassStrategy.
     */
    @Test
    public void testCreateEntities() throws LoadLevelException {
        System.out.println("createEntities");
        Board board = new Board(new Screen());
        FileLevel instance = new GrassStrategy("./resources/level/test.txt", board);
        FileLevel instance1 = new GrassStrategy("./resources/level/Level1.txt", board);
        Entity[] result = instance.createEntities(board);
        Entity [] expResult = instance1.createEntities(board);
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of getLevel method, of class FileLevel.
     */
    @Test
    public void testGetLevel() throws LoadLevelException {
        System.out.println("getLevel");
        FileLevel instance = new GrassStrategy("./resources/levels/Level1.txt", new Board(new Screen()));
        int expResult = 1;
        int result = instance.getLevel();
        assertEquals(expResult, result);
    } 
}