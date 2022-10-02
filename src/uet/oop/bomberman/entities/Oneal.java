package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Oneal extends Entity {
    public Oneal(int x, int y, Image img) {
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
                img = Sprite.oneal_left1.getFxImage();
            } else if (countSprite < 8) {
                img = Sprite.oneal_left2.getFxImage();
            } else if (countSprite < 12) {
                img = Sprite.oneal_left3.getFxImage();
            }
        } else if (direction == right) {
            if (countSprite < 4) {
                img = Sprite.oneal_right1.getFxImage();
            } else if (countSprite < 8) {
                img = Sprite.oneal_right2.getFxImage();
            } else if (countSprite < 12) {
                img = Sprite.oneal_right3.getFxImage();
            }
        }
    }
}
