package uet.oop.bomberman.entities.StaticEntity.Items;

import uet.oop.bomberman.graphics.Sprite;

public class BombItem extends Item {

    public BombItem(int x, int y) {
        super(x, y, Sprite.powerup_bombs.getFxImage());
    }

    public String getName() {
        return "BombItem";
    }

}
