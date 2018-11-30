package pyroduck.level;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.*;
import pyroduck.entities.mob.*;
import pyroduck.entities.mob.enemy.graphic.Darkrai;
import pyroduck.entities.mob.enemy.graphic.Glalie;
import pyroduck.entities.mob.enemy.graphic.Snorunt;
import pyroduck.entities.tile.*;
import pyroduck.entities.tile.destroyable.*;
import pyroduck.entities.tile.powerup.*;
import pyroduck.exceptions.LoadLevelException;
import pyroduck.graphics.*;

public class IceStrategy extends FileLevel{
    
    public IceStrategy(String path, Board board) throws LoadLevelException {
        super(path, board);
    }
    
    @Override
    public Entity[] createEntities(Board board) {
        Entity[] entities = new Entity[WIDTH*HEIGHT];//entity = player, mobs, powerups,..., also tile!!!
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                char c = lineTiles[y].charAt(x);  //for each character read in this file we call addLevelEntity
                int pos = x + y * WIDTH;
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
                                                new MalusSlow(x, y, Sprite.powerup_slow_ice));

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
                    case 'u':
                        LayeredEntity layer7 = new LayeredEntity(x, y, 
                                                new GrassTile(x ,y, Sprite.ice), 
                                                    new BrickTile(x ,y, Sprite.brickice));
                        layer7.addBeforeTop(new PowerupNotSlip(x, y, Sprite.powerup_not_slip));				
                        entities[pos] = layer7;
                        break;
                    case 'w': //gestione portale
                        LayeredEntity layer5= new LayeredEntity(x, y,
                                               new GrassTile (x,y, Sprite.ice),
                                                   new BrickTile(x,y, Sprite.brickice));
                        layer5.addBeforeTop(new PortalTile(x,y, this.board, Sprite.portal));
                        entities[pos] = layer5;
                        break;
                    case 'z':
                        entities[pos] = new IntactState(x, y, Sprite.grass);
                        break;
                    case '1':
                        board.addMob(new Snorunt(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, board)); 
                        entities[pos] = new GrassTile(x, y, Sprite.ice);
                        break;
                    case '2':
                        board.addMob(new Glalie(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, board)); 
                        entities[pos] = new GrassTile(x, y, Sprite.ice);
                        break;
                    case '3':
                        board.addMob(new Darkrai(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, board)); 
                        entities[pos] = new GrassTile(x, y, Sprite.ice);
                        break;
                    default: 
                        entities[pos] = new GrassTile(x, y, Sprite.ice);
                        break;
                }
            }
        }
        return entities;
    }
}