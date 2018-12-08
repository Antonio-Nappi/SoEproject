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
    private final SpriteSheet sheet;

    /*
    |--------------------------------------------------------------------------
    | Board sprites
    |--------------------------------------------------------------------------
     */

    public static Sprite grass = new Sprite(1, 0, SpriteSheet.tiles);
    public static Sprite brick = new Sprite(3, 0, SpriteSheet.tiles);
    public static Sprite wall = new Sprite(0, 0, SpriteSheet.tiles);

    public static Sprite ice = new Sprite(9, 0, SpriteSheet.tiles);
    public static Sprite brickice = new Sprite(11, 0, SpriteSheet.tiles);
    public static Sprite wallice = new Sprite(7, 0, SpriteSheet.tiles);


    /*
    |--------------------------------------------------------------------------
    | Player Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite player_up = new Sprite(0, 2, SpriteSheet.tiles);
    public static Sprite player_down = new Sprite(0, 1, SpriteSheet.tiles);
<<<<<<< HEAD

=======
    //public static Sprite player_down = new Sprite(15, 2, SpriteSheet.tiles); ARTICUNO 
>>>>>>> parent of d675007... moving sprite position
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
<<<<<<< HEAD


=======
    
    
>>>>>>> parent of d675007... moving sprite position
    public static Sprite player_upi = new Sprite(0, 6, SpriteSheet.tiles);
    public static Sprite player_downi = new Sprite(0, 5, SpriteSheet.tiles);
    public static Sprite player_lefti = new Sprite(0, 7, SpriteSheet.tiles);
    public static Sprite player_righti = new Sprite(0, 8, SpriteSheet.tiles);

    public static Sprite player_up_1i = new Sprite(1, 6, SpriteSheet.tiles);
    public static Sprite player_up_2i = new Sprite(2, 6, SpriteSheet.tiles);

    public static Sprite player_down_1i = new Sprite(1, 5, SpriteSheet.tiles);
    public static Sprite player_down_2i = new Sprite(2, 5, SpriteSheet.tiles);

    public static Sprite player_left_1i = new Sprite(1, 7, SpriteSheet.tiles);
    public static Sprite player_left_2i = new Sprite(2, 7, SpriteSheet.tiles);
<<<<<<< HEAD

    public static Sprite player_right_1i = new Sprite(1, 8, SpriteSheet.tiles);
    public static Sprite player_right_2i = new Sprite(2, 8, SpriteSheet.tiles);

    public static Sprite player_dead1i = new Sprite(3, 6, SpriteSheet.tiles);
    public static Sprite player_dead2i = new Sprite(3, 7, SpriteSheet.tiles);
    public static Sprite player_dead3i = new Sprite(3, 8, SpriteSheet.tiles);


    //ARTICUNO & PSYDUCK
    public static Sprite articuno_up = new Sprite(16, 5, SpriteSheet.tiles);
    public static Sprite articuno_up_left = new Sprite(15, 5, SpriteSheet.tiles);
    public static Sprite articuno_up_right = new Sprite(17, 5, SpriteSheet.tiles);
    public static Sprite articuno_up_up1 = new Sprite(15, 4, SpriteSheet.tiles);
    public static Sprite articuno_up_up2 = new Sprite(16, 4, SpriteSheet.tiles);
    public static Sprite articuno_up_up3 = new Sprite(17, 4, SpriteSheet.tiles);

    public static Sprite articuno_up1 = new Sprite(19, 5, SpriteSheet.tiles);
    public static Sprite articuno_up1_left = new Sprite(18, 5, SpriteSheet.tiles);
    public static Sprite articuno_up1_right = new Sprite(20, 5, SpriteSheet.tiles);
    public static Sprite articuno_up1_up1 = new Sprite(18, 4, SpriteSheet.tiles);
    public static Sprite articuno_up1_up2 = new Sprite(19, 4, SpriteSheet.tiles);
    public static Sprite articuno_up1_up3 = new Sprite(20, 4, SpriteSheet.tiles);

    public static Sprite articuno_up2 = new Sprite(22, 5, SpriteSheet.tiles);
    public static Sprite articuno_up2_left = new Sprite(21, 5, SpriteSheet.tiles);
    public static Sprite articuno_up2_right = new Sprite(23, 5, SpriteSheet.tiles);
    public static Sprite articuno_up2_up1 = new Sprite(21, 4, SpriteSheet.tiles);
    public static Sprite articuno_up2_up2 = new Sprite(22, 4, SpriteSheet.tiles);
    public static Sprite articuno_up2_up3 = new Sprite(23, 4, SpriteSheet.tiles);



    /*
    |--------------------------------------------------------------------------
    | Mobs
    |--------------------------------------------------------------------------
     */
    public static Sprite golbat_up1 = new Sprite(6, 4, SpriteSheet.tiles);
    public static Sprite golbat_up2 = new Sprite(7, 4, SpriteSheet.tiles);
    public static Sprite golbat_up3 = new Sprite(8, 4, SpriteSheet.tiles);

    public static Sprite golbat_down1 = new Sprite(6, 7, SpriteSheet.tiles);
    public static Sprite golbat_down2 = new Sprite(7, 7, SpriteSheet.tiles);
    public static Sprite golbat_down3 = new Sprite(8, 7, SpriteSheet.tiles);

    public static Sprite golbat_left1 = new Sprite(6, 6, SpriteSheet.tiles);
    public static Sprite golbat_left2 = new Sprite(7, 6, SpriteSheet.tiles);
    public static Sprite golbat_left3 = new Sprite(8, 6, SpriteSheet.tiles);

    public static Sprite golbat_right1 = new Sprite(6, 5, SpriteSheet.tiles);
    public static Sprite golbat_right2 = new Sprite(7, 5, SpriteSheet.tiles);
    public static Sprite golbat_right3 = new Sprite(8, 5, SpriteSheet.tiles);

    public static Sprite golbat_dead = new Sprite(13, 2, SpriteSheet.tiles);

    public static Sprite machamp_up1 = new Sprite(9, 5, SpriteSheet.tiles);
    public static Sprite machamp_up2 = new Sprite(10, 5, SpriteSheet.tiles);
    public static Sprite machamp_up3 = new Sprite(11, 5, SpriteSheet.tiles);

