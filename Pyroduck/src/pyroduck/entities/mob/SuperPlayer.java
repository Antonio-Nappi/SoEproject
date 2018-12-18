package pyroduck.entities.mob;

import pyroduck.*;
import pyroduck.entities.tile.powerup.Powerup;
import pyroduck.graphics.*;
import pyroduck.bomb.Missile;
import pyroduck.level.Coordinates;

/**
 *
 * @author
 */
public class SuperPlayer extends Player {

    private GraphicalExtensionSuperplayer graphicalExtensionSP = null;

    /**
     * 
     * @param player instance of the player at which apply the power up.
     */
    public SuperPlayer(Player player) {
        super((int) player.getX(), (int) player.getY());
        this.input = player.input;
        this.lives = player.lives;
        this.done = false;   //It has just correct keyboard
    }

    @Override
    public void render(Screen screen) {
        super.render(screen);
        if (isAlive()) {
            graphicalExtensionSP.render(screen);
        }
    }

    @Override
    protected void calculateMove() {
        super.calculateMove();
        graphicalExtensionSP.calculateMove();
    }

    @Override
    protected void chooseSprite() {
        if (Game.getInstance().getSelected() == 0) {
            switch (direction) {
                case 0:
                    sprite = Sprite.articuno_up;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.articuno_up1, Sprite.articuno_up2, animate, 30);
                    }
                    break;
                case 1:
                    sprite = Sprite.articuno_right;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.articuno_right1, Sprite.articuno_right2, animate, 30);
                    }
                    break;
                case 2:
                    sprite = Sprite.articuno_down;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.articuno_down1, Sprite.articuno_down2, animate, 30);
                    }
                    break;
                case 3:
                    sprite = Sprite.articuno_left;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.articuno_left1, Sprite.articuno_left2, animate, 30);
                    }
                    break;
                default:
                    sprite = Sprite.articuno_down;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.articuno_down1, Sprite.articuno_down2, animate, 30);
                    }
                    break;
            }
        } else {
            switch (direction) {
                case 0:
                    sprite = Sprite.articunoi_up;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.articunoi_up1, Sprite.articunoi_up2, animate, 30);
                    }
                    break;
                case 1:
                    sprite = Sprite.articunoi_right;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.articunoi_right1, Sprite.articunoi_right2, animate, 30);
                    }
                    break;
                case 2:
                    sprite = Sprite.articunoi_down;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.articunoi_down1, Sprite.articunoi_down2, animate, 30);
                    }
                    break;
                case 3:
                    sprite = Sprite.articunoi_left;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.articunoi_left1, Sprite.articunoi_left2, animate, 30);
                    }
                    break;
                default:
                    sprite = Sprite.articunoi_down;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.articunoi_down1, Sprite.articunoi_down2, animate, 30);
                    }
                    break;
            }
        }
    }

    @Override
    protected void placeBomb(int x, int y) {
        Missile m = new Missile(x, y, direction);
        bombs.add(m);
    }

    @Override
    protected void detectPlaceBomb() {
        if (input.space && timeBetweenPutBombs < 0) {
            int xt = Coordinates.pixelToTile(x + sprite.getSize() / 2);
            int yt = Coordinates.pixelToTile((y + sprite.getSize() / 2) - sprite.getSize());
            placeBomb(xt, yt);
            timeBetweenPutBombs = 100;
        }
    }

    @Override
    public void addPowerup(Powerup p) {
    }

    @Override
    protected void correctKeyboard() {
        Board.getInstance().setInput();
        input = Board.getInstance().getInput();
    }

    public void setGraphicalExtension(SuperPlayer superPlayer) {
        this.graphicalExtensionSP = new GraphicalExtensionSuperplayer(superPlayer);
    }

    public int getAnimate() {
        return this.animate;
    }

    @Override
    public boolean isSuperPlayer() {
        return true;
    }
    @Override
    public void kill(){
        setChanged();
        notifyObservers();
    }
}