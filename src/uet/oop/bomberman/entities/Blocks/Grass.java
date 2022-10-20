package uet.oop.bomberman.entities.Blocks;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Grass extends Entity {

    public Grass(int x, int y) {
        super(x, y, Sprite.grass.getFxImage());
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
        return "Grass";
    }

}