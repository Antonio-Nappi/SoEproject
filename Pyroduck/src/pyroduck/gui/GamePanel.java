/*
 * THIS CLASS REPRESENT THE PANEL OF THE GAME
 */
package pyroduck.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
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
            
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Lives " + game.getLives());
            panel.setBackground(Color.BLACK);
            panel.setSize(Toolkit.getDefaultToolkit().getScreenSize().width-420, 60);
            label.setForeground(Color.WHITE);
            label.setHorizontalTextPosition((int)LEFT_ALIGNMENT);
            panel.add(label);
            this.add(panel , BorderLayout.PAGE_START);
            
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