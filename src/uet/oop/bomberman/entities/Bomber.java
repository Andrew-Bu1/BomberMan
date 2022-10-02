package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber extends Entity {
    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        objectRender(direction);
        animate++;
        if (animate > 20) {
            animate = 0;
        }
    }

    @Override
    public void objectRender(int direction) {
        if (direction == up) {
            img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, animate, 18)
                    .getFxImage();
            // if (countSprite < 4) {
            // img = Sprite.player_up.getFxImage();
            // } else if (countSprite < 18) {
            // img = Sprite.player_up_1.getFxImage();
            // } else if (countSprite < 18) {
            // img = Sprite.player_up_2.getFxImage();
            // }
        } else if (direction == down) {
            img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, animate, 18)
                    .getFxImage();
            // if (countSprite < 4) {
            // img = Sprite.player_down.getFxImage();
            // } else if (countSprite < 18) {
            // img = Sprite.player_down_1.getFxImage();
            // } else if (countSprite < 18) {
            // img = Sprite.player_down_2.getFxImage();
            // }
        } else if (direction == left) {
            img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, animate, 18)
                    .getFxImage();
            // if (countSprite < 4) {
            // img = Sprite.player_left.getFxImage();
            // } else if (countSprite < 18) {
            // img = Sprite.player_left_1.getFxImage();
            // } else if (countSprite < 18) {
            // img = Sprite.player_left_2.getFxImage();
            // }
        } else if (direction == right) {
            img = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, animate, 18)
                    .getFxImage();
            // if (countSprite < 4) {
            // img = Sprite.player_right.getFxImage();
            // } else if (countSprite < 18) {
            // img = Sprite.player_right_1.getFxImage();
            // } else if (countSprite < 18) {
            // img = Sprite.player_right_2.getFxImage();
            // }
        }
    }

    public void handleEvent(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                direction = up;
                move(direction);
                break;
            case S:
                direction = down;
                move(direction);

                break;
            case A:
                direction = left;
                move(direction);
                break;
            case D:
                direction = right;
                move(direction);
                break;
            default:
                break;
        }
    }

    public void move(int direction) {
        if (direction == 0) {
            x -= 5;
        } else if (direction == 1) {
            x += 5;
        } else if (direction == 2) {
            y -= 5;
        } else if (direction == 3) {
            y += 5;
        }
    }

}