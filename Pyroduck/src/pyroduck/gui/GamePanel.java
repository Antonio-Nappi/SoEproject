package pyroduck.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.exceptions.PyroduckException;
import pyroduck.input.*;

public class GamePanel extends JPanel implements Observer {
    private Game game;
    private JLabel livesLabel = new JLabel();
    private JLabel pointsLabel = new JLabel();
    private JLabel messageLabel = new JLabel();
    private JLabel spaceLabel = new JLabel();
    private JButton musicButton = new JButton();
    private JButton skipDemo = new JButton();
    private JPanel panel = new JPanel();
    private Frame frame;
    private JFrame endGame;


    public GamePanel(Frame frame) throws IOException {
        this.frame = frame;
        endGame = null;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width-420, Toolkit.getDefaultToolkit().getScreenSize().height-100));
        try {
            Font font = new Font(Font.DIALOG, Font.BOLD, 24);
            game = Game.getInstance();
            add(game);
            boolean music = game.getMusicOn();
            game.setVisible(true);
            messageLabel = new JLabel("     Paused     ");
            spaceLabel = new JLabel("                         ");
            musicButton=new JButton("");
            livesLabel.setText("Lives: " + Board.getInstance().getLives());
            pointsLabel = new JLabel("Points: " + Board.getInstance().getPoints());
            messageLabel.setFont(font);
            pointsLabel.setForeground(Color.WHITE);
            livesLabel.setForeground(Color.WHITE);
            messageLabel.setForeground(Color.black);
            if(music)
                musicButton.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\SelectCharacter\\sound_32.png"));
            else
                musicButton.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\SelectCharacter\\notsound_32.png"));
            
            musicButton.setForeground(Color.white);
            musicButton.addActionListener(new setMusic());            
            skipDemo=new JButton("  Skip Demo  ");
            skipDemo.setFont(font);
            skipDemo.setForeground(Color.BLACK);
            skipDemo.setVisible(false);
            if(Board.getInstance().getLevel()<=0)
                skipDemo.setVisible(true);
            skipDemo.addActionListener(new skip());
            panel.setBackground(Color.black);
            panel.add(livesLabel, 0);
            panel.add(messageLabel, 1);
            panel.add(pointsLabel, 2);
            panel.add(spaceLabel, 3);
            panel.add(musicButton,4);
            panel.add(skipDemo,5);
            Board.getInstance().addObserver(this);
            this.add(panel , BorderLayout.PAGE_START);
        } catch (PyroduckException e) {
            JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
        }
        setVisible(true);
        setFocusable(true);
    }
    
    private class setMusic implements ActionListener {
        boolean  music;
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //Estraiamo il pulsante che ha generato l'evento
                music = Game.getInstance().getMusicOn();
                try {
                    Game.getInstance().setMusicOn(!music);
                    game.requestFocus();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                JButton button = (JButton) e.getSource();
                if (!music) {
                    musicButton.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\SelectCharacter\\sound_32.png"));
                } else {
                    musicButton.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\SelectCharacter\\notsound_32.png"));
                }
            } catch (PyroduckException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private class skip implements ActionListener {
       
        @Override
        public void actionPerformed(ActionEvent e) {
            Board.getInstance().resetPoints();
            pointsLabel.setText("Points: 0");
            Board.getInstance().resetProperties();
            Board.getInstance().changeLevel(1);
            skipDemo.setVisible(false); 
            game.requestFocus();
        }
    }

    public Game getGame() {
        return game;
    }

    @Override
    public void update(Observable o, Object arg) {
        livesLabel.setText("Lives: " + Board.getInstance().getLives());
        pointsLabel.setText("Points: " + Board.getInstance().getPoints());
        if(!Board.getInstance().getDemo()) 
            skipDemo.setVisible(false);
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
