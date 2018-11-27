package pyroduck.entities.mob.enemy;

public class LowPower extends EnemyPower {

    @Override
    public int calculateDirection() {
        return random.nextInt(4);
    }
}