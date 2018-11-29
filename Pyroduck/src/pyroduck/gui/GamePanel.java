/*
 * THIS CLASS REPRESENT THE PANEL OF THE GAME
 */
package pyroduck.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pyroduck.Game;
import pyroduck.exceptions.PyroduckException;

public class GamePanel extends JPanel implements Observer {
    private Game game;
    private JLabel label = new JLabel();
    private int remain = 3;

    public GamePanel(Frame frame) throws IOException {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width-420, Toolkit.getDefaultToolkit().getScreenSize().height-100));
        try {
            game = Game.getInstance();
            add(game);
            game.setVisible(true);

            JPanel panel = new JPanel();
            label.setText("Lives " + game.getBoard().getLives());
            panel.setBackground(Color.BLACK);
            panel.setSize(Toolkit.getDefaultToolkit().getScreenSize().width-420, 60);
            label.setForeground(Color.WHITE);
            label.setHorizontalTextPosition((int)LEFT_ALIGNMENT);
            panel.add(label);
                        game.getBoard().addObserver(this);
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

    @Override
    public void update(Observable o, Object arg) {
        remain--;
        label.setText("Lives " + remain);
        System.out.println("GamePanel " + game.getBoard().getLives());
        if(remain == 0){
        JOptionPane.showMessageDialog(game,"Hai perso");
        }
    }
}