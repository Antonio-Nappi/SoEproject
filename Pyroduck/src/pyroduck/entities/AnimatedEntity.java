/*
 * THIS ABSTRACT CLASS EXTENDS "ENTITY" AND ADDS COMMON FEATURES OF ALL THE ANIMATED ENTITES
 */
package pyroduck.entities;

/**
 * Add some features at the entities that have different animation.
 * It is used to manage all the animation that each animated entity can have.
 * @author 
 * @version 1.0
 */
public abstract class AnimatedEntity extends Entity {

    protected int animate = 0;
    protected final int MAX_ANIMATE = 7500; //save the animation status and dont let this get too big

    /**
     * Increase the animate variable in order to modify the animated related to entity.
     */
    protected void animate() {
        if(animate < MAX_ANIMATE)
            animate++; 
        else animate = 0; //reset animation
    }
}