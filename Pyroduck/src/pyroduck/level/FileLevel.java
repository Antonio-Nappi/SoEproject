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
public class FileLevel{

    public static final int WIDTH = 31, HEIGHT = 13;
    protected int level;
    protected String world;
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
            world = tokens.nextToken();
            lineTiles = new String[HEIGHT];
            for(int i = 0; i < HEIGHT; ++i) {
                lineTiles[i] = in.readLine().substring(0, WIDTH); //It reads each line of "level.txt" and storage it into a String array
            }
            in.close();
        } catch (IOException e) {
            throw new LoadLevelException("Error loading level ");
        }
    }

    /**
     *
     */
    public Entity[] createEntities(Board board) {
        Entity[] entities = new Entity[WIDTH*HEIGHT];//entity = player, mobs, powerups,..., also tile!!!
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                char c = lineTiles[y].charAt(x);  //for each character read in this file we call addLevelEntity
                int pos = x + y * WIDTH;
                if(world.equals("G")){
                    switch(c) {
                        case '#':
                           entities[pos] = new WallTile(x, y, Sprite.wall);
                            break;
                        case '*':
                           entities[pos] = new LayeredEntity(x, y,
                                            new GrassTile(x ,y, Sprite.grass),
                                                new BrickTile(x ,y, Sprite.brick));
                            break;
                        case ' ':
                            entities[pos] = new GrassTile(x, y, Sprite.grass);
                            break;
                        case 'p':
                            board.addMob(new Player(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, board));
                            Screen.setOffset(0, 0);
                           entities[pos] = new GrassTile(x, y, Sprite.grass);
                            break;
                        case 'f':
                            LayeredEntity layer = new LayeredEntity(x, y,
                                                    new GrassTile(x ,y, Sprite.grass),
                                                        new BrickTile(x ,y, Sprite.brick));
                            layer.addBeforeTop(new PowerupFlames(x, y, Sprite.powerup_flames));
                           entities[pos] = layer;
                            break;
                        case 's':
                            LayeredEntity layer2 = new LayeredEntity(x, y,
                                                    new GrassTile(x ,y, Sprite.grass),
                                                        new BrickTile(x ,y, Sprite.brick));
                            layer2.addBeforeTop(new PowerupSpeed(x, y, Sprite.powerup_speed));
                            entities[pos] = layer2;
                            break;
                        case 'o':
                            entities[pos] = new LayeredEntity(x, y,
                                                new GrassTile(x ,y, Sprite.grass),
                                                    new MalusSlow(x, y, Sprite.powerup_slow));

                            break;
                          case 'b':
                            LayeredEntity layer3 = new LayeredEntity(x, y,
                                                    new GrassTile(x ,y, Sprite.grass),
                                                        new BrickTile(x ,y, Sprite.brick));
                            layer3.addBeforeTop(new PowerupBombs(x, y, Sprite.powerup_bombs));
                            entities[pos] = layer3;
                            break;

                        case 'm':
                            LayeredEntity layer4 = new LayeredEntity(x, y,
                                                    new GrassTile(x ,y, Sprite.grass),
                                                        new BrickTile(x ,y, Sprite.brick));
                            layer4.addBeforeTop(new MalusReverse(x, y, Sprite.powerup_malus));
                            entities[pos] = layer4;
                            break;
                        case 'l':
                            LayeredEntity layer6 = new LayeredEntity(x, y,
                                                    new GrassTile(x ,y, Sprite.grass),
                                                        new BrickTile(x ,y, Sprite.brick));
                            layer6.addBeforeTop(new PowerupLife(x, y, Sprite.powerup_life));
                            entities[pos] = layer6;
                            break;
                        case 'w': //gestione portale
                            LayeredEntity layer5= new LayeredEntity(x, y,
                                                   new GrassTile (x,y, Sprite.grass),
                                                       new BrickTile(x,y, Sprite.brick));
                            layer5.addBeforeTop(new PortalTile(x,y, this.board, Sprite.portal));
                            entities[pos] = layer5;
                            break;
                        default:
                            entities[pos] = new GrassTile(x, y, Sprite.grass);
                            break;
                    }
                }
                else{
                    switch(c) {
                        case '#':
                           entities[pos] = new WallTile(x, y, Sprite.wallice);
                            break;
                        case '*':
                           entities[pos] = new LayeredEntity(x, y,
                                            new GrassTile(x ,y, Sprite.ice),
                                                new BrickTile(x ,y, Sprite.brickice));
                            break;
                        case ' ':
                            entities[pos] = new GrassTile(x, y, Sprite.ice);
                            break;
                        case 'p':
                            board.addMob(new Player(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, board));
                            Screen.setOffset(0, 0);
                           entities[pos] = new GrassTile(x, y, Sprite.ice);
                            break;
                        case 'f':
                            LayeredEntity layer = new LayeredEntity(x, y,
                                                    new GrassTile(x ,y, Sprite.ice),
                                                        new BrickTile(x ,y, Sprite.brickice));
                            layer.addBeforeTop(new PowerupFlames(x, y, Sprite.powerup_flames));
                           entities[pos] = layer;
                            break;
                        case 's':
                            LayeredEntity layer2 = new LayeredEntity(x, y,
                                                    new GrassTile(x ,y, Sprite.ice),
                                                        new BrickTile(x ,y, Sprite.brickice));
                            layer2.addBeforeTop(new PowerupSpeed(x, y, Sprite.powerup_speed));
                            entities[pos] = layer2;
                            break;
                        case 'o':
                            entities[pos] = new LayeredEntity(x, y,
                                                new GrassTile(x ,y, Sprite.ice),
                                                    new MalusSlow(x, y, Sprite.powerup_slow));

                            break;
                          case 'b':
                            LayeredEntity layer3 = new LayeredEntity(x, y,
                                                    new GrassTile(x ,y, Sprite.ice),
                                                        new BrickTile(x ,y, Sprite.brickice));
                            layer3.addBeforeTop(new PowerupBombs(x, y, Sprite.powerup_bombs));
                            entities[pos] = layer3;
                            break;

                        case 'm':
                            LayeredEntity layer4 = new LayeredEntity(x, y,
                                                    new GrassTile(x ,y, Sprite.ice),
                                                        new BrickTile(x ,y, Sprite.brickice));
                            layer4.addBeforeTop(new MalusReverse(x, y, Sprite.powerup_malus));
                            entities[pos] = layer4;
                            break;
                        case 'l':
                            LayeredEntity layer6 = new LayeredEntity(x, y,
                                                    new GrassTile(x ,y, Sprite.ice),
                                                        new BrickTile(x ,y, Sprite.brickice));
                            layer6.addBeforeTop(new PowerupLife(x, y, Sprite.powerup_life));
                            entities[pos] = layer6;
                            break;
                        case 'w': //gestione portale
                            LayeredEntity layer5= new LayeredEntity(x, y,
                                                   new GrassTile (x,y, Sprite.ice),
                                                       new BrickTile(x,y, Sprite.brickice));
                            layer5.addBeforeTop(new PortalTile(x,y, this.board, Sprite.portal));
                            entities[pos] = layer5;
                            break;
                        default:
                            entities[pos] = new GrassTile(x, y, Sprite.ice);
                            break;
                    }
                }
            }
        }
        return entities;
    }

    /**
     * Return the number of level charged.
     * @return the number of level charged.
     */
    public int getLevel() {
        return this.level;
    }
}
