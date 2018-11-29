/*
 * THIS CLASS REPRESENT THE PANEL OF THE GAME
 */
package pyroduck.gui;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pyroduck.Game;
import pyroduck.entities.mob.Player;
import pyroduck.exceptions.PyroduckException;

public class GamePanel extends JPanel implements Observer {
    private Game game;
    private JLabel label = new JLabel();
    private JPanel panel = new JPanel();
    

    public GamePanel(Frame frame) throws IOException {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width-420, Toolkit.getDefaultToolkit().getScreenSize().height-100));
        try {
            game = Game.getInstance();
            add(game);
            game.setVisible(true);

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
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(true);
        setFocusable(true);
    }

    public Game getGame() {
        return game;
    }

    @Override
    public void update(Observable o, Object arg) {
        label.setText("Lives " + game.getBoard().getLives());
        JLabel label1 = new JLabel();
        label1.setText("Hai perso");
        Font myFont = new Font("Serif", Font.BOLD, 30);
        label1.setFont(myFont);
        
        if(game.getBoard().getLives() == 0){
            label.setText("Hai perso.");
            panel.setBackground(Color.RED);
            try {
                Game.getInstance().setVisible(false);
                this.setBackground(Color.WHITE);
                this.add(label1);
            } catch (PyroduckException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            //game.endGame();
        }
    }
}