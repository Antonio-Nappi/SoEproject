package pyroduck.entities.mob.enemy;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pyroduck.Board;
import pyroduck.entities.mob.Player;
import pyroduck.entities.mob.enemy.graphic.Arbok;

/**
 *
 * @author Bini, Petruzzello
 */
public class MediumPowerTest {
    
    private Player player;
    private Arbok e;
    private MediumPower enemy;
        
    public MediumPowerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        player = new Player(0, 0);      
        Board.getInstance().addMob(player);
        e = new Arbok(64, 64);
        Board.getInstance().addMob(e);
        enemy = new MediumPower(player, e);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateDirection method, of class MediumPower.
     */
    @Test
    public void testCalculateDirection() {
        assertEquals(0, enemy.calculateDirection(), 4);
    }

    /**
     * Test of calculateColDirection method, of class MediumPower.
     */
    @Test
    public void testCalculateColDirection() {
        assertEquals(enemy.calculateColDirection(), 3, 0);
    }

    /**
     * Test of calculateRowDirection method, of class MediumPower.
     */
    @Test
    public void testCalculateRowDirection() {
        assertEquals(enemy.calculateRowDirection(), 0, 0);
    }
}