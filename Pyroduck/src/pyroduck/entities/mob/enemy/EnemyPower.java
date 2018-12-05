package pyroduck.entities.mob.enemy;

import java.util.Random;
import pyroduck.entities.mob.Player;

/**
 * The abstract class describes the moviment of each type of enemies related to level of intelligence.
 * @author Bini, Petruzzello
 */
public abstract class EnemyPower {
   
	
    protected Random random = new Random(System.currentTimeMillis());

    /**
     * Return the movement direction of the enemies.
     * @return an integer that represent the direction of the moviment.
     */
    public abstract int calculateDirection();
    
    public abstract boolean isPlayerReferenceUpdatable();
    
    public abstract void updateReferencePlayer(Player player);
}