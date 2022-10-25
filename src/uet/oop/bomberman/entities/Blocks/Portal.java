package uet.oop.bomberman.entities.Blocks;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Portal extends Entity {
    public Portal(int x, int y) {
        super(x, y, Sprite.portal.getFxImage());
        setHidden(true);
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
        return "Portal";
    }

}
