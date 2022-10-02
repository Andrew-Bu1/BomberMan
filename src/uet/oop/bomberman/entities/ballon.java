package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class ballon extends Entity {
    public ballon(int x, int y, Image img) {
        super(x, y, img);
    }

    public void update() {
        objectRender(direction);
        animate++;
        if (animate > 20) {
            animate = 0;
        }
    }

    @Override
    public void objectRender(int direction) {
        if (direction == left) {
            img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, animate, 18)
                    .getFxImage();

        } else if (direction == right) {
            img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, animate, 18)
                    .getFxImage();
        }
    }

}
