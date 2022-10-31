package uet.oop.bomberman.entities.StaticEntity.Blocks;

import uet.oop.bomberman.graphics.Sprite;

public class Portal extends Block {
    public Portal(int x, int y) {
        super(x, y, Sprite.portal.getFxImage());

    }

    public String getName() {
        return "Portal";
    }

}
