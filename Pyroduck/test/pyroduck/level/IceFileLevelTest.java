package pyroduck.level;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.entities.mob.enemy.graphic.Darkrai;
import pyroduck.entities.mob.enemy.graphic.Glalie;
import pyroduck.entities.mob.enemy.graphic.Snorunt;
import pyroduck.entities.tile.powerup.MalusSlow;
import pyroduck.entities.tile.powerup.Powerup;

/**
 *
 * @author 
 */
public class IceFileLevelTest {
    
    String path1 = "./resources/levels/nextlevel/Level3 1.txt";
    BufferedReader in1;
    FileLevel instance1;
    String path2 = "./resources/levels/nextlevel/Level4 1.txt";
    BufferedReader in2;
    FileLevel instance2;
    BufferedReader in3;
    FileLevel instance3;
    
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
        try {
            in1 = new BufferedReader(new FileReader(path1));
            in1.readLine();
            instance1 = new IceFileLevel(path1, in1, 1);
            in2 = new BufferedReader(new FileReader(path2));
            in2.readLine();
            instance2 = new IceFileLevel(path2, in2, 2);
            in3 = new BufferedReader(new FileReader(path2));
            in3.readLine();
            instance3 = new IceFileLevel(path2, in3, 2);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GrassFileLevelTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GrassFileLevelTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        assertTrue(instance1.createWall(64, 32).isTile());
    }

    /**
     * Test of createBrick method, of class IceFileLevel.
     */
    @Test
    public void testCreateBrick() {
        System.out.println("createBrick");
        assertTrue(instance1.createBrick(64, 32).isDestroyable());
    }

    /**
     * Test of createGrass method, of class IceFileLevel.
     */
    @Test
    public void testCreateGrass() {
        System.out.println("createGrass");
        assertTrue(instance1.createGrass(64, 32).isTile());
    }

    /**
     * Test of createFirstEnemy method, of class IceFileLevel.
     */
    @Test
    public void testCreateFirstEnemy() {
        System.out.println("createFirstEnemy");  
        Entity lowEnemy = instance1.createFirstEnemy(64, 32);
        assertTrue(lowEnemy instanceof Snorunt);
    }

    /**
     * Test of createSecondEnemy method, of class IceFileLevel.
     */
    @Test
    public void testCreateSecondEnemy() {
        System.out.println("createSecondEnemy");      
        Board.getInstance().addMob(new Player(32, 32 + Game.TILES_SIZE));;
        Entity mediumEnemy = instance1.createSecondEnemy(32, 64, 2);
        assertTrue(mediumEnemy instanceof Glalie);
        Entity mediumEnemy2 = instance1.createSecondEnemy(64, 32, 3);
        assertTrue(mediumEnemy2 instanceof Darkrai);
    }

    /**
     * Test of createPowerup method, of class IceFileLevel.
     */
    @Test
    public void testCreatePowerup() {
        System.out.println("createPowerup");  
        Powerup p = instance1.createPowerup(32, 64);
        assertTrue(p instanceof MalusSlow);
    }
    
    /**
     * Test of loadLevel method, of class FileLevel.
     * @throws java.io.FileNotFoundException
     */
    public void testLoadLevel() throws FileNotFoundException{
        System.out.println("loadLevel");
        instance1.loadLevel(path1, in1);
        instance2.loadLevel(path2, in2);
        instance3.loadLevel(path2, in3);
        assertArrayEquals(instance2.lineTiles, instance3.lineTiles);
    }
    
    /**
     * Test of createEntities method, of class FileLevel.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testCreateEntities() throws FileNotFoundException{
        System.out.println("createEntities");
        Entity[] result2 = instance2.createEntities();
        Entity [] result3 = instance3.createEntities();
        for(Entity e : result2)
            assertEquals(result2.getClass(), result3.getClass());
    }
    
    /**
     * Test of getLevel method, of class FileLevel.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetLevel() throws FileNotFoundException{
        System.out.println("getLevel");
        int result = instance1.getLevel();
        assertEquals(1, result);
        result = instance2.getLevel();
        assertEquals(2, result);
    }
}