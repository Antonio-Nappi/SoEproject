/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.tile;

import pyroduck.entities.Entity;
import static pyroduck.entities.tile.GrassTile.grass;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Antonio
 */
public class IceTile extends Tile{
     public static Sprite ice = new Sprite(9, 0);
      /**
     * Constructor that create an object of this class.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param sprite related to the tile.
     */
    public IceTile(int x, int y) {
        super(x, y, ice);
    }

    /**
     * Return false 
     * Obviously for these entities the possibility of colliding is setted false because other entities can move on it.
     * @param e is the entity with which is checked the collision.
     * @return false.
     */
    @Override
    public boolean collide(Entity e) {
        return false;
    }
}
