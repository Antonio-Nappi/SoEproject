/*
 * THIS CLASS IS RESPONSABLE TO THE LOAD OF THE SPRITE-SHEET
 */
package pyroduck.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {

    private final String path;
    public final int SIZE;
    public int[] pixels;

    public static SpriteSheet tiles = new SpriteSheet("./resources/textures/Sheet32.png", 1024);

    public SpriteSheet(String path, int size) {
        this.path = path;
        this.SIZE = size;
        this.pixels = new int[SIZE * SIZE];
        load();
    }

    private void load() {
        File f = new File(path);
        try {
            BufferedImage image = ImageIO.read(f); 
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);  // getRGB write the information about pixels of the image into "pixels" passed as parameter
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}