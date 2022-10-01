package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber extends Entity {
    private final int up = 2;
    private final int down = 3;
    private final int left = 0;
    private final int right = 1;
    private int direction;

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        objectRender(direction);
        countSprite++;
        if (countSprite > 16) {
            countSprite = 0;
        }
    }

    @Override
    public void objectRender(int direction) {
        if (direction == up) {
            if (countSprite < 4) {
                img = Sprite.player_up.getFxImage();
            } else if (countSprite < 8) {
                img = Sprite.player_up_1.getFxImage();
            } else if (countSprite < 12) {
                img = Sprite.player_up_2.getFxImage();
            }
        } else if (direction == down) {
            if (countSprite < 4) {
                img = Sprite.player_down.getFxImage();
            } else if (countSprite < 8) {
                img = Sprite.player_down_1.getFxImage();
            } else if (countSprite < 12) {
                img = Sprite.player_down_2.getFxImage();
            }
        } else if (direction == left) {
            if (countSprite < 4) {
                img = Sprite.player_left.getFxImage();
            } else if (countSprite < 8) {
                img = Sprite.player_left_1.getFxImage();
            } else if (countSprite < 12) {
                img = Sprite.player_left_2.getFxImage();
            }
        } else if (direction == right) {
            if (countSprite < 4) {
                img = Sprite.player_right.getFxImage();
            } else if (countSprite < 8) {
                img = Sprite.player_right_1.getFxImage();
            } else if (countSprite < 12) {
                img = Sprite.player_right_2.getFxImage();
            }
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