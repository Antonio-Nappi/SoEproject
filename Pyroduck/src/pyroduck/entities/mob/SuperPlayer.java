package pyroduck.entities.mob;

import pyroduck.*;
import pyroduck.entities.tile.powerup.Powerup;
import pyroduck.graphics.*;
import pyroduck.bomb.Missile;

/**
 *
 * @author
 */
public class SuperPlayer extends Player {

    private GraphicalExtensionSuperplayer graphicalExtensionSP = null;

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
                    sprite = Sprite.player_upi;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.player_up_1i, Sprite.player_up_2i, animate, 30);
                    }
                    break;
                case 1:
                    sprite = Sprite.player_righti;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.player_right_1i, Sprite.player_right_2i, animate, 30);
                    }
                    break;
                case 2:
                    sprite = Sprite.player_downi;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.player_down_1i, Sprite.player_down_2i, animate, 30);
                    }
                    break;
                case 3:
                    sprite = Sprite.player_lefti;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.player_left_1i, Sprite.player_left_2i, animate, 30);
                    }
                    break;
                default:
                    sprite = Sprite.player_righti;
                    if (moving) {
                        sprite = Sprite.movingSprite(Sprite.player_right_1i, Sprite.player_right_2i, animate, 30);
                    }
                    break;
            }
        }
    }

    @Override
    protected void placeBomb(int x, int y) {
        Missile m = new Missile(x, y - 1, direction);
        bombs.add(m);
    }

    @Override
    protected void detectPlaceBomb() {
        if (input.space && timeBetweenPutBombs < 0) {
            placeBomb((int) x + 16, (int) y);
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