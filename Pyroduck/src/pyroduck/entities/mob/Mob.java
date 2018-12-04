package pyroduck.entities.mob;

import pyroduck.Board;
import pyroduck.entities.AnimatedEntity;
import pyroduck.graphics.Screen;

/**
 * Represent the abstract class of each movible entities in the map.
 * Is used to manage the behavior of the entities calculating where they can move and direct the movement.
 * @author Montefusco, Nappi
 * @version 1.0
 */
public abstract class Mob extends AnimatedEntity {
	
    protected Board board;
    protected int direction = -1;
    protected boolean alive = true;
    protected boolean moving = false;
    public int timeAfter = 80;

    /**
     * Creates an object of Mob.
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
     * Allows to update the state of mob checking if something is something is changed.
     */
    @Override
    public abstract void update();

    /**
     * The implementation of this method invokes the screen's method to print the entity on the screen.
     * @param screen screen on which the print is called.
     */
    @Override
    public abstract void render(Screen screen);

    /**
     * The implementation of this method checks if the mob intends to move and calculate the next coordinates of the mob.
     */
    protected abstract void calculateMove();

    /**
     * The implementation of this method manage the movement of the character considering the selected direction. 
     * @param xa horizontal coordinate in which the character must shift.
     * @param ya vertical coordinate in which the character must shift.
     */
    protected abstract void move(double xa, double ya);

    /**
     * The implementation of this method checks if the mob can move in an specific position.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @return true if the movement is right, false otherwise.
     */
    protected abstract boolean canMove(double x, double y);

    /**
     * Return the moving of the mob, true if it's moving and false otherwise.
     * @return the moving of the mob, true if it's moving and false otherwise.
     */
    public boolean isMoving() {
        return moving;
    }
    
    public boolean isAlive() {
        return alive;
    }

    /**
     * Returns the direction where the mob wants to move.
     * @return Returns the direction where the mob wants to move.
     */
    public int getDirection() {
        return direction;
    }	
    
    public abstract void kill();
	
    protected abstract void afterKill();
  
    protected double getXMessage() {
        return (x) + (sprite.SIZE / 2);
    }
	
    protected double getYMessage() {
        return (y) - (sprite.SIZE / 2);
    }
}