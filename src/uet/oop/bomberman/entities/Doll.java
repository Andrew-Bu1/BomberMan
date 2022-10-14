package uet.oop.bomberman.entities;

import uet.oop.bomberman.graphics.Sprite;

public class Doll extends Entity {
    public Doll(int x, int y) {
        super(x, y, Sprite.doll_left1.getFxImage());
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
        return "Doll";
    }
}
