/*
 * ITS THE FRAME OF THE GAME
 */
package pyroduck.gui;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pyroduck.Game;

public class Frame extends JFrame {
    public GamePanel gamepane;
    private JPanel containerpane;
    private Game game;
    public static final String TITLE = "Pyroduck";

    public Frame() {
        containerpane = new JPanel(new BorderLayout());
        gamepane = new GamePanel(this);
        containerpane.add(gamepane, BorderLayout.PAGE_END);
        game = gamepane.getGame();
        setTitle(TITLE);
        add(containerpane);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        ImageIcon imgi = new ImageIcon("resources\\textures\\duck.png");
        Image img = imgi.getImage();
        setIconImage(img);
        setLocationRelativeTo(null);
        setVisible(true);	
        game.start();
    }

    /*
    |--------------------------------------------------------------------------
    | Game Related
    |--------------------------------------------------------------------------
     */
    
    public void newGame() {
        game.getBoard().newGame();
    }
    
}