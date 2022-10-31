package uet.oop.bomberman.entities.StaticEntity.Items;

import uet.oop.bomberman.graphics.Sprite;

public class FlameItem extends Item {

    public FlameItem(int x, int y) {
        super(x, y, Sprite.powerup_flames.getFxImage());
    }

    public String getName() {
        return "FlameItem";
    }

}
