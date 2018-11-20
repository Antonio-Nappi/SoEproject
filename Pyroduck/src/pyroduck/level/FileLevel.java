package pyroduck.level;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.FileReader;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.LayeredEntity;
import pyroduck.entities.mob.Player;
import pyroduck.entities.tile.GrassTile;
import pyroduck.entities.tile.WallTile;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.exceptions.LoadLevelException;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;

/**
 * It is the level loader. 
 * It take care of reading the ".txt" file and substituted each character with the entity related. 
 * @author Corbisiero, Ferrara, La Femina
 */
public class FileLevel{

    protected int width, height, level;
    protected String[] lineTiles;
    protected Board board;

    /**
     * Costructs level file.
     * @param path related to the ".txt" file.
     * @param board
     * @throws LoadLevelException error in the charge of level.
     */
    public FileLevel(String path, Board board) throws LoadLevelException {
        loadLevel(path);
        this.board = board;
    }

    /**
     * Load the level information (level, width, height) and the map information.
     * @param path related to the ".txt" file.
     * @throws LoadLevelException error in the charge of level.
     */
    public void loadLevel(String path) throws LoadLevelException {
        try { 
            BufferedReader in = new BufferedReader(new FileReader(path));
            String data = in.readLine();      //the first line of the ".txt" file-level has 3 int: 1->level, 2->map-height, 3->map-width
            StringTokenizer tokens = new StringTokenizer(data);  //because this int are separated from a space
            level = Integer.parseInt(tokens.nextToken());
            height = Integer.parseInt(tokens.nextToken());
            width = Integer.parseInt(tokens.nextToken());
            lineTiles = new String[height];  
            for(int i = 0; i < height; ++i) {
                lineTiles[i] = in.readLine().substring(0, width); //It reads each line of "level.txt" and storage it into a String array
            }
            in.close();
        } catch (IOException e) {
            throw new LoadLevelException("Error loading level ");
        }
    }

    /**
     * 
     */
    public void createEntities() {                        //entity = player, mobs, powerups,..., also tile!!!
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                addLevelEntity(lineTiles[y].charAt(x), x, y);   //for each character read in this file we call addLevelEntity
            }
        }
    }

    /**
     * Delegates the board to add the entity corrisponding at the character passed.
     * @param c character related at the entity.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     */
    public void addLevelEntity(char c, int x, int y) {
        int pos = x + y * getWidth();
        switch(c) { 
            case '#': 
                board.addEntity(pos, new WallTile(x, y, Sprite.wall));  
                break;
            case '*': 
                board.addEntity(pos, new LayeredEntity(x, y, 
                                new GrassTile(x ,y, Sprite.grass), 
                                new BrickTile(x ,y, Sprite.brick)));
                break;
            case 'x': 
                board.addEntity(pos, new LayeredEntity(x, y, 
                                new GrassTile(x ,y, Sprite.grass),
                                new BrickTile(x ,y, Sprite.brick)));
                break;
            case ' ': 
                board.addEntity(pos, new GrassTile(x, y, Sprite.grass));
                break;
            case 'p': 
                board.addMob(new Player(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, board)); 
                Screen.setOffset(0, 0);

                board.addEntity(pos, new GrassTile(x, y, Sprite.grass));
                break;
            default: 
                board.addEntity(pos, new GrassTile(x, y, Sprite.grass));
                break;
        }
    }
    
    /**
     * Return the level width. 
     * @return the level width. 
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Return the level height.
     * @return the level height.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Return the number of level charged.
     * @return the number of level charged.
     */
    public int getLevel() {
        return this.level;
    }
}