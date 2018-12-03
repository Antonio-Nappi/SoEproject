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
import pyroduck.graphics.*;

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
        Board board = new Board(new Screen());
        FileLevel instance = new FileLevel("./resources/level/test.txt");
        FileLevel instance1 = new FileLevel("./resources/level/Level1.txt");
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
        FileLevel instance = new FileLevel("./resources/levels/Level1.txt");
        int expResult = 1;
        int result = instance.getLevel();
        assertEquals(expResult, result);
    }  
}
