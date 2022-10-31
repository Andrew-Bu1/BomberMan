package uet.oop.bomberman.entities.StaticEntity.Blocks;

import uet.oop.bomberman.graphics.Sprite;

public class Wall extends Block {

    public Wall(int x, int y) {
        super(x, y, Sprite.wall.getFxImage());
    }

    public String getName() {
        return "Wall";
    }

}
