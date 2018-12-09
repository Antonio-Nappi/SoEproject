/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.entities.mob.enemy.graphic.Enemy;
import pyroduck.graphics.Sprite;

/**
 *
 * @author La Femina, Petruzzello
 */
public class MalusSlowIce extends Powerup {
    public static Sprite powerup_slow_ice = new Sprite(11, 0);

    public MalusSlowIce(int x, int y) {
        super(x, y,powerup_slow_ice);
    }

    @Override
    public boolean collide(Entity e) {
        if(e instanceof DirectionalExplosion)
            destroyed = true;
        if(e instanceof Player) {
            ((Player) e).addPowerup(this);
            remove();
            return true;
        }
        if(e instanceof Enemy){
            return true;
        }
        return false;
    }

    @Override
    public void setValues() {
        active = true;
        if(Game.getPlayerSpeed() >= 1.3)
            Game.decreasePlayerSpeed(0.3);
    }
}
