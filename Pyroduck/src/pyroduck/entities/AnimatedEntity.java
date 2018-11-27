/*
 * THIS ABSTRACT CLASS EXTENDS "ENTITY" AND ADDS FEATURES TO ALL THE ANIMATED ENTITES
 */
package pyroduck.entities;

/**
 * Adds some features at the entities which have different animation.
 * It is used to manage all the animation for each animated entity.
 * animate can assume 1500 different values  so we can change the animation about every 50 milliseconds
 * @author Montefusco, Nappi
 * @version 1.0
 */
public abstract class AnimatedEntity extends Entity {

    protected int animate = 0;
    protected final int MAX_ANIMATE = 1499; 

    /**
     * Increase the animated variable in order to modify the animated related to entity.
     */
    protected void animate() {
        if(animate < MAX_ANIMATE)
            animate++; 
        else animate = 0; //reset animation
    }
}