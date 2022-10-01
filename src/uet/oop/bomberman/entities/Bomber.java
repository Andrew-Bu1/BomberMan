package uet.oop.bomberman.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javafx.event.Event;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber extends Entity {
    private final int up = 2;
    private final int down = 3;
    private final int left = 0;
    private final int right = 1;

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        countSprite++;
        if (countSprite >= 12) {
            countSprite = 0;
        }
    }

    private void heroRender(int direction) {
        if (direction == up) {
            if (countSprite < 3) {
                img = Sprite.player_up.getFxImage();
            } else if (countSprite < 6) {
                img = Sprite.player_up_1.getFxImage();
            } else {
                img = Sprite.player_up_2.getFxImage();
            }
        } else if (direction == down) {
            if (countSprite < 3) {
                img = Sprite.player_down.getFxImage();
            } else if (countSprite < 6) {
                img = Sprite.player_down_1.getFxImage();
            } else {
                img = Sprite.player_down_2.getFxImage();
            }
        } else if (direction == left) {
            if (countSprite < 3) {
                img = Sprite.player_left.getFxImage();
            } else if (countSprite < 6) {
                img = Sprite.player_left_1.getFxImage();
            } else {
                img = Sprite.player_left_2.getFxImage();
            }
        } else if (direction == right) {
            if (countSprite < 3) {
                img = Sprite.player_right.getFxImage();
            } else if (countSprite < 6) {
                img = Sprite.player_right_1.getFxImage();
            } else {
                img = Sprite.player_right_2.getFxImage();
            }
        }
    }

    public void handleEvent(KeyEvent event) {
        int direction;
        switch (event.getCode()) {
            case W:
                direction = up;
                move(direction);
                heroRender(direction);
                break;
            case S:
                direction = down;
                move(direction);
                heroRender(direction);
                break;
            case A:
                direction = left;
                move(direction);
                heroRender(direction);
                break;
            case D:
                direction = right;
                move(direction);
                heroRender(direction);
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