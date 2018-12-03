package pyroduck.bomb;

import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.graphics.Screen;

/**
 *
 * @author Bini, Petruzzello
 */
public class DirectionalExplosionTest {
    
    public DirectionalExplosionTest() {
        
    }
    @Test
    public void testConstructor(){
        Board b = new Board(new Screen());
        Board b1 = b;
        DirectionalExplosion d = new DirectionalExplosion(2, 2, 1, 1, b);
        assertEquals(1, d.explosions.length, 0);
    }
}
