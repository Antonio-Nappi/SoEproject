package pyroduck.entities.tile;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.Player;
import pyroduck.graphics.Sprite;

public class PortalTile extends Tile {
    
    public PortalTile(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public boolean collide(Entity e) {
        if (e.isMob() && (((Mob) e).isPlayer())) {
            if (!Board.getInstance().detectNoEnemies()) {
                return false;
            }
            if (e.getXTile() == getX() && e.getYTile() == getY()) {
                if (Board.getInstance().detectNoEnemies()) {
                    //Message.setMessage("Congratulations! The level is now complete.");
                    try {
                        Game.getInstance().pause();
                        Board.getInstance().setPoints(1000);
                        Board.getInstance().nextLevel();
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return false;
        }
        return true;
    }
}