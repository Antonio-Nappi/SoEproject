/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.bomb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.entities.Entity;
import pyroduck.graphics.Screen;
import pyroduck.input.Keyboard;
import pyroduck.input.Keyboard;
/**
 *
 *  
 */
public class DirectionalExplosionTest {
    
    public DirectionalExplosionTest() {
        
    }
    @Test
    public void testConstructor(){
        Board b = new Board(new Keyboard(), new Screen(4, 4));
        Board b1 = b;
        DirectionalExplosion d = new DirectionalExplosion(2, 2, 1, 1, b);
        assertEquals(1, d.explosions.length, 0);
    }
}
