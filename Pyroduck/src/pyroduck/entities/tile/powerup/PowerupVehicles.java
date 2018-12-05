/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Gerry
 */
public class PowerupVehicles extends Powerup{

    public PowerupVehicles(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void setValues() {
        Game.setPlayerSpeed(1.3);
        Game.setBombRadius(1);
        Game.setBombRate(1);
    }
    
    
}
