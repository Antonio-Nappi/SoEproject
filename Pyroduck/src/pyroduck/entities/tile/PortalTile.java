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

public class PortalTile extends Tile {

    protected Board board;

    public PortalTile(int x, int y, Board board, Sprite sprite) {
            super(x, y, sprite);
            this.board = board;
    }

    @Override
    public boolean collide(Entity e) {
        if(e instanceof Player ) {
            if(!board.detectNoEnemies())
                    return false;
            if(e.getXTile() == getX() && e.getYTile() == getY()) {
                if(board.detectNoEnemies())
                    try{
                        Game.getInstance().pause();
                        board.nextLevel();
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