package pyroduck.entities.tile;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.Sprite;
import pyroduck.graphics.SpriteSheet;

public class PortalTile extends Tile {

      public static Sprite portal = new Sprite(16, 0);

    public PortalTile(int x, int y) {
        super(x, y, portal);
    }

    @Override
    public boolean collide(Entity e) {
        if(e instanceof Player ) {
            if(!Board.getInstance().detectNoEnemies())
                    return false;
            if(e.getXTile() == getX() && e.getYTile() == getY()) {
                if(Board.getInstance().detectNoEnemies())
                    try{
                        Game.getInstance().pause();
                        Board.getInstance().nextLevel();
                    } catch (IOException ex){
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (PyroduckException ex) {
                    Logger.getLogger(PortalTile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return false;
        }
        return true;
    }
}