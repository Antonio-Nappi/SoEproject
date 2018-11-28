package pyroduck.level;

import pyroduck.Board;
import pyroduck.entities.Entity;

public class ContextLevel {
    private FileLevel filelevel;
    
    public ContextLevel(FileLevel filelevel){
        this.filelevel = filelevel;
    }
    
    public Entity[] executeStrategy(Board board, String world){
        return filelevel.createEntities(board, world);
    }

    public FileLevel getFilelevel() {
        return filelevel;
    } 
}