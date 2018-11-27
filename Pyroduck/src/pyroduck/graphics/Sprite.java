package pyroduck.graphics;

/**
 * Represents the class which loads the image and manages the animation of each entity.
 * @author Corbisiero, Ferrara, La Femina
 */
public class Sprite {
    
    public final int SIZE = 32;
    private int x, y;
    public int[] pixels;
    protected final int realWidth = 32;
    protected final int realHeight = 32;
    private final SpriteSheet sheet;

    /*
    |--------------------------------------------------------------------------
    | Board sprites
    |--------------------------------------------------------------------------
     */
    
    public static Sprite grass = new Sprite(1, 0, SpriteSheet.tiles);
    public static Sprite brick = new Sprite(3, 0, SpriteSheet.tiles);
    public static Sprite wall = new Sprite(0, 0, SpriteSheet.tiles);
    /*ICE ARENA
    public static Sprite grass = new Sprite(9, 0, SpriteSheet.tiles);
    public static Sprite brick = new Sprite(11, 0, SpriteSheet.tiles);
    public static Sprite wall = new Sprite(7, 0, SpriteSheet.tiles);
    */

    /*
    |--------------------------------------------------------------------------
    | Player Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite player_up = new Sprite(0, 2, SpriteSheet.tiles);
    public static Sprite player_down = new Sprite(0, 1, SpriteSheet.tiles);
    public static Sprite player_left = new Sprite(0, 3, SpriteSheet.tiles);
    public static Sprite player_right = new Sprite(0, 4, SpriteSheet.tiles);

    public static Sprite player_up_1 = new Sprite(1, 2, SpriteSheet.tiles);
    public static Sprite player_up_2 = new Sprite(2, 2, SpriteSheet.tiles);

    public static Sprite player_down_1 = new Sprite(1, 1, SpriteSheet.tiles);
    public static Sprite player_down_2 = new Sprite(2, 1, SpriteSheet.tiles);

    public static Sprite player_left_1 = new Sprite(1, 3, SpriteSheet.tiles);
    public static Sprite player_left_2 = new Sprite(2, 3, SpriteSheet.tiles);

    public static Sprite player_right_1 = new Sprite(1, 4, SpriteSheet.tiles);
    public static Sprite player_right_2 = new Sprite(2, 4, SpriteSheet.tiles);

    public static Sprite player_dead1 = new Sprite(3, 2, SpriteSheet.tiles);
    public static Sprite player_dead2 = new Sprite(3, 3, SpriteSheet.tiles);
    public static Sprite player_dead3 = new Sprite(3, 4, SpriteSheet.tiles);

    /*
    |--------------------------------------------------------------------------
    | Mobs
    |--------------------------------------------------------------------------
     */
    //BALLOM
//    public static Sprite balloom_left1 = new Sprite(16, 9, 0, SpriteSheet.tiles, 16, 16);
//    public static Sprite balloom_left2 = new Sprite(16, 9, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite balloom_left3 = new Sprite(16, 9, 2, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite balloom_right1 = new Sprite(16, 10, 0, SpriteSheet.tiles, 16, 16);
//    public static Sprite balloom_right2 = new Sprite(16, 10, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite balloom_right3 = new Sprite(16, 10, 2, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite balloom_dead = new Sprite(16, 9, 3, SpriteSheet.tiles, 16, 16);
//
//    //ONEAL
//    public static Sprite oneal_left1 = new Sprite(16, 11, 0, SpriteSheet.tiles, 16, 16);
//    public static Sprite oneal_left2 = new Sprite(16, 11, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite oneal_left3 = new Sprite(16, 11, 2, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite oneal_right1 = new Sprite(16, 12, 0, SpriteSheet.tiles, 16, 16);
//    public static Sprite oneal_right2 = new Sprite(16, 12, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite oneal_right3 = new Sprite(16, 12, 2, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite oneal_dead = new Sprite(16, 11, 3, SpriteSheet.tiles, 16, 16);
//
//    //Doll
//    public static Sprite doll_left1 = new Sprite(16, 13, 0, SpriteSheet.tiles, 16, 16);
//    public static Sprite doll_left2 = new Sprite(16, 13, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite doll_left3 = new Sprite(16, 13, 2, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite doll_right1 = new Sprite(16, 14, 0, SpriteSheet.tiles, 16, 16);
//    public static Sprite doll_right2 = new Sprite(16, 14, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite doll_right3 = new Sprite(16, 14, 2, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite doll_dead = new Sprite(16, 13, 3, SpriteSheet.tiles, 16, 16);
//
//    //Minvo
//    public static Sprite minvo_left1 = new Sprite(16, 8, 5, SpriteSheet.tiles, 16, 16);
//    public static Sprite minvo_left2 = new Sprite(16, 8, 6, SpriteSheet.tiles, 16, 16);
//    public static Sprite minvo_left3 = new Sprite(16, 8, 7, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite minvo_right1 = new Sprite(16, 9, 5, SpriteSheet.tiles, 16, 16);
//    public static Sprite minvo_right2 = new Sprite(16, 9, 6, SpriteSheet.tiles, 16, 16);
//    public static Sprite minvo_right3 = new Sprite(16, 9, 7, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite minvo_dead = new Sprite(16, 8, 8, SpriteSheet.tiles, 16, 16);
//
//    //Kondoria
//    public static Sprite kondoria_left1 = new Sprite(16, 10, 5, SpriteSheet.tiles, 16, 16);
//    public static Sprite kondoria_left2 = new Sprite(16, 10, 6, SpriteSheet.tiles, 16, 16);
//    public static Sprite kondoria_left3 = new Sprite(16, 10, 7, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite kondoria_right1 = new Sprite(16, 11, 5, SpriteSheet.tiles, 16, 16);
//    public static Sprite kondoria_right2 = new Sprite(16, 11, 6, SpriteSheet.tiles, 16, 16);
//    public static Sprite kondoria_right3 = new Sprite(16, 11, 7, SpriteSheet.tiles, 16, 16);
//
//    public static Sprite kondoria_dead = new Sprite(16, 10, 8, SpriteSheet.tiles, 16, 16);

