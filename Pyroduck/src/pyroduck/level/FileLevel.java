package pyroduck.level;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.util.List;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.Entity;
import pyroduck.entities.LayeredEntity;
import pyroduck.entities.mob.AutomatePlayer;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.Player;
import pyroduck.entities.mob.enemy.graphic.Arbok;
import pyroduck.entities.mob.enemy.graphic.Darkrai;
import pyroduck.entities.mob.enemy.graphic.Glalie;
import pyroduck.entities.mob.enemy.graphic.Golbat;
import pyroduck.entities.mob.enemy.graphic.Machamp;
import pyroduck.entities.mob.enemy.graphic.Snorunt;
import pyroduck.entities.tile.GrassTile;
import pyroduck.entities.tile.PortalTile;
import pyroduck.entities.tile.WallTile;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.entities.tile.destroyable.ContextDestroyable;
import pyroduck.entities.tile.destroyable.IntactState;
import pyroduck.entities.tile.powerup.MalusReverse;
import pyroduck.entities.tile.powerup.MalusSlow;
import pyroduck.entities.tile.powerup.Powerup;
import pyroduck.entities.tile.powerup.PowerupBombs;
import pyroduck.entities.tile.powerup.PowerupFlames;
import pyroduck.entities.tile.powerup.PowerupLife;
import pyroduck.entities.tile.powerup.PowerupNotSlip;
import pyroduck.entities.tile.powerup.PowerupSpeed;
import pyroduck.entities.tile.powerup.PowerupVehicles;
import pyroduck.exceptions.LoadLevelException;
import pyroduck.graphics.*;

/**
 * It is the level loader. It take care of reading the ".txt" file and
 * substituted each character with the entity related.
 *
 * @author Corbisiero, Ferrara, La Femina
 */
public abstract class FileLevel {

    public static final int WIDTH = 31, HEIGHT = 13;
    protected int level;
    protected String[] lineTiles;

    /**
     * Costructs level file.
     *
     * @param path related to the ".txt" file.
     * @throws LoadLevelException error in the charge of level.
     */
    public FileLevel(String path, BufferedReader in,int level) throws LoadLevelException {
        this.level = level;
        loadLevel(path, in);
    }

