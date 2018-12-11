package pyroduck.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.exceptions.PyroduckException;
import pyroduck.input.*;

public class GamePanel extends JPanel implements Observer {
    private Game game;
    private JLabel livesLabel = new JLabel();
    private JLabel pointsLabel = new JLabel();
    private JLabel messageLabel = new JLabel();
    private JLabel sound = new JLabel();
    private JButton musicLabel =new JButton();
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
            livesLabel.setText("Lives: " + Board.getInstance().getLives());
            livesLabel.setForeground(Color.WHITE);
            pointsLabel = new JLabel("Points: " + Board.getInstance().getPoints());
            pointsLabel.setForeground(Color.WHITE);
            sound= new JLabel("Sound = "+ Game.getInstance().getMusicOn());
            sound.setForeground(Color.WHITE);
            messageLabel = new JLabel("     Paused     ");
            Font font = new Font(Font.DIALOG, Font.BOLD, 24);
            messageLabel.setFont(font);
            messageLabel.setForeground(Color.black);
            musicLabel=new JButton(" ");
            musicLabel.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\SelectCharacter\\sound_32.png"));
            musicLabel.setForeground(Color.white);
            panel.setBackground(Color.black);
            panel.add(livesLabel, 0);
            panel.add(messageLabel, 1);
            panel.add(pointsLabel, 2);
            panel.add(sound, 3);
            panel.add(musicLabel,4);
            Board.getInstance().addObserver(this);
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
        livesLabel.setText("Lives: " + Board.getInstance().getLives());
        pointsLabel.setText("Points: " + Board.getInstance().getPoints());
        try {
            sound.setText("Sound = "+ Game.getInstance().getMusicOn());
        } catch (PyroduckException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(Board.getInstance().getLives() <= 0){
            if(endGame == null){
                endGame = new EndGame();
                endGame.setVisible(true);
                frame.setVisible(false);
                game.pause();
                Keyboard.getInstance().releaseAll();
                game.restartGame();
            }
        }
        else{
            endGame = null;
            frame.setVisible(true);
        }
        if(Board.getInstance().isPause() == true){
            messageLabel.setForeground(Color.white);
            livesLabel.setForeground(Color.GRAY);
            pointsLabel.setForeground(Color.GRAY);
        }
        if(Board.getInstance().isPause() == false){
            messageLabel.setForeground(Color.black);
            livesLabel.setForeground(Color.white);
            pointsLabel.setForeground(Color.white);
        }
    }
}
