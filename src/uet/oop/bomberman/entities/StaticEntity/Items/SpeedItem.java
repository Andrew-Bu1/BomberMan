package uet.oop.bomberman.entities.StaticEntity.Items;

import uet.oop.bomberman.graphics.Sprite;

public class SpeedItem extends Item {
    public SpeedItem(int x, int y) {
        super(x, y, Sprite.powerup_speed.getFxImage());
    }

    public String getName() {
        return "SpeedItem";
    }

}