    //ALL
    public static Sprite mob_dead1 = new Sprite(15, 0, SpriteSheet.tiles);
    public static Sprite mob_dead2 = new Sprite(15, 1, SpriteSheet.tiles);
    public static Sprite mob_dead3 = new Sprite(15, 2, SpriteSheet.tiles);

    /*
    |--------------------------------------------------------------------------
    | Bomb Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite bomb = new Sprite(3, 1, SpriteSheet.tiles);
    public static Sprite bomb_1 = new Sprite(4, 1, SpriteSheet.tiles);
    public static Sprite bomb_2 = new Sprite(5, 1, SpriteSheet.tiles);
    
    /*
    |--------------------------------------------------------------------------
    | Explosion Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite bomb_exploded = new Sprite(12, 1, SpriteSheet.tiles);
    public static Sprite bomb_exploded1 = new Sprite(12, 2, SpriteSheet.tiles);
    public static Sprite bomb_exploded2 = new Sprite(12, 3, SpriteSheet.tiles);

    public static Sprite explosion_vertical = new Sprite(6, 2, SpriteSheet.tiles);
    public static Sprite explosion_vertical1 = new Sprite(7, 2, SpriteSheet.tiles);
    public static Sprite explosion_vertical2 = new Sprite(8, 2, SpriteSheet.tiles);

    public static Sprite explosion_horizontal = new Sprite(10, 1, SpriteSheet.tiles);
    public static Sprite explosion_horizontal1 = new Sprite(10, 2, SpriteSheet.tiles);
    public static Sprite explosion_horizontal2 = new Sprite(10, 3, SpriteSheet.tiles);

    public static Sprite explosion_horizontal_left_last = new Sprite(9, 1, SpriteSheet.tiles);
    public static Sprite explosion_horizontal_left_last1 = new Sprite(9, 2, SpriteSheet.tiles);
    public static Sprite explosion_horizontal_left_last2 = new Sprite(9, 3, SpriteSheet.tiles);

    public static Sprite explosion_horizontal_right_last = new Sprite(11, 1, SpriteSheet.tiles);
    public static Sprite explosion_horizontal_right_last1 = new Sprite(11, 2, SpriteSheet.tiles);
    public static Sprite explosion_horizontal_right_last2 = new Sprite(11, 3, SpriteSheet.tiles);

    public static Sprite explosion_vertical_top_last = new Sprite(6, 1, SpriteSheet.tiles);
    public static Sprite explosion_vertical_top_last1 = new Sprite(7, 1, SpriteSheet.tiles);
    public static Sprite explosion_vertical_top_last2 = new Sprite(8, 1, SpriteSheet.tiles);

    public static Sprite explosion_vertical_down_last = new Sprite(6, 3, SpriteSheet.tiles);
    public static Sprite explosion_vertical_down_last1 = new Sprite(7, 3, SpriteSheet.tiles);
    public static Sprite explosion_vertical_down_last2 = new Sprite(8, 3, SpriteSheet.tiles);
    
    /*
    |--------------------------------------------------------------------------
    | Brick Explosion
    |--------------------------------------------------------------------------
     */
    public static Sprite brick_exploded = new Sprite(4, 0, SpriteSheet.tiles);
    public static Sprite brick_exploded1 = new Sprite(5, 0, SpriteSheet.tiles);
    public static Sprite brick_exploded2 = new Sprite(6, 0, SpriteSheet.tiles);
  
       /*
    |--------------------------------------------------------------------------
    | Powerup
    |--------------------------------------------------------------------------
     */
    
    public static Sprite powerup_bombs = new Sprite(4, 2, SpriteSheet.tiles);
    public static Sprite powerup_flames = new Sprite(4, 3, SpriteSheet.tiles);
    public static Sprite powerup_speed = new Sprite(5, 2, SpriteSheet.tiles);
    public static Sprite powerup_slow = new Sprite(3, 0, SpriteSheet.tiles);
    public static Sprite powerup_malus = new Sprite(4, 4, SpriteSheet.tiles);

    public static Sprite portal = new Sprite(0,4, SpriteSheet.tiles);
    /**
     * Creates an instance of Sheet, sets its parameters and calls the method to load the related image.
     * @param x column number of the sprite sheet.
     * @param y row number of the sprite sheet.
     * @param sheet sprite from which load the image.
     */
    public Sprite(int x, int y, SpriteSheet sheet) {
        pixels = new int[SIZE * SIZE];
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.sheet = sheet;
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
     * @param time duration of each animation.
     * @return the sprite animation between three elements changing the image after a certain time inteval.
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

    /**
     * Return the sprite animation between three elements changing the image after a certain time inteval.
     * @param x1 first sprite of the animation.
     * @param x2 last sprite of animation.
     * @param animate number used to manage the exchange of the state between animations.
     * @param time duration of each animation.
     * @return the sprite animation between three elements changing the image after a certain time inteval.
     */
    public static Sprite movingSprite(Sprite x1, Sprite x2, int animate, int time) {
        int diff = time / 2;
        return (animate % time > diff) ? x1 : x2; 
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
