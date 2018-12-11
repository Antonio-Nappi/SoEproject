package pyroduck.bomb;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bini, Petruzzello
 */
public class DirectionalExplosionTest {
    
    public DirectionalExplosionTest() {
        
    }
    @Test
    public void testConstructor(){
        DirectionalExplosion d = new DirectionalExplosion(2, 2, 1, 1);
        assertEquals(1, d.explosions.length, 0);
    }
}