package pyroduck.entities.mob.enemy;

import pyroduck.entities.mob.Player;

/**
 * Implements the movement of the low power enemies, that are the enemies that move randomly.
 * @author Bini, Petruzzello
 */
public class LowPower extends EnemyPower {

    /**
     * Return the movement direction calculates randomly.
     * @return the movement direction calculates randomly.
     */
    @Override
    public int calculateDirection() {
        return random.nextInt(4);
    }

    @Override
    public boolean isPlayerReferenceUpdatable() {
        return false;
    }

    @Override
    public void updateReferencePlayer(Player player) {
        throw new UnsupportedOperationException("Not supported");
    }
}