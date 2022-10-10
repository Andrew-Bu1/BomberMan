package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class SpeedItem extends Entity {
    public SpeedItem(int x, int y, Image img) {
        super(x, y, Sprite.powerup_speed.getFxImage());
    }

    @Override
    public void update() {

    }

    @Override
    public void animateSprite() {

    }

    @Override
    public void move() {

    }
}
