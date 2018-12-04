package pyroduck.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pyroduck.Game;
import pyroduck.exceptions.PyroduckException;

public class GamePanel extends JPanel implements Observer {
    private Game game;
    private JLabel livesLabel = new JLabel();
    private JLabel pointsLabel = new JLabel();
    private JPanel panel = new JPanel();
    

    public GamePanel(Frame frame) throws IOException {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width-420, Toolkit.getDefaultToolkit().getScreenSize().height-100));
        try {
            game = Game.getInstance();
            add(game);
            game.setVisible(true);

            livesLabel.setText("Lives: " + game.getBoard().getLives());
            livesLabel.setForeground(Color.WHITE);
            livesLabel.setHorizontalAlignment(JLabel.LEFT);
            
            pointsLabel = new JLabel("Points: " + game.getBoard().getPoints());
            pointsLabel.setForeground(Color.WHITE);
            pointsLabel.setHorizontalAlignment(JLabel.RIGHT);
            
            
            panel.setSize(Toolkit.getDefaultToolkit().getScreenSize().width-420, 60);
            panel.setBackground(Color.black);
            panel.add(livesLabel, 0);
            panel.add(pointsLabel, 1);
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
        livesLabel.setText("Lives: " + game.getBoard().getLives());
        pointsLabel.setText("Points: " + game.getBoard().getPoints());
        JLabel label1 = new JLabel();
        label1.setText("Hai perso");
        Font myFont = new Font("Serif", Font.BOLD, 30);
        label1.setFont(myFont);
        JLabel label2 = new JLabel();
        label2.setText("PAUSED");
        if(game.getBoard().getLives() == 0){
            livesLabel.setText("Hai perso.");
            panel.setBackground(Color.RED);
            try {
                Game.getInstance().setVisible(false);
                this.setBackground(Color.WHITE);
                this.add(label1);
            }catch (PyroduckException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(game.getBoard().isPause() == true){
            label2.setText("PAUSED");
            this.setBackground(Color.WHITE);
            this.add(label2);
        }
        if(game.getBoard().isPause() == false)
            this.remove(label2);
    }
}
