package uet.oop.bomberman.entities;

import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber extends Entity {
    private boolean pressUp, pressDown, pressLeft, pressRight;
    private boolean isAlive = true;
    private int speed = 2;
    public static boolean isMoving = false;
    private int direction; // left = 0, right = 1, up = 2, down = 3

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
        move();
        animateSprite();
        animate++;
        if (animate > 20) {
            animate = 0;
        }
    }

    @Override
    public void animateSprite() {
        if (direction == 2) {
            if (isMoving) {
                img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_up.getFxImage();
            }
        } else if (direction == 3) {
            if (isMoving) {
                img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_down.getFxImage();
            }
        } else if (direction == 0) {
            if (isMoving) {
                img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_left.getFxImage();
            }

        } else if (direction == 1) {
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
                direction = 2;
                break;
            case S:
                pressDown = true;
                direction = 3;
                break;
            case A:
                pressLeft = true;
                direction = 0;
                break;
            case D:
                pressRight = true;
                direction = 1;
                break;
            default:
                break;
        }
        isMoving = true;
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
        isMoving = false;
    }

    @Override
    public void move() {
        if (pressDown)
            y += speed;
        if (pressUp)
            y -= speed;
        if (pressLeft)
            x -= speed;
        if (pressRight)
            x += speed;
    }

}