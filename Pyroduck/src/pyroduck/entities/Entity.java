package pyroduck.entities;

import java.awt.Rectangle;
import static java.lang.Math.abs;
import java.util.Observable;
import pyroduck.Game;
import pyroduck.graphics.*;
import pyroduck.level.Coordinates;

/**
 * The abstract class represents the entities' backbone
 * Fixs the main behavior of each entity appearable on the map.
 * @author Montefusco, Nappi
 * @version 1.0
*/
public abstract class Entity extends Observable{

    protected double x, y;
    protected boolean removed = false;
    protected Sprite sprite;
    protected int realWidth = 32;     //set by each specific entity if it doesn't have a standard dimension (32x32 pixels)
    protected int realHeight = 32;  
    

    /**
    * Allows to update the state of the entity and it checks if something is changed
     */
    public abstract void update();

    /**
     * The implementation of this method invokes the screen's method to print the entity on screen.
     * @param screen screen on which the print is called.
     */
    public abstract void render(Screen screen);

    /**
     * Set the entity as to be removed.
     */
    public void remove() {
        removed = true;
    }

    /**
     * Checks if the entity must be removed.
     * @return true if the entity must be removed, false otherwise.
     */
    public boolean isRemoved() {
        return removed;
    }

    /**
     * The implementation of this method checks if two entities collide with each other.
     * @param e is the entity with which is checked the collision.
     * @return true if the entities can collide with each other, false otherwise.
     */
    public abstract boolean collide(Entity e);
    
    public boolean checkRealCollision(Entity e, double tune){
        
        int x0_rectOffset = (Game.TILES_SIZE - realWidth)/2;
        int y0_rectOffset = (Game.TILES_SIZE - realHeight)/2;
        int x0_rect = (int)this.getX() + x0_rectOffset;
        int y0_rect = (int)this.getY() + y0_rectOffset;
        Rectangle thisEntityRectangle = new Rectangle(x0_rect, y0_rect, realWidth, realHeight);
        
        int x0_EntityRectOffset = (Game.TILES_SIZE - e.realWidth)/2; 
        int y0_EntityRectOffset = (Game.TILES_SIZE - e.realHeight)/2;
        int x0_EntityRect = (int)e.getX() + x0_EntityRectOffset;
        int y0_EntityRect = (int)e.getY() + y0_EntityRectOffset;
        Rectangle entityCollideRectangle = new Rectangle(x0_EntityRect, y0_EntityRect, e.realWidth, e.realHeight);
        Rectangle intersection = thisEntityRectangle.intersection(entityCollideRectangle);
        //System.out.println("Width intesection: "+intersection.getWidth());
        //System.out.println("Width intesection: "+intersection.getHeight());
        //System.out.println((intersection.getWidth() * intersection.getHeight() ) / (realWidth * realHeight));
       
        if( (intersection.getWidth() * intersection.getHeight() ) / (realWidth * realHeight) >= tune)
            return true;
        else 
            return false;
    }
    
//    public boolean checkDistanceCollision(Entity e, double tune){
//        tune = Game.TILES_SIZE * (tune);
//        System.out.println("tune: "+tune);
//        System.out.println("this x: "+this.getX()*Game.TILES_SIZE);
//        System.out.println("this y: "+this.getY()*Game.TILES_SIZE);
//        System.out.println("e x: "+e.getX());
//        System.out.println("e y: "+e.getY());
//        System.out.println("diff X: "+abs(this.x*Game.TILES_SIZE - e.getX()));
//        System.out.println("diff Y: "+abs(this.y*Game.TILES_SIZE - e.getY()));
//        if(abs(this.x*Game.TILES_SIZE - e.getX()) < tune && abs(this.y*Game.TILES_SIZE - e.getY())< tune)
//            return true;
//        return false;       
//    }

    /**
     * Returns the sprite of the entity.
     * @return the sprite related at the entity.
     */
    public Sprite getSprite() {
        return sprite;
    }
    
    /**
     * Returns the <b>x</b> coordinate of the entity on the screen.
     * @return the <b>x</b> coordinate of the entity on the screen.
     */
    public double getX() {
        return x;
    }

    /**
     * Return the <b>y</b> coordinate of the entity on the screen.
     * @return <b>y</b> coordinate of the entity on the screen.
     */
    public double getY() {
        return y;
    }
    
    /**
     * 
     * @return 
     */
    public int getXTile() {
        return Coordinates.pixelToTile(x + 16); //plus half block for precision
    }
	
    /**
     * 
     * @return 
     */
    public int getYTile() {
        return Coordinates.pixelToTile(y - 16); //plus half block
    }
    
    public int getRealWidth(){
        return realWidth;
    }
    
    public int getRealHeight(){
        return realHeight;
    }
}