    /**
     * Load the level information (level, width, height) and the map
     * information.
     *
     * @param path related to the ".txt" file.
     * @throws LoadLevelException error in the charge of level.
     */
    public void loadLevel(String path, BufferedReader in) throws LoadLevelException {
        try {
            lineTiles = new String[HEIGHT];
            for (int i = 0; i < HEIGHT; ++i) {
                lineTiles[i] = in.readLine().substring(0, WIDTH); //It reads each line of "level.txt" and storage it into a String array
            }
        } catch (IOException ex) {
            Logger.getLogger(FileLevel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public Entity[] createEntities(){
        Entity[] entities = new Entity[WIDTH*HEIGHT];//entity = player, mobs, powerups,..., also tile!!!
        List destroyableIce = Board.getInstance().getDestroyableIceTile();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                char c = lineTiles[y].charAt(x);  //for each character read in this file we call addLevelEntity
                int pos = x + y * WIDTH;
                switch (c) {
                    case '#':
                        entities[pos] = createWall(x, y);
                        break;
                    case '*':
                        entities[pos] = new LayeredEntity(x, y,
                                createGrass(x, y),
                                createBrick(x, y));
                        break;
                    case ' ':
                        entities[pos] = createGrass(x, y);
                        break;
                    case 'p':
                        Board.getInstance().addMob(new Player(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE));   //24 are real width and height of player
                        Screen.setOffset(0, 0);
                        entities[pos] = createGrass(x, y);
                        break;
                    case 'f':
                        LayeredEntity layer = new LayeredEntity(x, y,
                                createGrass(x, y),
                                createBrick(x, y));
                        layer.addBeforeTop(new PowerupFlames(x, y, Sprite.powerup_flames));
                        entities[pos] = layer;
                        break;
                    case 's':
                        LayeredEntity layer2 = new LayeredEntity(x, y,
                                createGrass(x, y),
                                createBrick(x, y));
                        layer2.addBeforeTop(new PowerupSpeed(x, y, Sprite.powerup_speed));
                        entities[pos] = layer2;
                        break;
                    case 'o':
                        entities[pos] = new LayeredEntity(x, y,
                                createGrass(x, y),
                                createPowerup(x, y));
                        break;
                    case 'b':
                        LayeredEntity layer3 = new LayeredEntity(x, y,
                                createGrass(x, y),
                                createBrick(x, y));
                        layer3.addBeforeTop(new PowerupBombs(x, y, Sprite.powerup_bombs));
                        entities[pos] = layer3;
                        break;
                    case 'm':
                        LayeredEntity layer4 = new LayeredEntity(x, y,
                                createGrass(x, y),
                                createBrick(x, y));
                        layer4.addBeforeTop(new MalusReverse(x, y, Sprite.powerup_malus));
                        entities[pos] = layer4;
                        break;
                    case 'l':
                        LayeredEntity layer6 = new LayeredEntity(x, y,
                                createGrass(x, y),
                                createBrick(x, y));
                        layer6.addBeforeTop(new PowerupLife(x, y, Sprite.powerup_life));
                        entities[pos] = layer6;
                        break;
                    case 'w':
                        LayeredEntity layer5 = new LayeredEntity(x, y,
                                createGrass(x, y),
                                createBrick(x, y));
                        layer5.addBeforeTop(new PortalTile(x, y, Sprite.portal));
                        entities[pos] = layer5;
                        break;
                    case '1':
                        Board.getInstance().addMob(createFirstEnemy(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE));
                        entities[pos] = createGrass(x, y);
                        break;
                    case '2':
                        Board.getInstance().addMob(createSecondEnemy(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, 2));
                        entities[pos] = createGrass(x, y);
                        break;
                    case '3':
                        Board.getInstance().addMob(createSecondEnemy(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, 3));
                        entities[pos] = createGrass(x, y);
                        break;
                    case 'z':
                        ContextDestroyable con = Board.getInstance().getContextState();
                        IntactState intact = new IntactState(x, y, Sprite.ice);
                        con.setState(intact);
                        Board.getInstance().getDestroyableIceTile().add(intact);
                        entities[pos] = intact;
                        break;
                    case 'u':
                        LayeredEntity layer7 = new LayeredEntity(x, y,
                                createGrass(x, y),
                                createBrick(x, y));
                        layer7.addBeforeTop(new PowerupNotSlip(x, y, Sprite.powerup_not_slip));
                        entities[pos] = layer7;
                        break;
                    case 'a':
                        LayeredEntity layer8 = new LayeredEntity(x, y,
                                createGrass(x, y),
                                createBrick(x, y));
                        layer8.addBeforeTop(new PowerupVehicles(x, y, Sprite.powerup_articuno));
                        entities[pos] = layer8;
                        break;
                    case 'd':
                        Board.getInstance().addMob(new AutomatePlayer(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE));   //24 are real width and height of player
                        Screen.setOffset(0, 0);
                        entities[pos] = createGrass(x, y);
                        break;
                    default:
                        entities[pos] = createGrass(x, y);
                        break;
                }
            }
        }
        return entities;
    }

    /**
     * Return the number of level charged.
     *
     * @return the number of level charged.
     */
    public int getLevel() {
        return this.level;
    }

    public abstract WallTile createWall(int x, int y);

    public abstract BrickTile createBrick(int x, int y);

    public abstract GrassTile createGrass(int x, int y);

    public abstract Mob createFirstEnemy(int x, int y);

    public abstract Mob createSecondEnemy(int x, int y, int choose);

    public abstract Powerup createPowerup(int x, int y);

}
