package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class ballon extends Entity {
    public ballon(int x, int y, Image img) {
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
        if (direction == left) {
            if (countSprite < 4) {
                img = Sprite.balloom_left1.getFxImage();
            } else if (countSprite < 8) {
                img = Sprite.balloom_left2.getFxImage();
            } else if (countSprite < 12) {
                img = Sprite.balloom_left3.getFxImage();
            }
        } else if (direction == right) {
            if (countSprite < 4) {
                img = Sprite.balloom_right1.getFxImage();
            } else if (countSprite < 8) {
                img = Sprite.balloom_right2.getFxImage();
            } else if (countSprite < 12) {
                img = Sprite.balloom_right3.getFxImage();
            }
        }
    }

}
