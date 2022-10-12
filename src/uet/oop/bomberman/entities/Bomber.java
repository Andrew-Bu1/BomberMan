package uet.oop.bomberman.entities;

import uet.oop.bomberman.graphics.Sprite;
import javafx.scene.input.KeyEvent;
import static uet.oop.bomberman.BombermanGame.input;

public class Bomber extends Entity {
    private boolean isAlive = true;
    private int speed = 2;
    private int direction; // left = 0, right = 1, up = 2, down = 3

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bomber(int x, int y) {
        super(x, y, Sprite.player_right.getFxImage());
    }

    @Override
    public void update() {
        move();
        animateSprite();
    }

    public void handleEvent(KeyEvent e) {
        if (input.isPress()) {
            input.pressKey(e);
            input.setMoving(true);
        } else {
            input.releaseKey(e);
            input.setMoving(false);
        }
    }

    @Override
    public void animateSprite() {
        if (direction == up) {
            if (input.isMoving() && input.isPress()) {
                img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_up.getFxImage();
            }
        } else if (direction == down) {
            if (input.isMoving() && input.isPress()) {
                img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_down.getFxImage();
            }
        } else if (direction == left) {
            if (input.isMoving() && input.isPress()) {
                img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_left.getFxImage();
            }

        } else if (direction == right) {
            if (input.isMoving() && input.isPress()) {
                img = Sprite
                        .movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_right.getFxImage();
            }
        }
        animate++;
        if (animate > 20) {
            animate = 0;
        }
    }

    @Override
    public void move() {
        if (input.isPressDown()) {
            direction = down;
            y += speed;
        }
        if (input.isPressUp()) {
            direction = up;
            y -= speed;
        }
        if (input.isPressLeft()) {
            direction = left;
            x -= speed;
        }
        if (input.isPressRight()) {
            direction = right;
            x += speed;
        }
    }

}