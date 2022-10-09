package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class SpeedItem extends Entity {
    public SpeedItem(int x, int y, Image img) {
        super(x, y, Sprite.powerup_speed.getFxImage());
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

    }

    @Override
    public void move(int direction) {

    }
}
