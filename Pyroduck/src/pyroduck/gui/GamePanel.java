/*
 * THIS CLASS REPRESENT THE PANEL OF THE GAME
 */
package pyroduck.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pyroduck.Game;
import pyroduck.exceptions.PyroduckException;

public class GamePanel extends JPanel {
    private Game game;

    public GamePanel(Frame frame) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width-420, Toolkit.getDefaultToolkit().getScreenSize().height-100));
        try {
            game = Game.getInstance();
            add(game);
            game.setVisible(true);
            JLabel label = new JLabel("Lives " + game.getLives());
           
            label.setForeground(Color.WHITE);
            setBackground(Color.BLACK);
            label.setHorizontalAlignment((int) CENTER_ALIGNMENT);
            
            
            this.add(label , BorderLayout.PAGE_START);
        } catch (PyroduckException e) {
            JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
        }
        setVisible(true);
        setFocusable(true);
    }

    public Game getGame() {
        return game;
    }
}