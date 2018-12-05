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
public class ContextDestroyableTest {
    
    private ContextDestroyable cont;
    
    public ContextDestroyableTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cont = new ContextDestroyable();
        cont.setState(new IntactState(1, 1, Sprite.ice));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getState method, of class ContextDestroyable.
     */
    @Test
    public void testGetState() {
        DestroyableIceTile result = cont.getState();
        assertTrue(result instanceof IntactState);
    }

    /**
     * Test of setState method, of class ContextDestroyable.
     */
    @Test
    public void testSetState() {
        cont.setState(new DestroyedState(1, 1, Sprite.icebroken_3));
        DestroyableIceTile result = cont.getState();
        assertTrue(result instanceof DestroyedState);
    }

    /**
     * Test of nextState method, of class ContextDestroyable.
     */
    @Test
    public void testNextState() {
        cont.nextState();
        DestroyableIceTile result = cont.getState();
        assertTrue(result instanceof BreakingState);
    }
    
}
