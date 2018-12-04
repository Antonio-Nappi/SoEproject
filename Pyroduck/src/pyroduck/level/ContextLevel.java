package pyroduck.level;

import pyroduck.Board;
import pyroduck.entities.Entity;

public class ContextLevel {
    private final FileLevel filelevel;
    
    public ContextLevel(FileLevel filelevel){
        this.filelevel = filelevel;
    }

    public Entity[] executeStrategy(Board board){
        return filelevel.createEntities(board);
    }

    public FileLevel getFilelevel() {
        return filelevel;
    } 
}