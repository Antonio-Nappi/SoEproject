package pyroduck;

import java.io.Serializable;

/**
 *
 * @author Bini, Petruzzello
 */
public class PointsSerialize implements Serializable{
    
    private int points;
    private String name;
    private int lives;
    
    public PointsSerialize(String name){
        this.points = Board.getInstance().getPoints();
        this.name = name;
        this.lives = Board.getInstance().getFinalLives();
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