/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Alex
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
        String path = "";
        FileLevel instance = null;
        instance.loadLevel(path);
 
    }

    /**
     * Test of createEntities method, of class FileLevel.
     */
    @Test
    public void testCreateEntities() {
        System.out.println("createEntities");
        Board board = null;
        FileLevel instance = null;
        Entity[] expResult = null;
        Entity[] result = instance.createEntities(board);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLevel method, of class FileLevel.
     */
    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        FileLevel instance = null;
        int expResult = 0;
        int result = instance.getLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
