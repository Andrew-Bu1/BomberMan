package uet.oop.bomberman.entities;

import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber extends Entity {
    public boolean pressUp, pressDown, pressLeft, pressRight;
    private boolean isAlive = true;
    private int speed = 5;
    public static boolean isMoving = false;

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void buffSpeed() {
        this.speed += 3;
    }

    public Bomber(int x, int y) {
        super(x, y, Sprite.player_right.getFxImage());
    }

    @Override
    public void update() {
        animateSprite();
    }

    @Override
    public void animateSprite() {
        if (direction == up) {
            if (isMoving) {
                img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_up.getFxImage();
            }
        } else if (direction == down) {
            if (isMoving) {
                img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_down.getFxImage();
            }
        } else if (direction == left) {
            if (isMoving) {
                img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_left.getFxImage();
            }

        } else if (direction == right) {
            if (isMoving) {
                img = Sprite
                        .movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_right.getFxImage();
            }

        }
    }

    public void pressKey(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                pressUp = true;
                break;
            case S:
                pressDown = true;
                break;
            case A:
                pressLeft = true;
                break;
            case D:
                pressRight = true;
                break;
            default:
                break;
        }
    }

    public void releaseKey(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                pressUp = false;
                break;
            case S:
                pressDown = false;
                break;
            case A:
                pressLeft = false;
                break;
            case D:
                pressRight = false;
                break;
            default:
                break;
        }
    }

    public void handleEvent(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                move(direction = up);
                break;
            case S:
                move(direction = down);
                break;
            case A:
                move(direction = left);
                break;
            case D:
                move(direction = right);
                break;
            default:
                break;

        }
    }

    public void move(int direction) {
        if (direction == 0) {
            x -= speed;
        } else if (direction == 1) {
            x += speed;
        } else if (direction == 2) {
            y -= speed;
        } else if (direction == 3) {
            y += speed;
        }
        animate++;
        if (animate > 20) {
            animate = 0;
        }
    }

}