=======

    public static Sprite player_right_1i = new Sprite(1, 8, SpriteSheet.tiles);
    public static Sprite player_right_2i = new Sprite(2, 8, SpriteSheet.tiles);

    public static Sprite player_dead1i = new Sprite(3, 6, SpriteSheet.tiles);
    public static Sprite player_dead2i = new Sprite(3, 7, SpriteSheet.tiles);
    public static Sprite player_dead3i = new Sprite(3, 8, SpriteSheet.tiles);
    
    
    //ARTICUNO & PSYDUCK
    public static Sprite articuno_up = new Sprite(15, 2, SpriteSheet.tiles);


    /*
    |--------------------------------------------------------------------------
    | Mobs
    |--------------------------------------------------------------------------
     */
    public static Sprite golbat_up1 = new Sprite(6, 4, SpriteSheet.tiles);
    public static Sprite golbat_up2 = new Sprite(7, 4, SpriteSheet.tiles);
    public static Sprite golbat_up3 = new Sprite(8, 4, SpriteSheet.tiles);
    
    public static Sprite golbat_down1 = new Sprite(6, 7, SpriteSheet.tiles);
    public static Sprite golbat_down2 = new Sprite(7, 7, SpriteSheet.tiles);
    public static Sprite golbat_down3 = new Sprite(8, 7, SpriteSheet.tiles);
    
    public static Sprite golbat_left1 = new Sprite(6, 6, SpriteSheet.tiles);
    public static Sprite golbat_left2 = new Sprite(7, 6, SpriteSheet.tiles);
    public static Sprite golbat_left3 = new Sprite(8, 6, SpriteSheet.tiles);

    public static Sprite golbat_right1 = new Sprite(6, 5, SpriteSheet.tiles);
    public static Sprite golbat_right2 = new Sprite(7, 5, SpriteSheet.tiles);
    public static Sprite golbat_right3 = new Sprite(8, 5, SpriteSheet.tiles);

    public static Sprite golbat_dead = new Sprite(13, 2, SpriteSheet.tiles);
    
    public static Sprite machamp_up1 = new Sprite(9, 5, SpriteSheet.tiles);
    public static Sprite machamp_up2 = new Sprite(10, 5, SpriteSheet.tiles);
    public static Sprite machamp_up3 = new Sprite(11, 5, SpriteSheet.tiles);
    
    public static Sprite machamp_down1 = new Sprite(9, 4, SpriteSheet.tiles);
    public static Sprite machamp_down2 = new Sprite(10, 4, SpriteSheet.tiles);
    public static Sprite machamp_down3 = new Sprite(11, 4, SpriteSheet.tiles);
    
    public static Sprite machamp_left1 = new Sprite(9, 6, SpriteSheet.tiles);
    public static Sprite machamp_left2 = new Sprite(10, 6, SpriteSheet.tiles);
    public static Sprite machamp_left3 = new Sprite(11, 6, SpriteSheet.tiles);

    public static Sprite machamp_right1 = new Sprite(9, 7, SpriteSheet.tiles);
    public static Sprite machamp_right2 = new Sprite(10, 7, SpriteSheet.tiles);
    public static Sprite machamp_right3 = new Sprite(11, 7, SpriteSheet.tiles);

    public static Sprite machamp_dead = new Sprite(13, 2, SpriteSheet.tiles);
    
    public static Sprite arbok_up1 = new Sprite(12, 4, SpriteSheet.tiles);
    public static Sprite arbok_up2 = new Sprite(13, 4, SpriteSheet.tiles);
    public static Sprite arbok_up3 = new Sprite(14, 4, SpriteSheet.tiles);
    
    public static Sprite arbok_down1 = new Sprite(12, 5, SpriteSheet.tiles);
    public static Sprite arbok_down2 = new Sprite(13, 5, SpriteSheet.tiles);
    public static Sprite arbok_down3 = new Sprite(14, 5, SpriteSheet.tiles);
    
    public static Sprite arbok_left1 = new Sprite(12, 6, SpriteSheet.tiles);
    public static Sprite arbok_left2 = new Sprite(13, 6, SpriteSheet.tiles);
    public static Sprite arbok_left3 = new Sprite(14, 6, SpriteSheet.tiles);

    public static Sprite arbok_right1 = new Sprite(12, 7, SpriteSheet.tiles);
    public static Sprite arbok_right2 = new Sprite(13, 7, SpriteSheet.tiles);
    public static Sprite arbok_right3 = new Sprite(14, 7, SpriteSheet.tiles);

    public static Sprite arbok_dead = new Sprite(13, 2, SpriteSheet.tiles);
    
    public static Sprite snorunt_up1 = new Sprite(6, 8, SpriteSheet.tiles);
    public static Sprite snorunt_up2 = new Sprite(7, 8, SpriteSheet.tiles);
    public static Sprite snorunt_up3 = new Sprite(8, 8, SpriteSheet.tiles);
    
    public static Sprite snorunt_down1 = new Sprite(6, 11, SpriteSheet.tiles);
    public static Sprite snorunt_down2 = new Sprite(7, 11, SpriteSheet.tiles);
    public static Sprite snorunt_down3 = new Sprite(8, 11, SpriteSheet.tiles);
    
    public static Sprite snorunt_left1 = new Sprite(6, 10, SpriteSheet.tiles);
    public static Sprite snorunt_left2 = new Sprite(7, 10, SpriteSheet.tiles);
    public static Sprite snorunt_left3 = new Sprite(8, 10, SpriteSheet.tiles);

    public static Sprite snorunt_right1 = new Sprite(6, 9, SpriteSheet.tiles);
    public static Sprite snorunt_right2 = new Sprite(7, 9, SpriteSheet.tiles);
    public static Sprite snorunt_right3 = new Sprite(8, 9, SpriteSheet.tiles);

    public static Sprite snorunt_dead = new Sprite(13, 2, SpriteSheet.tiles);

    public static Sprite glalie_up1 = new Sprite(9, 8, SpriteSheet.tiles);
    public static Sprite glalie_up2 = new Sprite(10, 8, SpriteSheet.tiles);
    public static Sprite glalie_up3 = new Sprite(11, 8, SpriteSheet.tiles);
    
    public static Sprite glalie_down1 = new Sprite(9, 11, SpriteSheet.tiles);
    public static Sprite glalie_down2 = new Sprite(10, 11, SpriteSheet.tiles);
    public static Sprite glalie_down3 = new Sprite(11, 11, SpriteSheet.tiles);
    
    public static Sprite glalie_left1 = new Sprite(9, 10, SpriteSheet.tiles);
    public static Sprite glalie_left2 = new Sprite(10, 10, SpriteSheet.tiles);
    public static Sprite glalie_left3 = new Sprite(11, 10, SpriteSheet.tiles);

    public static Sprite glalie_right1 = new Sprite(9, 9, SpriteSheet.tiles);
    public static Sprite glalie_right2 = new Sprite(10, 9, SpriteSheet.tiles);
    public static Sprite glalie_right3 = new Sprite(11, 9, SpriteSheet.tiles);

    public static Sprite glalie_dead = new Sprite(13, 2, SpriteSheet.tiles);
    
    public static Sprite darkrai_up1 = new Sprite(12, 8, SpriteSheet.tiles);
    public static Sprite darkrai_up2 = new Sprite(13, 8, SpriteSheet.tiles);
    public static Sprite darkrai_up3 = new Sprite(14, 8, SpriteSheet.tiles);
    
    public static Sprite darkrai_down1 = new Sprite(12, 11, SpriteSheet.tiles);
    public static Sprite darkrai_down2 = new Sprite(13, 11, SpriteSheet.tiles);
    public static Sprite darkrai_down3 = new Sprite(14, 11, SpriteSheet.tiles);
    
    public static Sprite darkrai_left1 = new Sprite(12, 10, SpriteSheet.tiles);
    public static Sprite darkrai_left2 = new Sprite(13, 10, SpriteSheet.tiles);
    public static Sprite darkrai_left3 = new Sprite(14, 10, SpriteSheet.tiles);

    public static Sprite darkrai_right1 = new Sprite(12, 9, SpriteSheet.tiles);
    public static Sprite darkrai_right2 = new Sprite(13, 9, SpriteSheet.tiles);
    public static Sprite darkrai_right3 = new Sprite(14, 9, SpriteSheet.tiles);

    public static Sprite darkrai_dead = new Sprite(13, 2, SpriteSheet.tiles);

    //ALL
    public static Sprite mob_dead1 = new Sprite(13, 1, SpriteSheet.tiles);
    public static Sprite mob_dead2 = new Sprite(13, 2, SpriteSheet.tiles);
    public static Sprite mob_dead3 = new Sprite(13, 3, SpriteSheet.tiles);
    
    public static Sprite icebroken_1 = new Sprite(12, 0, SpriteSheet.tiles);
    public static Sprite icebroken_2 = new Sprite(13, 0, SpriteSheet.tiles);
    public static Sprite icebroken_3 = new Sprite(14, 0, SpriteSheet.tiles);
    public static Sprite icebroken_4 = new Sprite(15, 0, SpriteSheet.tiles);

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
    public static Sprite powerup_life = new Sprite(5, 4, SpriteSheet.tiles);
    public static Sprite powerup_slow_ice = new Sprite(11, 0, SpriteSheet.tiles);
    public static Sprite powerup_not_slip = new Sprite(5,5,SpriteSheet.tiles);
    public static Sprite powerup_articuno = new Sprite(3, 5, SpriteSheet.tiles);
    public static Sprite portal = new Sprite(16, 0, SpriteSheet.tiles);
>>>>>>> parent of d675007... moving sprite position
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
