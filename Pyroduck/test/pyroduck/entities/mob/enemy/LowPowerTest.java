/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.mob.enemy;

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
public class LowPowerTest {
    LowPower low = null;
    
    public LowPowerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        low = new LowPower();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateDirection method, of class LowPower.
     */
    @Test
    public void testCalculateDirection() {
        System.out.println("calculateDirection");
        assertEquals(low.calculateDirection(), 0, 3);
    }
    
}
