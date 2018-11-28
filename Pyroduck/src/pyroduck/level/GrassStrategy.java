/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.level;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.*;
import pyroduck.entities.mob.*;
import pyroduck.entities.tile.*;
import pyroduck.entities.tile.destroyable.*;
import pyroduck.entities.tile.powerup.*;
import pyroduck.exceptions.LoadLevelException;
import pyroduck.graphics.*;
/**
 *
 * @author Alex
 */
public class GrassStrategy extends FileLevel{

    public GrassStrategy(String path, Board board) throws LoadLevelException {
        super(path, board);
    }

    @Override
    public Entity[] createEntities(Board board, String world) {
        Entity[] entities = new Entity[WIDTH*HEIGHT];//entity = player, mobs, powerups,..., also tile!!!
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                char c = lineTiles[y].charAt(x);  //for each character read in this file we call addLevelEntity
                int pos = x + y * WIDTH;
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
                        System.out.println("PLAYER AGGIUNTO");
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
        }
        return entities;
    }
}
    
