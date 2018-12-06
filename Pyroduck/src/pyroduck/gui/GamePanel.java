package pyroduck.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pyroduck.Game;
import pyroduck.exceptions.PyroduckException;
import pyroduck.input.*;

public class GamePanel extends JPanel implements Observer {
    private Game game;
    private JLabel livesLabel = new JLabel();
    private JLabel pointsLabel = new JLabel();
    private JLabel messageLabel = new JLabel();
    private JPanel panel = new JPanel();
    private Frame frame;
    private JFrame endGame;


    public GamePanel(Frame frame) throws IOException {
        this.frame = frame;
        endGame = null;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width-420, Toolkit.getDefaultToolkit().getScreenSize().height-100));
        try {
            game = Game.getInstance();
            add(game);
            game.setVisible(true);
            
            livesLabel.setText("Lives: " + game.getBoard().getLives());
            livesLabel.setForeground(Color.WHITE);
            
            pointsLabel = new JLabel("Points: " + game.getBoard().getPoints());
            pointsLabel.setForeground(Color.WHITE);
            
            messageLabel = new JLabel("     Paused     ");
            Font font = new Font(Font.DIALOG, Font.BOLD, 24);
            messageLabel.setFont(font);
            messageLabel.setForeground(Color.black);
            
            panel.setBackground(Color.black);
            panel.add(livesLabel, 0);
            panel.add(messageLabel, 1);
            panel.add(pointsLabel, 2);
            
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

        if(game.getBoard().getLives() <= 0){
            if(endGame == null){
                endGame = new EndGame();
                endGame.setVisible(true);
                frame.setVisible(false);
                game.pause();
                if(Keyboard.getInstance().getLast() != null)
                    Keyboard.getInstance().keyReleased(Keyboard.getInstance().getLast());
                game.restartGame();
            }
        }
        else{
            endGame = null;
            frame.setVisible(true);
        }
        if(game.getBoard().isPause() == true){
            messageLabel.setForeground(Color.white);
            livesLabel.setForeground(Color.GRAY);
            pointsLabel.setForeground(Color.GRAY);
        }
        if(game.getBoard().isPause() == false){
            messageLabel.setForeground(Color.black);
            livesLabel.setForeground(Color.white);
            pointsLabel.setForeground(Color.white);
        }
    }
}
