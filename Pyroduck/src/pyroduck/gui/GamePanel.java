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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pyroduck.Game;
import pyroduck.exceptions.PyroduckException;

public class GamePanel extends JPanel implements Observer {
    private Game game;
    private JLabel label = new JLabel();
    private JPanel panel = new JPanel();
    private Frame frame;


    public GamePanel(Frame frame) throws IOException {
        this.frame = frame;
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
        JLabel label2 = new JLabel();
        label2.setText("PAUSED");
        
        if(game.getBoard().getLives() == 0){
            JFrame endGame = new EndGame();
            endGame.setVisible(true);
            frame.setVisible(false);
            try {
                Game.getInstance().setVisible(false);
                
            } catch (PyroduckException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(game.getBoard().isPause() == true){
            label.setText("PAUSED");
                this.setBackground(Color.WHITE);
                this.add(label2);
        }
        
        if(game.getBoard().isPause() == false){
            
                this.remove(label2);
        }
    }
    
}
