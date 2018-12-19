package pyroduck;

import java.util.List;
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
public class ListPointsSerializeTest {
    
    ListPointsSerialize l;
    PointsSerialize p1,p2;
    
    public ListPointsSerializeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        l = new ListPointsSerialize();
        p1 = new PointsSerialize("Umberto");
        p2 = new PointsSerialize("Stefano");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addScore method, of class ListPointsSerialize.
     */
    @Test
    public void testAddScore() {
        System.out.println("addScore");
        l.addScore(p1);
        assertEquals(1, l.size(), 0);
        l.addScore(p2);
        assertEquals(2, l.size(), 0);
    }

    /**
     * Test of size method, of class ListPointsSerialize.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        l.addScore(p1);
        assertEquals(1, l.size(), 0);
        l.addScore(p2);
        assertEquals(2, l.size(), 0);
    }   
}