package pyroduck.entities.mob.enemy;

import pyroduck.entities.mob.Player;

public class MediumPower extends EnemyPower {
    Player player;
    Enemy e;

    public MediumPower(Player player, Enemy e) {
        this.player = player;
        this.e = e;
    }

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

    protected int calculateColDirection() {
        if(player.getXTile() < e.getXTile())
            return 3;
        else if(player.getXTile() > e.getXTile())
            return 1;
        return -1;
    }

    protected int calculateRowDirection() {
        if(player.getYTile() < e.getYTile())
            return 0;
        else if(player.getYTile() > e.getYTile())
            return 2;
        return -1;
    }
}