package pyroduck.entities.mob.enemy;

import pyroduck.entities.mob.enemy.graphic.Enemy;
import pyroduck.entities.mob.Player;

/**
 * Implements the moviment of the medium power enemies, that are the enemies that move toward the player.
 * @author Bini, Petruzzello
 */
public class MediumPower extends EnemyPower {
    Player player;
    Enemy e;

    /**
     * Creates an instance of MediumPower enemy.
     * @param player instance of the player toward which the enemy will move.
     * @param e instance of the enemy.
     */
    public MediumPower(Player player, Enemy e) {
        this.player = player;
        this.e = e;
    }

    /**
     * Return the movement direction of the enemy calculates in relation to the player position.
     * @return the movement direction of the enemy.
     */
    @Override
    public int calculateDirection() {
        if(player == null)
            return random.nextInt(4);
        int vertical = random.nextInt(2);
        if(vertical == 1) {
            int v = calculateRowDirection();
            if(v != -1)
                return v;
            else
                return calculateColDirection();
        } else {
            int h = calculateColDirection();
            if(h != -1)
                return h;
            else
                return calculateRowDirection();
        }
    }

    /**
     * Return the movement direction of the enemy on the horizontal axis, calculates in relation to the player position.
     * @return the movement direction of the enemy on the horizontal axis
     */
    protected int calculateColDirection() {
        if(player.getXTile() < e.getXTile())
            return 3;
        else if(player.getXTile() > e.getXTile())
            return 1;
        return -1;
    }

    /**
     * Return the movement direction of the enemy on the horizontal axis, calculates in relation to the player position.
     * @return the movement direction of the enemy on the horizontal axis.
     */
    protected int calculateRowDirection() {
        if(player.getYTile() < e.getYTile())
            return 0;
        else if(player.getYTile() > e.getYTile())
            return 2;
        return -1;
    }

    @Override
    public boolean isPlayerReferenceUpdatable() {
        return true;
    }
    
    @Override
    public void updateReferencePlayer(Player player){
        this.player = player;
    }
   
}