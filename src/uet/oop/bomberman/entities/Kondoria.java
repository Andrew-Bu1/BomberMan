package uet.oop.bomberman.entities;

import uet.oop.bomberman.graphics.Sprite;

public class Kondoria extends Entity {
    public Kondoria(int x, int y) {
        super(x, y, Sprite.kondoria_left1.getFxImage());
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
        return "Kondoria";
    }
}
