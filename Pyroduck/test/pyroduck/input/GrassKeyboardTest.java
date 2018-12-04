/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.input;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio
 */
public class GrassKeyboardTest {
    Keyboard grass = null;
    
    public GrassKeyboardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        grass = GrassKeyboard.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of keyPressed method, of class GrassKeyboard.
     */
    @Test
    public void testKeyPressed() throws AWTException {
    }

    /**
     * Test of keyReleased method, of class GrassKeyboard.
     */
    @Test
    public void testKeyReleased() {
    }

    /**
     * Test of getInstance method, of class GrassKeyboard.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        assertSame(grass, GrassKeyboard.getInstance());
    }
    
}
