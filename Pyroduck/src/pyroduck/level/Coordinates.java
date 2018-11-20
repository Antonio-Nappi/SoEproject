package pyroduck.level;

import pyroduck.Game;

/**
 * Rappresenta la classe incaricata alla conversione tra pixel e celle.
 * @author Corbisiero, Ferrara, La Femina
 */
public class Coordinates {
    
    /**
     * Convert the pixel information in tile information.
     * @param i pixel to convert.
     * @return the integer converted.
     */
    public static int pixelToTile(double i) {
        return (int)(i / Game.TILES_SIZE);
    }

    /**
     * Convert the tile information in pixel information.
     * @param i tile to convert.
     * @return the integer converted.
     */
    public static int tileToPixel(int i) {
        return i * Game.TILES_SIZE;
    }

    /**
     * Convert the tile information in pixel information.
     * @param i tile to convert.
     * @return the integer converted.
     */
    public static int tileToPixel(double i) {
        return (int)(i * Game.TILES_SIZE);
    }	
}