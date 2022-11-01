package uet.oop.bomberman.entities.StaticEntity.HiddenBlock;

import uet.oop.bomberman.graphics.Sprite;

public class SpeedItem extends HiddenBlock {
    public SpeedItem(int x, int y) {
        super(x, y, Sprite.powerup_speed.getFxImage());
    }

    public String getName() {
        return "SpeedItem";
    }

}
