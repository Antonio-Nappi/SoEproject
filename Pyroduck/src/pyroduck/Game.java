package pyroduck;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Timer;
import java.util.TimerTask;
import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.Screen;
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

    //initial configs
    private static final int BOMBRATE = 1;
    private static final int BOMBRADIUS = 1;
    private static final double PLAYERSPEED = 1.3;

    //can be modified with bonus
    protected static int bombRate = BOMBRATE;
    protected static int bombRadius = BOMBRADIUS;
    protected static double playerSpeed = PLAYERSPEED;
    protected static boolean reverse=false;
    protected static int rev = 0;
    protected static int lives;
    protected static int points;
    protected static boolean pause=false;
    private Keyboard input;
    private final Board board;
    private final Screen screen;
    private static Game instance = null;
    private Timer timer;
    //this will be used to render the game, each render is a calculated image saved here
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData(); 
    //Raster è una classe che rappresenta una matrice di pixel. Le immagini contenute nel buffer vengono estratte, e 
    //tramite un oggetto di tipo Raster viene creata una matrice di interi rappresentatnti i pixels delle immagini. 
    protected int selected = 0; 
            
    private Game() throws PyroduckException {
        timer = new Timer();
        screen = new Screen();
        board = new Board(screen);
        lives = 3;
        points = 0;
    }
    
    public static Game getInstance() throws PyroduckException{
        if (instance == null)
            instance = new Game();
        return instance;
    }

    private void renderGame() { //render will run the maximum times it can per second
        BufferStrategy bs = getBufferStrategy(); //represents the mechanism with which to organize complex memory on a Canvas
        if(bs == null) { //if canvas dont have a bufferstrategy, create it
            createBufferStrategy(1); //buffer
            return;
        }
        screen.clear();
        board.render(screen);
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


        board.drawScreen(g);

        g.dispose();
        bs.show();
    }

    public Timer getTimer() {
        return timer;
    }

    public void resume(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 15);
        board.setPause(false);
    }
    public void pause(){
        timer.cancel();
        board.setPause(true);
    }
    
    private void update(){   
        board.update();
        if(input!= getBoard().getInput()){
            this.input = getBoard().getInput();
            addKeyListener(input);
        }
        if(lives != board.getLives())
            board.setLives(lives);
        if(points != board.getPoints())
            board.setPoints(points);
        if (!reverse)
            input.update();
        else 
            input.updateReverse();
    }

    public void start() {
        this.input = getBoard().getInput();
        addKeyListener(input);
        requestFocus();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 15);
    }
    
    public static void addBombRate(int i) {
        bombRate += i;
    }
        	
    public static void addBombRadius(int i) {
        bombRadius += i;
    }
    
    public static void addPlayerSpeed(double i) {
		playerSpeed += i;
    }
	
    public static void decreasePlayerSpeed(double i) {        
        playerSpeed = playerSpeed -i;
    }
    
    public static void reverseInput(boolean b){
        reverse = b;
    }
    
    public static void addLives(int i){
        lives += i;
    }
    
    public static void addPoints(int i){
        points += i;
    }
    /*
    |--------------------------------------------------------------------------
    | Getters & Setters
    |--------------------------------------------------------------------------
     */
    public static double getPlayerSpeed() {
        return playerSpeed;
    }

    public static int getBombRate() {
        return bombRate;
    }

    public static int getBombRadius() {
        return bombRadius;
    }

    public Keyboard getInput() {
        return input;
    }

    public int getSelected() {
        return selected;
    }

    public Board getBoard() {
        return board;
    }

    public static int getLives() {
        return lives;
    }
    
    public static int getPoints() {
        return points;
    }

    public void setSelected(int selected) {
        
        this.selected = selected;
        if(selected==1){
            playerSpeed=1;
            
        }
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
