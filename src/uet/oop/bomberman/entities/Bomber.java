package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber extends Entity {
    private int speed = 5;

    public void buffSpeed() {
        this.speed += 3;
    }

    public Bomber(int x, int y) {
        super(x, y, Sprite.player_right.getFxImage());
    }

    @Override
    public void update() {
        objectRender(direction);
    }

    @Override
    public void objectRender(int direction) {
        if (direction == up) {
            img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, animate, 18)
                    .getFxImage();
        } else if (direction == down) {
            img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, animate, 18)
                    .getFxImage();
        } else if (direction == left) {
            img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, animate, 18)
                    .getFxImage();
        } else if (direction == right) {
            img = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, animate, 18)
                    .getFxImage();
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
            case SPACE:
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