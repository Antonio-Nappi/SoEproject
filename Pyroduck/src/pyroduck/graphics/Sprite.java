/*
 * THIS CLASS LOAD ALL THE IMAGE NECESSARY TO THE GRAPHIC OF THE GAME AND STORE IT IN EACH SPECIFI
 */
package pyroduck.graphics;

/**
 * Represent the 
 * @author Corbisiero, Ferrara, La Femina
 */
public class Sprite {
    
    public final int SIZE = 32;
    private int x, y;
    public int[] pixels;
    protected int realWidth;
    protected int realHeight;
    private SpriteSheet sheet;

    /*
    |--------------------------------------------------------------------------
    | Board sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite grass = new Sprite(1, 0, SpriteSheet.tiles, 32, 32);
    public static Sprite brick = new Sprite(3, 0, SpriteSheet.tiles, 32, 32);
    public static Sprite wall = new Sprite(0, 0, SpriteSheet.tiles, 32, 32);

    /*
    |--------------------------------------------------------------------------
    | Player Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite player_up = new Sprite(0, 2, SpriteSheet.tiles, 32, 32);
    public static Sprite player_down = new Sprite(0, 1, SpriteSheet.tiles, 32, 32);
    public static Sprite player_left = new Sprite(0, 3, SpriteSheet.tiles, 32, 32);
    public static Sprite player_right = new Sprite(0, 4, SpriteSheet.tiles, 32, 32);

    public static Sprite player_up_1 = new Sprite(1, 2, SpriteSheet.tiles, 32, 32);
    public static Sprite player_up_2 = new Sprite(2, 2, SpriteSheet.tiles, 32, 32);

    public static Sprite player_down_1 = new Sprite(1, 1, SpriteSheet.tiles, 32, 32);
    public static Sprite player_down_2 = new Sprite(2, 1, SpriteSheet.tiles, 32, 32);

    public static Sprite player_left_1 = new Sprite(1, 3, SpriteSheet.tiles, 32, 32);
    public static Sprite player_left_2 = new Sprite(2, 3, SpriteSheet.tiles, 32 ,32);

    public static Sprite player_right_1 = new Sprite(1, 4, SpriteSheet.tiles, 32, 32);
    public static Sprite player_right_2 = new Sprite(2, 4, SpriteSheet.tiles, 32, 32);

    public static Sprite player_dead1 = new Sprite(3, 2, SpriteSheet.tiles, 32, 32);
    public static Sprite player_dead2 = new Sprite(3, 3, SpriteSheet.tiles, 32, 32);
    public static Sprite player_dead3 = new Sprite(3, 4, SpriteSheet.tiles, 32, 32);

    /*
    |--------------------------------------------------------------------------
    | Bomb Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite bomb = new Sprite(3, 1, SpriteSheet.tiles, 32, 32);
    public static Sprite bomb_1 = new Sprite(4, 1, SpriteSheet.tiles, 32, 32);
    public static Sprite bomb_2 = new Sprite(5, 1, SpriteSheet.tiles, 32, 32);
    /*
    |--------------------------------------------------------------------------
    | Explosion Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite bomb_exploded = new Sprite(3, 2, SpriteSheet.tiles, 32, 32);
    public static Sprite bomb_exploded1 = new Sprite(9, 2, SpriteSheet.tiles, 32, 32);
    public static Sprite bomb_exploded2 = new Sprite(9, 2, SpriteSheet.tiles, 32, 32);

    public static Sprite explosion_vertical = new Sprite(9, 1, SpriteSheet.tiles, 32, 32);
    public static Sprite explosion_vertical1 = new Sprite(9, 1, SpriteSheet.tiles, 32, 32);
    public static Sprite explosion_vertical2 = new Sprite(9, 1, SpriteSheet.tiles, 32, 32);

    public static Sprite explosion_horizontal = new Sprite(8, 2, SpriteSheet.tiles, 32, 32);
    public static Sprite explosion_horizontal1 = new Sprite(8, 2, SpriteSheet.tiles, 32, 32);
    public static Sprite explosion_horizontal2 = new Sprite(8, 2, SpriteSheet.tiles, 32, 32);

    public static Sprite explosion_horizontal_left_last = new Sprite(7, 2, SpriteSheet.tiles, 32, 32);
    public static Sprite explosion_horizontal_left_last1 = new Sprite(7, 2, SpriteSheet.tiles, 32, 32);
    public static Sprite explosion_horizontal_left_last2 = new Sprite(7, 2, SpriteSheet.tiles, 32, 32);

    public static Sprite explosion_horizontal_right_last = new Sprite(11, 2, SpriteSheet.tiles, 32, 32);
    public static Sprite explosion_horizontal_right_last1 = new Sprite(11, 2, SpriteSheet.tiles, 32, 32);
    public static Sprite explosion_horizontal_right_last2 = new Sprite(11, 2, SpriteSheet.tiles, 32, 32);

    public static Sprite explosion_vertical_top_last = new Sprite(9, 0, SpriteSheet.tiles, 32, 32);
    public static Sprite explosion_vertical_top_last1 = new Sprite(9, 0, SpriteSheet.tiles, 32, 32);
    public static Sprite explosion_vertical_top_last2 = new Sprite(9, 0, SpriteSheet.tiles, 32, 32);

    public static Sprite explosion_vertical_down_last = new Sprite(9, 4, SpriteSheet.tiles, 32, 32);
    public static Sprite explosion_vertical_down_last1 = new Sprite(9, 4, SpriteSheet.tiles, 32, 32);
    public static Sprite explosion_vertical_down_last2 = new Sprite(9, 4, SpriteSheet.tiles, 32, 32);

    public Sprite(int x, int y, SpriteSheet sheet, int rw, int rh) {
        pixels = new int[SIZE * SIZE];
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.sheet = sheet;
        this.realWidth = rw;
        this.realHeight = rh;
        load();
    }

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
    public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, int animate, int time) {
        int calc = animate % time;
        int diff = time / 3;
        if(calc < diff) {
            return normal;
        }
        if(calc < diff * 2) {
            return x1;
        }
        return x2;
    }

    public static Sprite movingSprite(Sprite x1, Sprite x2, int animate, int time) {
        int diff = time / 2;
        return (animate % time > diff) ? x1 : x2; 
    }

    public int getSize() {
        return SIZE;
    }

    public int[] getPixels() {
        return pixels;
    }

    public int getPixel(int i) {
        return pixels[i];
    }

    public int getRealWidth() {
        return realWidth;
    }

    public int getRealHeight() {
        return realHeight;
    }
}