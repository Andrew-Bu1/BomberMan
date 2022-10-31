package uet.oop.bomberman.entities.StaticEntity.Blocks;

import uet.oop.bomberman.graphics.Sprite;

public class Grass extends Block {

    public Grass(int x, int y) {
        super(x, y, Sprite.grass.getFxImage());
    }

    public String getName() {
        return "Grass";
    }

}
