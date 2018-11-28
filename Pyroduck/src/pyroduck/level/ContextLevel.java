/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.level;

import pyroduck.Board;
import pyroduck.entities.Entity;

/**
 *
 * @author Alex
 */
public class ContextLevel {
    private FileLevel filelevel;
    
    public ContextLevel(FileLevel filelevel){
        this.filelevel = filelevel;
    }
    
    public Entity[] exectuteStrategy(Board board, String world){
        return filelevel.createEntities(board, world);
    }

    public FileLevel getFilelevel() {
        return filelevel;
    }
    
}
