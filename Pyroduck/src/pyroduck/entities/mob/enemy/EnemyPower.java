package pyroduck.entities.mob.enemy;

import java.util.Random;

public abstract class EnemyPower {
	
    protected Random random = new Random();

    public abstract int calculateDirection();
}