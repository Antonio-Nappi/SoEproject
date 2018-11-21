package pyroduck.entities.mob;

import pyroduck.Board;
import pyroduck.entities.AnimatedEntity;
import pyroduck.graphics.Screen;

/**
 * Represent the abstract class of each entities that is able to move in the map.
 * It is used to menage the behavior of these entities calculating where they can move and commanding the moviment.
 * @author Montefusco, Nappi
 * @version 1.0
 */
public abstract class Mob extends AnimatedEntity {
	
    protected Board board;
    protected int direction = -1;
    protected boolean alive = true;
    protected boolean moving = false;
    //public int timeAfter = 80;

    /**
     * Constructor that create an object of this class.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param board ...
     */
    public Mob(int x, int y, Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
    }

    /**
     * It allow to update the state of mob to check if it is change something.
     */
    @Override
    public abstract void update();

    /**
     * The implementation of this method must invoke the screen's method to print the entity on screen.
     * @param screen screen on which the print is called.
     */
    @Override
    public abstract void render(Screen screen);

    /**
     * The implementation of this method must check if the mobs intend to move and calculate which are the next coordinates of the mob.
     */
    protected abstract void calculateMove();

    /**
     * The implementation of this method command the character moviment depending on direction selected. 
     * @param xa horizontal coordinate in which the character must shift.
     * @param ya vertical coordinate in which the character must shift.
     */
    protected abstract void move(double xa, double ya);

    /**
     * The implementation of this method check if the mob can move in the specific coordinate.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @return true if the moviment is right, false otherwise.
     */
    protected abstract boolean canMove(double x, double y);

    /**
     * Say if the mob is moving.
     * @return true if the mob is moving, false otherwise.
     */
    public boolean isMoving() {
        return moving;
    }

    /**
     * Communicate the direction in which the mob want to move.
     * @return direction of moviment.
     */
    public int getDirection() {
        return direction;
    }	
}