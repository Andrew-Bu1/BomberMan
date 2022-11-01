package uet.oop.bomberman.entities.StaticEntity.HiddenBlock;

import uet.oop.bomberman.graphics.Sprite;

public class Portal extends HiddenBlock {
    public Portal(int x, int y) {
        super(x, y, Sprite.portal.getFxImage());

    }

    public String getName() {
        return "Portal";
    }

}
