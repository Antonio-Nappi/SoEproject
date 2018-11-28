package pyroduck.level;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.FileReader;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.Entity;
import pyroduck.entities.LayeredEntity;
import pyroduck.entities.mob.Player;
import pyroduck.entities.tile.GrassTile;
import pyroduck.entities.tile.PortalTile;
import pyroduck.entities.tile.WallTile;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.entities.tile.powerup.MalusSlow;
import pyroduck.entities.tile.powerup.*;
import pyroduck.exceptions.LoadLevelException;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;

/**
 * It is the level loader.
 * It take care of reading the ".txt" file and substituted each character with the entity related.
 * @author Corbisiero, Ferrara, La Femina
 */
public abstract class FileLevel{

    public static final int WIDTH = 31, HEIGHT = 13;
    protected int level;
    protected String[] lineTiles;
    protected Board board;


    /**
     * Costructs level file.
     * @param path related to the ".txt" file.
     * @throws LoadLevelException error in the charge of level.
     */
//    public FileLevel(String path) throws LoadLevelException {
//        loadLevel(path);
//        System.out.println(path);
//    }

    public FileLevel(String path, Board board) throws LoadLevelException {
		loadLevel(path);
                this.board=board;
                System.out.println(path);
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
            lineTiles = new String[HEIGHT];
            for(int i = 0; i < HEIGHT; ++i) {
                lineTiles[i] = in.readLine().substring(0, WIDTH); //It reads each line of "level.txt" and storage it into a String array
            }
            in.close();
        } catch (IOException e) {
            throw new LoadLevelException("Error loading level ");
        }
    }


    public abstract Entity[] createEntities(Board board, String world);

    /**
     * Return the number of level charged.
     * @return the number of level charged.
     */
    public int getLevel() {
        return this.level;
    }
}
