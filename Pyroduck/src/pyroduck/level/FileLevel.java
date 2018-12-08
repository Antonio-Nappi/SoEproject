package pyroduck.level;

import java.io.*;
import java.util.StringTokenizer;
import pyroduck.*;
import pyroduck.entities.*;
import pyroduck.entities.mob.Player;
import pyroduck.entities.mob.enemy.graphic.*;
import pyroduck.entities.tile.*;
import pyroduck.entities.tile.destroyable.*;
import pyroduck.entities.tile.powerup.*;
import pyroduck.exceptions.LoadLevelException;
import pyroduck.graphics.*;
import pyroduck.input.Keyboard;

/**
 * It is the level loader.
 * It take care of reading the ".txt" file and substituted each character with the entity related.
 * @author Corbisiero, Ferrara, La Femina
 */
public class FileLevel{

    public static final int WIDTH = 31, HEIGHT = 13;
    protected int level;
    protected String[] lineTiles;

    /**
     * Costructs level file.
     * @param path related to the ".txt" file.
     * @throws LoadLevelException error in the charge of level.
     */
    public FileLevel(String path) throws LoadLevelException {
		loadLevel(path);
                
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
  
    public Entity[] createEntities(){
        Entity[] entities = new Entity[WIDTH*HEIGHT];//entity = player, mobs, powerups,..., also tile!!!
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                char c = lineTiles[y].charAt(x);  //for each character read in this file we call addLevelEntity
                int pos = x + y * WIDTH;
                if(!Keyboard.getInstance().isIce()){
                    switch(c) {
                        case '#': 
                           entities[pos] = new WallTile(x, y);  
                            break;
                        case '*': 
                           entities[pos] = new LayeredEntity(x, y, 
                                            new GrassTile(x ,y ), 
                                                new BrickTile(x ,y));
                            break;
                        case ' ': 
                            entities[pos] = new GrassTile(x, y);
                            break;
                        case 'p': 
                            Board.getInstance().addMob(new Player(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE));   //24 are real width and height of player
                            Screen.setOffset(0, 0);
                            entities[pos] = new GrassTile(x, y);
                            break;
                        case 'f':
                            LayeredEntity layer = new LayeredEntity(x, y, 
                                                    new GrassTile(x ,y), 
                                                        new BrickTile(x ,y));
                            layer.addBeforeTop(new PowerupFlames(x, y));				
                           entities[pos] = layer;
                            break;  
                        case 's':
                            LayeredEntity layer2 = new LayeredEntity(x, y, 
                                                    new GrassTile(x ,y), 
                                                        new BrickTile(x ,y));
                            layer2.addBeforeTop(new PowerupSpeed(x, y));				
                            entities[pos] = layer2;
                            break;
                        case 'o':
                            entities[pos] = new LayeredEntity(x, y, 
                                                new GrassTile(x ,y),
                                                    new MalusSlow(x, y));

                            break; 
                        case 'b':
                            LayeredEntity layer3 = new LayeredEntity(x, y, 
                                                    new GrassTile(x ,y), 
                                                        new BrickTile(x ,y));
                            layer3.addBeforeTop(new PowerupBombs(x, y));				
                            entities[pos] = layer3;
                            break;
                        case 'm':
                            LayeredEntity layer4 = new LayeredEntity(x, y, 
                                                    new GrassTile(x ,y), 
                                                        new BrickTile(x ,y));
                            layer4.addBeforeTop(new MalusReverse(x, y));				
                            entities[pos] = layer4;
                            break;
                        case 'l':
                            LayeredEntity layer6 = new LayeredEntity(x, y, 
                                                    new GrassTile(x ,y), 
                                                        new BrickTile(x ,y));
                            layer6.addBeforeTop(new PowerupLife(x, y));				
                            entities[pos] = layer6;
                            break;
                        case 'w': 
                            LayeredEntity layer5= new LayeredEntity(x, y,
                                                   new GrassTile (x,y),
                                                       new BrickTile(x,y));
                            layer5.addBeforeTop(new PortalTile(x,y));
                            entities[pos] = layer5;
                            break;
                        case '1':
                            Board.getInstance().addMob(new Golbat(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE));
                            entities[pos] = new GrassTile(x, y);
                            break;
                        case '2':
                            Board.getInstance().addMob(new Machamp(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE)); 
                            entities[pos] = new GrassTile(x, y);
                            break;
                        case '3':
                            Board.getInstance().addMob(new Arbok(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE)); 
                            entities[pos] = new GrassTile(x, y);
                            break;
                        default: 
                            entities[pos] = new GrassTile(x, y);
                            break;
                    }        
                }else{
                    switch(c) {
                        case '#':
                           entities[pos] = new WallIceTile(x, y);
                            break;
                        case '*':
                            entities[pos] = new LayeredEntity(x, y,
                                            new IceTile(x ,y),
                                                new BrickIceTile(x ,y));
                            break;
                        case ' ':
                            entities[pos] = new IceTile(x, y);
                            break;
                        case 'p':
                            Board.getInstance().addMob(new Player(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE));
                            Screen.setOffset(0, 0);
                            entities[pos] = new IceTile(x, y);
                            break;
                        case 'f':
                            LayeredEntity layer = new LayeredEntity(x, y,
                                                    new IceTile(x ,y),
                                                        new BrickIceTile(x ,y));
                            layer.addBeforeTop(new PowerupFlames(x, y));
                           entities[pos] = layer;
                            break;
                        case 's':
                            LayeredEntity layer2 = new LayeredEntity(x, y,
                                                    new IceTile(x ,y),
                                                        new BrickIceTile(x ,y));
                            layer2.addBeforeTop(new PowerupSpeed(x, y));
                            entities[pos] = layer2;
                            break;
                        case 'o':
                            entities[pos] = new LayeredEntity(x, y,
                                                new IceTile(x ,y),
                                                    new MalusSlow(x, y));

                            break;
                          case 'b':
                            LayeredEntity layer3 = new LayeredEntity(x, y,
                                                    new IceTile(x ,y),
                                                        new BrickIceTile(x ,y));
                            layer3.addBeforeTop(new PowerupBombs(x, y));
                            entities[pos] = layer3;
                            break;
                        case 'm':
                            LayeredEntity layer4 = new LayeredEntity(x, y,
                                                    new IceTile(x ,y),
                                                        new BrickIceTile(x ,y));
                            layer4.addBeforeTop(new MalusReverse(x, y));
                            entities[pos] = layer4;
                            break;
                        case 'l':
                            LayeredEntity layer6 = new LayeredEntity(x, y,
                                                    new IceTile(x ,y),
                                                        new BrickIceTile(x ,y));
                            layer6.addBeforeTop(new PowerupLife(x, y));
                            entities[pos] = layer6;
                            break;
                        case 'u':
                            LayeredEntity layer7 = new LayeredEntity(x, y,
                                                    new IceTile(x ,y),
                                                        new BrickIceTile(x ,y));
                            layer7.addBeforeTop(new PowerupNotSlip(x, y));
                            entities[pos] = layer7;
                            break;
                        case 'w':
                            LayeredEntity layer5= new LayeredEntity(x, y,
                                                   new IceTile (x,y),
                                                       new BrickIceTile(x,y));
                            layer5.addBeforeTop(new PortalTile(x,y));
                            entities[pos] = layer5;
                            break;
                        case 'z':
                            ContextDestroyable con = Board.getInstance().getContextState();
                            IntactState intact = new IntactState(x, y);
                            con.setState(intact);
                            entities[pos] = intact;
                            break;
                        case '1':
                            Board.getInstance().addMob(new Snorunt(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE));
                            entities[pos] = new IceTile(x, y);
                            break;
                        case '2':
                            Board.getInstance().addMob(new Glalie(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE));
                            entities[pos] = new IceTile(x, y);
                            break;
                        case '3':
                            Board.getInstance().addMob(new Darkrai(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE)); 
                            entities[pos] = new IceTile(x, y);
                            break;
                        case 'a':
                            LayeredEntity layer8= new LayeredEntity(x, y,
                                                   new IceTile (x,y),
                                                       new BrickIceTile(x,y));
                            layer8.addBeforeTop(new PowerupVehicles(x,y));
                            entities[pos] = layer8;
                            break;
                        default:
                            entities[pos] = new IceTile(x, y);
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