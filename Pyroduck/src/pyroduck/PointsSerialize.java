package pyroduck;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.exceptions.PyroduckException;

/**
 *
 * @author Bini, Petruzzello
 */
public class PointsSerialize implements Serializable{
    
    private int points;
    private String name;
    private int lives;
    
    public PointsSerialize(String name){
        try {
            this.points = Game.getInstance().getBoard().getPoints();
        } catch (PyroduckException ex) {
            Logger.getLogger(PointsSerialize.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.name = name;
        try {
            this.lives = Game.getInstance().getBoard().getLives();
        } catch (PyroduckException ex) {
            Logger.getLogger(PointsSerialize.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}