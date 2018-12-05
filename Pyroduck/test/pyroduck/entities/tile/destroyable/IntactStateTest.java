package pyroduck.entities.tile.destroyable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Montefusco
 */
public class IntactStateTest {
    
    private int x, y;
    private Sprite sprite;
    private IntactState intact;
    
    public IntactStateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        x = 0;
        y = 0;
        sprite = Sprite.ice;
        intact = new IntactState(x, y, sprite);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of nextState method, of class IntactState.
     */
    @Test
    public void testNextState() {
        ContextDestroyable context = new ContextDestroyable();
        DestroyableIceTile result = intact.nextState(context);
        assertTrue(result instanceof BreakingState);
    }
    
}
