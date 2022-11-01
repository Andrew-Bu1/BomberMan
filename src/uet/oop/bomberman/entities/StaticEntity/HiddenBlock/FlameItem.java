package uet.oop.bomberman.entities.StaticEntity.HiddenBlock;

import uet.oop.bomberman.graphics.Sprite;

public class FlameItem extends HiddenBlock {

    public FlameItem(int x, int y) {
        super(x, y, Sprite.powerup_flames.getFxImage());
    }

    public String getName() {
        return "FlameItem";
    }

}
