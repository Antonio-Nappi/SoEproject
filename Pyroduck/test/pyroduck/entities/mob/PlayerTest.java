package pyroduck.entities.mob;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.bomb.Bomb;
import pyroduck.entities.tile.powerup.Powerup;
import pyroduck.entities.tile.powerup.PowerupBombs;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.input.Keyboard;

/**
 *
 * @author Montefusco, Nappi
 */
public class PlayerTest {
    
    Player player;
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        player = new Player(1, 1);  
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Player.
     */
    @Test
    public void testUpdate() {
    int i = player.timeBetweenPutBombs;
        assertEquals(player.timeBetweenPutBombs,0);
        for (int j = 0; j<7500;j++){
            player.update();
        }
        assertNotNull(player.input);
        assertEquals(player.timeBetweenPutBombs, -7500);
    }


    /**
     * Test of calculateXOffset method, of class Player.
     */
    @Test
    public void testCalculateXOffset() {
        System.out.println("calculateXOffset");
        int test = Screen.calculateXOffset(player);
        assertEquals(test, Screen.xOffset);
    }

    /**
     * Test of calculateMove method, of class Player.
     */
    @Test
    public void testCalculateMove() {
        System.out.println("calculateMove");
        assertFalse(player.moving);
    }

    /**
     * Test of canMove method, of class Player.
     */
    @Test
    public void testCanMove() {
        System.out.println("canMove");
        double x = 0.0;
        double y = 0.0;
        assertFalse(player.canMove(x, y));
//        
//        x = 1.0;
//        y = 0.0;
//        assertTrue(player.canMove(x, y));
//        
//        x = 1.0;
//        y = 1.0;
//        assertTrue(player.canMove(x, y));
//        x = 1.0;
//        y = 0.0;
//        assertTrue(player.canMove(x, y));
//                x = 1.0;
//        y = 0.0;
//        assertTrue(player.canMove(x, y));
        
    }

    /**
     * Test of move method, of class Player.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        double xa = 0.0;
        double ya = 0.0;
        player.canMove(xa, ya);
        assertEquals(player.direction, -1);
        assertEquals(player.getX(), 1.0,0);
        assertEquals(player.getY(), 1.0,0);
//        
//        xa = 1.0;
//        ya = 0.0;
//        player.move(xa, ya);
//        assertEquals(player.direction, 1);
//        System.out.println("player.getX() " + player.getX());
//        assertEquals(player.getX(), 2.0,0);
//        assertEquals(player.getY(), 1.0,0);
//        
//        xa = 0.0;
//        ya = 1.0;
//        player.move(xa, ya);
//        assertEquals(player.direction, 2);
//        assertEquals(player.getX(), 2.0,0);
//        assertEquals(player.getY(), 2.0,0);
//        
//        xa = -1.0;
//        ya = 0.0;
//        player.move(xa, ya);
//        assertEquals(player.direction, 3);
//        assertEquals(player.getX(), 1.0,0);
//        assertEquals(player.getY(), 2.0,0);
//        
//        xa = 0.0;
//        ya = -1.0;
//        player.move(xa, ya);
//        assertEquals(player.direction, 0);
//        assertEquals(player.getX(), 1.0,0);
//        assertEquals(player.getY(), 1.0,0);
    }


    /**
     * Test of placeBomb method, of class Player.
     */
    @Test
    public void testPlaceBomb() {
        System.out.println("placeBomb");
        int x = 2;
        int y = 1;
        Bomb b = new Bomb(x, y);
        player.placeBomb(x, y);
        assertFalse(b==player.bombs.get(0)); 
    }

    /**
     * Test of addPowerup method, of class Player.
     */
    @Test
    public void testAddPowerup() {
        System.out.println("addPowerup");
        Powerup p = new PowerupBombs(1, 1, Sprite.powerup_bombs);
        player.addPowerup(p);
        assertEquals(Game.getInstance().getBombRate(), 2);
    }   
    
    /**
     * Test of correctKeyboard method, of class Player.
     */
    @Test
    public void testCorrectKeyboard(){        
        System.out.println("correctKeyboard");
        Board.getInstance().setPlayer(1);
        player.correctKeyboard();
        assertEquals(player.input, Keyboard.getInstance());   
    }
        
    /**
     * Test of kill method, of class Player.
     */
    @Test
    public void testKill() {
        player.alive = true;
        assertEquals(3.0, Board.getInstance().getLives(),0);
        player.kill();
        assertFalse(player.alive);
        assertEquals(2.0, Board.getInstance().getLives(),0);
    }
            
    /**
     * Test of afterKill method, of class Player.
     */
    @Test
    public void testAfterKill() {
        assertEquals(80, player.timeAfterDeath, 0);
        player.afterKill();
         assertEquals(79, player.timeAfterDeath, 0);
    }
}