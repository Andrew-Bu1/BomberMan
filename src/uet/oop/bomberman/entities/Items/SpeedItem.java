package uet.oop.bomberman.entities.Items;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class SpeedItem extends Entity {
    public SpeedItem(int x, int y) {
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

    public String getName() {
        return "SpeedItem";
    }

}
