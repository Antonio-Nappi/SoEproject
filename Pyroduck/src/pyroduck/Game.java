package pyroduck;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.*;
import javax.sound.sampled.*;
import pyroduck.audio.AudioPlayer;
import pyroduck.graphics.Screen;
import pyroduck.gui.SettingsGame;
import pyroduck.input.*;

public class Game extends Canvas {
    /*
    |--------------------------------------------------------------------------
    | Options & Configs
    |--------------------------------------------------------------------------
     */
    public static final int TILES_SIZE = 32,
                            WIDTH = TILES_SIZE * (int)(31 / 2), //minus one to ajust the window,
                            HEIGHT = 13 * TILES_SIZE;
    protected int bombRate = 1;
    protected int bombRadius = 1;
    protected double playerSpeed = 1.3;
    protected boolean reverse=false;
    protected static int rev = 0;
    protected static boolean pause=false;
    private Keyboard input;
    private final Board board;
    private final Screen screen;
    private static Game instance = null;
    private Timer timer;
    private static AudioPlayer audio;
    private static boolean musicon = SettingsGame.isMusic();
    private final BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private final int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    protected int selected = 0; 
            
    private Game() {
        timer = new Timer();
        screen = new Screen();
        board = Board.getInstance();
        board.changeLevel(1);
        board.setScreen(screen);
    }
    
    public static Game getInstance(){
        if (instance == null)
            instance = new Game();
        return instance;
    }

    public void restartGame(){
        board.changeLevel(1);
        board.resetProperties();
    }
    
    private void renderGame() { //render will run the maximum times it can per second
        BufferStrategy bs = getBufferStrategy(); //represents the mechanism with which to organize complex memory on a Canvas
        if(bs == null) { //if canvas dont have a bufferstrategy, create it
            createBufferStrategy(1); //buffer
            return;
        }
        screen.clear();
        board.render();
        System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length); //create the image to be rendered
        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose(); //release resources
        bs.show(); //make next buffer visible
    }
    
    public void renderScreen() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }
        screen.clear();
        Graphics g = bs.getDrawGraphics();
        screen.drawChangeLevel(g, board.getLevel());
        g.dispose();
        bs.show();
    }

    public void resume(){
        try {
            audio.resumeAudio();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 15);
        board.setPause(false);
    }
    
    public void pause(){
        audio.pause();
        timer.cancel();
        board.setPause(true);
    }
    
    private void update(){   
        board.update();
        if(input!= Board.getInstance().getInput()){
            this.input = Board.getInstance().getInput();
            addKeyListener(input);
        }
        if (!reverse)
            input.update();
        else 
            input.updateReverse();
    }

    public void start() {   
        try {
            setMusicOn(musicon);
            this.input = Board.getInstance().getInput();
            addKeyListener(input);
            requestFocus();
            timer.scheduleAtFixedRate(new ScheduleTask(), 1, 15);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void changeAudioLevel(int n){
        try {
            audio.stop();      
            audio = AudioPlayer.getAudioPlayer("Level" + n + ".wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addBombRate(int i) {
        bombRate += i;
    }
        	
    public void addBombRadius(int i) {
        bombRadius += i;
    }
    
    public void addPlayerSpeed(double i) {
        playerSpeed += i;
    }
	
    public void decreasePlayerSpeed(double i) {        
        playerSpeed -= i;
    }
    
    public void reverseInput(boolean b){
        reverse = b;
    }
    
    /*
    |--------------------------------------------------------------------------
    | Getters & Setters
    |--------------------------------------------------------------------------
     */
    
    public double getPlayerSpeed() {
        return playerSpeed;
    }

    public int getBombRate() {
        return bombRate;
    }

    public int getBombRadius() {
        return bombRadius;
    }

    public Keyboard getInput() {
        return input;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
        if(selected == 1){
            playerSpeed = 1;   
        }
    }
    
    public void setBombRate(int bombRate) {
       this.bombRate = bombRate;
    }

    public void setBombRadius(int bombRadius) {
        this.bombRadius = bombRadius;
    }

    public void setPlayerSpeed(double playerSpeed) {
        this.playerSpeed = playerSpeed;
    }
    
    public void setMusicOn(boolean music) throws UnsupportedAudioFileException, IOException, LineUnavailableException{      
        int i = Board.getInstance().level.getLevel();
        musicon = music;
        if(audio == null)
            if(Board.getInstance().getLevel() <= 0)
               audio = AudioPlayer.getAudioPlayer("Level"+1+".wav"); 
            else 
                audio = AudioPlayer.getAudioPlayer("Level"+i+".wav");
        audio.pause();
        if(!music)
            audio.musicOff();
        else 
            audio.musicOn();       
    }
     
    public boolean getMusicOn(){
        return musicon;
    }
    
    private class ScheduleTask extends TimerTask{
        @Override
        public void run(){
            if(reverse){
                if(++rev >= 667){
                    reverse = false;
                    rev = 0;
                }     
            }
            renderGame();
            update();
        }
    }
}