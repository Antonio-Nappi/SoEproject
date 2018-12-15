package pyroduck.level;

import java.io.BufferedReader;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.enemy.graphic.*;
import pyroduck.entities.tile.*;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.entities.tile.powerup.*;
import pyroduck.graphics.Sprite;

/**
 *
 * @author 
 */
public class IceFileLevel extends FileLevel{

    public IceFileLevel(String path,BufferedReader in,int level) {
        super(path,in,level);
    }

    @Override
    public WallTile createWall(int x, int y) {
        return new WallTile(x, y, Sprite.wallice);
    }

    @Override
    public BrickTile createBrick(int x, int y) {
    return new BrickTile(x, y, Sprite.brickice);
    }

    @Override
    public GrassTile createGrass(int x, int y) {
        return new GrassTile(x, y, Sprite.ice);
    }

    @Override
    public Mob createFirstEnemy(int x, int y) {
        return new Snorunt(x, y);
    }

    @Override
    public Mob createSecondEnemy(int x, int y, int choose) {
    if(choose == 2)
        return new Glalie(x, y);
    return new Darkrai(x, y);
    }

    @Override
    public Powerup createPowerup(int x, int y) {
       return new MalusSlow(x, y, Sprite.brickice);
    }
}