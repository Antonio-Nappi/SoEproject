package pyroduck.level;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.tile.GrassTile;
import pyroduck.entities.tile.WallTile;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.entities.tile.powerup.Powerup;

/**
 *
 * @author 
 */
public class IceFileLevelTest {
    
    public IceFileLevelTest() {
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
     * Test of createWall method, of class IceFileLevel.
     */
    @Test
    public void testCreateWall() {
        System.out.println("createWall");
        int x = 0;
        int y = 0;
        IceFileLevel instance = null;
        WallTile expResult = null;
        WallTile result = instance.createWall(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBrick method, of class IceFileLevel.
     */
    @Test
    public void testCreateBrick() {
        System.out.println("createBrick");
        int x = 0;
        int y = 0;
        IceFileLevel instance = null;
        BrickTile expResult = null;
        BrickTile result = instance.createBrick(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createGrass method, of class IceFileLevel.
     */
    @Test
    public void testCreateGrass() {
        System.out.println("createGrass");
        int x = 0;
        int y = 0;
        IceFileLevel instance = null;
        GrassTile expResult = null;
        GrassTile result = instance.createGrass(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createFirstEnemy method, of class IceFileLevel.
     */
    @Test
    public void testCreateFirstEnemy() {
        System.out.println("createFirstEnemy");
        int x = 0;
        int y = 0;
        IceFileLevel instance = null;
        Mob expResult = null;
        Mob result = instance.createFirstEnemy(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSecondEnemy method, of class IceFileLevel.
     */
    @Test
    public void testCreateSecondEnemy() {
        System.out.println("createSecondEnemy");
        int x = 0;
        int y = 0;
        int choose = 0;
        IceFileLevel instance = null;
        Mob expResult = null;
        Mob result = instance.createSecondEnemy(x, y, choose);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPowerup method, of class IceFileLevel.
     */
    @Test
    public void testCreatePowerup() {
        System.out.println("createPowerup");
        int x = 0;
        int y = 0;
        IceFileLevel instance = null;
        Powerup expResult = null;
        Powerup result = instance.createPowerup(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of loadLevel method, of class FileLevel.
     * @throws java.io.FileNotFoundException
     */
    public void testLoadLevel() throws FileNotFoundException{
        System.out.println("loadLevel");
        String path = "./resoucers/levels/Level1.txt";
        BufferedReader in = new BufferedReader(new FileReader(path));
        FileLevel instance = new GrassFileLevel(path, in, 1);
        instance.loadLevel(path, in);
    }
    
    /**
     * Test of createEntities method, of class FileLevel.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testCreateEntities() throws FileNotFoundException{
        System.out.println("createEntities");
        BufferedReader in = new BufferedReader(new FileReader("./resources/level/test.txt"));
        BufferedReader in1 = new BufferedReader(new FileReader("./resources/level/Level1.txt"));
        FileLevel instance = new GrassFileLevel("./resources/level/test.txt", in, 1);
        FileLevel instance1 = new GrassFileLevel("./resources/level/Level1.txt", in1, 1);
        Entity[] result = instance.createEntities();
        Entity [] expResult = instance1.createEntities();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of getLevel method, of class FileLevel.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetLevel() throws FileNotFoundException{
        System.out.println("getLevel");
        BufferedReader in = new BufferedReader(new FileReader("./resources/level/Level1.txt"));
        FileLevel instance = new GrassFileLevel("./resources/levels/Level1.txt", in, 1);
        int expResult = 1;
        int result = instance.getLevel();
        assertEquals(expResult, result);
    }
}