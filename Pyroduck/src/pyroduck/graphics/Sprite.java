package pyroduck.graphics;

/**
 * Represents the class which loads the image and manages the animation of each entity.
 * @author Corbisiero, Ferrara, La Femina
 */
public class Sprite {

    public final int SIZE = 32;
    private final int x;
    private final int y;
    public int[] pixels;
    private final SpriteSheet sheet = SpriteSheet.tiles;


   
    
    /**
     * Creates an instance of Sheet, sets its parameters and calls the method to load the related image.
     * @param x column number of the sprite sheet.
     * @param y row number of the sprite sheet.
     * @param sheet sprite from which load the image.
     */
    public Sprite(int x, int y) {
        pixels = new int[SIZE * SIZE];
        this.x = x * SIZE;
        this.y = y * SIZE;
        load();
    }
    

    /**
     * Loads each pixel of the image in the pixels array.
     */
    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                this.pixels[x + y * SIZE] = this.sheet.pixels[(x + this.x) + (y + this.y) * this.sheet.SIZE];
            }
        }
    }

    /*
    |--------------------------------------------------------------------------
    | Moving Sprites
    |--------------------------------------------------------------------------
     */
    /**
     * Return the sprite animation between three elements changing the image after a certain time inteval.
     * @param normal first sprite of the animation.
     * @param x1 second sprite of the animation.
     * @param x2 last sprite of animation.
     * @param animate number used to manage the exchange of the state between animations.
     * @param delta duration of each animation.
     * @return the sprite animation between three elements changing the image after a certain time inteval.
     */
    public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, int animate, int delta) {
        int timewindow = animate % delta;
        int interval = delta / 3;
        if(timewindow < interval) {
            return normal;
        }
        if(timewindow < interval * 2) {
            return x1;
        }
        return x2;
    }

    /**
     * Return the sprite animation between three elements changing the image after a certain time inteval.
     * @param x1 first sprite of the animation.
     * @param x2 last sprite of animation.
     * @param animate number used to manage the exchange of the state between animations.
     * @param delta duration of each animation.
     * @return the sprite animation between three elements changing the image after a certain time inteval.
     */
    public static Sprite movingSprite(Sprite x1, Sprite x2, int animate, int delta) {
        int interval = delta / 2;
        return (animate % delta > interval) ? x1 : x2;
    }

    /**
     * Return the size of sprite.
     * @return the size of sprite.
     */
    public int getSize() {
        return SIZE;
    }

    /**
     * Return the pixel related at an specific position.
     * @param i position of the pixel in the pixels array.
     * @return the pixel array related to the sprite image.
     */
    public int getPixel(int i) {
        return pixels[i];
    }
}