package uet.oop.bomberman.entities.Items;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class FlameItem extends Entity {
    
    public FlameItem(int x, int y) {
        super(x, y, Sprite.powerup_flames.getFxImage());
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
        return "FlameItem";
    }

}
