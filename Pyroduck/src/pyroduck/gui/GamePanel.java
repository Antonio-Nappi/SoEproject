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
import javax.swing.JPanel;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.Message;
import pyroduck.input.*;

public class GamePanel extends JPanel implements Observer {

    private final Game game;
    private final JLabel livesLabel = new JLabel();
    private JLabel pointsLabel = new JLabel();
    private JLabel messageLabel = new JLabel();
    private JLabel spaceLabel = new JLabel();
    private JButton musicButton = new JButton();
    private JButton skipDemo = new JButton();
    private final JPanel panel = new JPanel();
    private final JPanel tutorialpanel = new JPanel();
    private final Frame frame;
    private final Message message;
    private JFrame endGame;
    private final JLabel tutorial = new JLabel();

    public GamePanel(Frame frame) throws IOException {
        this.frame = frame;
        endGame = null;
        message = new Message(this);
        game = Game.getInstance();
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 420, Toolkit.getDefaultToolkit().getScreenSize().height - 100));
        add(game);
        
        setPanel();
        setTutorialPanel();
        game.setVisible(true);
        
        if (Board.getInstance().getLevel() <= 0) {
            skipDemo.setVisible(true);
        }
        skipDemo.addActionListener(new skip());
        panel.setBackground(Color.black);
        panel.add(livesLabel, 0);
        panel.add(messageLabel, 1);
        panel.add(pointsLabel, 2);
        panel.add(spaceLabel, 3);
        panel.add(musicButton, 4);
        panel.add(skipDemo, 5);
        Board.getInstance().addObserver(this);
        this.add(panel, BorderLayout.PAGE_START);
        if(Game.getInstance().getDemo())
            this.add(tutorialpanel, BorderLayout.PAGE_END);
        setVisible(true);
        setFocusable(true);
    }

    private class setMusic implements ActionListener {

        boolean music;

        @Override
        public void actionPerformed(ActionEvent e) {
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
        }
    }

    private class skip implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Board.getInstance().resetPoints();
            Game.getInstance().setDemo(false);
            pointsLabel.setText("Points: 0");
            Game.getInstance().resetProperties();
            Board.getInstance().changeLevel(1);
            tutorialpanel.setVisible(false);
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
        if (!Game.getInstance().getDemo()) {
            skipDemo.setVisible(false);
            tutorialpanel.setVisible(false);        
        }
        if (Board.getInstance().getLives() <= 0) {
            if (endGame == null) {
                endGame = new EndGame();
                endGame.setVisible(true);
                frame.setVisible(false);
                game.pause();
                Keyboard.getInstance().releaseAll();
                game.restartGame();
            }
        } else {
            endGame = null;
            frame.setVisible(true);
        }
        if (Board.getInstance().isPause() == true) {
            messageLabel.setForeground(Color.white);
            livesLabel.setForeground(Color.GRAY);
            pointsLabel.setForeground(Color.GRAY);
        }
        if (Board.getInstance().isPause() == false) {
            messageLabel.setForeground(Color.black);
            livesLabel.setForeground(Color.white);
            pointsLabel.setForeground(Color.white);
        }
    }
    
    private void setTutorialPanel(){
        tutorialpanel.setBackground(Color.black);
        tutorial.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        tutorial.setText("Press UP, DOWN, RIGHT, LEFT or W, S, D, A to move the player through the arena.");
        tutorial.setForeground(Color.white);
        tutorialpanel.add(tutorial, 0);
    }
    
    private void setPanel(){
        boolean music = game.getMusicOn();
        Font font = new Font(Font.DIALOG, Font.BOLD, 24);
        messageLabel = new JLabel("     Paused     ");
        spaceLabel = new JLabel("                         ");
        musicButton = new JButton("");
        livesLabel.setText("Lives: " + Board.getInstance().getLives());
        pointsLabel = new JLabel("Points: " + Board.getInstance().getPoints());
        messageLabel.setFont(font);
        pointsLabel.setForeground(Color.WHITE);
        livesLabel.setForeground(Color.WHITE);
        messageLabel.setForeground(Color.black);
        if (music) {
            musicButton.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\SelectCharacter\\sound_32.png"));
        } else {
            musicButton.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\SelectCharacter\\notsound_32.png"));
        }
        musicButton.setForeground(Color.white);
        musicButton.addActionListener(new setMusic());
        skipDemo = new JButton("  Skip Demo  ");
        skipDemo.setFont(font);
        skipDemo.setForeground(Color.BLACK);
        skipDemo.setVisible(false);
    }
    
    public JLabel getTutorial(){
        return tutorial;
    }
}