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
import pyroduck.input.Keyboard;

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
    
    private final Keyboard input;
    private final Board board;
    private final Screen screen;
    private static Game instance = null;
    private final Timer timer;
    //this will be used to render the game, each render is a calculated image saved here
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData(); 
    //Raster è una classe che rappresenta una matrice di pixel. Le immagini contenute nel buffer vengono estratte, e 
    //tramite un oggetto di tipo Raster viene creata una matrice di interi rappresentatnti i pixels delle immagini. 

    private Game() throws PyroduckException {

        timer = new Timer();
        this.screen = new Screen();
        this.input = new Keyboard();
        this.board = new Board(this.input, this.screen);
        addKeyListener(this.input);
    }
    
    public static Game getInstance() throws PyroduckException{
        if (instance == null)
            instance = new Game();
        return instance;
    }

    private void renderGame() { //render will run the maximum times it can per second
        BufferStrategy bs = getBufferStrategy(); //represents the mechanism with which to organize complex memory on a Canvas
        if(bs == null) { //if canvas dont have a bufferstrategy, create it
            createBufferStrategy(1); //triple buffer
            return;
        }
        screen.clear();
        board.render(screen);
        for (int i = 0; i < pixels.length; i++) { //create the image to be rendered
            pixels[i] = screen.pixels[i];
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose(); //release resources
        bs.show(); //make next buffer visible
    }

    private void update() {
        if (!reverse)
        input.update();
        else input.updateReverse();
        board.update();
    }

    public void start() {
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
        reverse=b;
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

    public Board getBoard() {
        return board;
    }

    private class ScheduleTask extends TimerTask{
        @Override
        public void run(){
            renderGame();
            update();
        }           
    }  
}
