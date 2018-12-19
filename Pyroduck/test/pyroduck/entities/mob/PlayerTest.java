package pyroduck.entities.mob;

import java.awt.Button;
import java.awt.event.KeyEvent;
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
    double x;
    double y;
    
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
        Game.getInstance();
        Board.getInstance().setLives(2);
        player = Board.getInstance().getPlayer();
        x = player.getX();
        y = player.getY();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Player.
     */
    @Test
    public void testUpdate() {
        player.alive = true;
        assertEquals(player.timeBetweenPutBombs, 0);
        for (int j = 0; j<7500; j++)
            player.update();
        assertEquals(-7500, player.timeBetweenPutBombs);
        player.update();
        player.update();
        assertEquals(player.timeBetweenPutBombs, 0);
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
        player.alive = true;
        player.calculateMove();
        assertFalse(player.moving);
        Button a = new Button("click");
        KeyEvent e = new KeyEvent(a, 1, 20, 1, 10, 'a');
        Keyboard.getInstance().keyPressed(e);
        player.calculateMove();
        assertTrue(!player.moving);
    }

    /**
     * Test of canMove method, of class Player.
     */
    @Test
    public void testCanMove() {
        System.out.println("canMove");
        assertTrue(player.canMove(x+32, y));
        assertFalse(player.canMove(x-64, y));        
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
        assertEquals(player.getX(), 32, 0);
        assertEquals(player.getY(), 64, 0);
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
        Game.getInstance().resetProperties();
        Powerup p = new PowerupBombs(1, 1, Sprite.powerup_bombs);
        player.addPowerup(p);
        assertEquals(2, Game.getInstance().getBombRate());
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
        assertEquals(2.0, Board.getInstance().getLives(),0);
        player.kill();
        assertFalse(player.alive);
        assertEquals(1.0, Board.getInstance().getLives(),0);
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