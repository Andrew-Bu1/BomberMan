package uet.oop.bomberman.entities;

import javafx.event.Event;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber extends Entity {

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {

    }

    public void handleEvent(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                move(2);
                super.setImg(Sprite.player_up.getFxImage());
                break;
            case S:
                move(3);
                super.setImg(Sprite.player_down.getFxImage());
                break;
            case A:
                move(0);
                super.setImg(Sprite.player_left.getFxImage());
                break;
            case D:
                move(1);
                super.setImg(Sprite.player_right.getFxImage());
                break;
        }

    }

    public void move(int direction) {
        // switch (direction) {
        // case 0:
        // x -= 5;
        // break;
        // case 1:
        // x += 5;
        // break;
        // case 2:
        // y -= 5;
        // break;
        // case 3:
        // y += 5;
        // break;
        // }
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