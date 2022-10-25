package uet.oop.bomberman.entities.Items;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class BombItem extends Entity {
    private int time = 0;

    public BombItem(int x, int y) {
        super(x, y, Sprite.powerup_bombs.getFxImage());
        setHidden(true);
    }

    @Override
    public void update() {
        if (isDead) {
            time++;
            if (time == 20) {
                isOff = true;
            }
        }
    }

    @Override
    public void animateSprite() {

    }

    @Override
    public void move() {

    }

    public String getName() {
        return "BombItem";
    }
}
