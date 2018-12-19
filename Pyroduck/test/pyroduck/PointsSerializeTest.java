package pyroduck;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 
 */
public class PointsSerializeTest {
    
    PointsSerialize p;
    
    public PointsSerializeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p = new PointsSerialize("Umberto");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPoints method, of class PointsSerialize.
     */
    @Test
    public void testGetPoints() {
        System.out.println("getPoints");
        Board.getInstance().resetPoints();
        p.setPoints(100);
        assertEquals(100, p.getPoints(),0);
    }

    /**
     * Test of setPoints method, of class PointsSerialize.
     */
    @Test
    public void testSetPoints() {
        System.out.println("setPoints");
        Board.getInstance().resetPoints();
        p.setPoints(100);
        assertEquals(100, p.getPoints(),0);
    }

    /**
     * Test of getName method, of class PointsSerialize.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals("Umberto", p.getName());
    }

    /**
     * Test of setName method, of class PointsSerialize.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        p.setName("Giovanni");
        assertEquals("Giovanni", p.getName());
    }

    /**
     * Test of getLives method, of class PointsSerialize.
     */
    @Test
    public void testGetLives() {
        System.out.println("getLives");
        p.setLives(3);
        assertEquals(3, p.getLives());
    }

    /**
     * Test of setLives method, of class PointsSerialize.
     */
    @Test
    public void testSetLives() {
        System.out.println("setLives");
        p.setLives(3);
        assertEquals(3, p.getLives());
    }
}