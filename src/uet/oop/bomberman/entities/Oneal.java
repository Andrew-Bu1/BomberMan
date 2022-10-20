package uet.oop.bomberman.entities;

import uet.oop.bomberman.graphics.Sprite;

public class Oneal extends Entity {
    public Oneal(int x, int y) {
        super(x, y, Sprite.oneal_left1.getFxImage());
    }

    public void update() {
        animateSprite();
        animate++;
        if (animate > 20) {
            animate = 0;
        }
    }

    @Override
    public void animateSprite() {
        if (!isDead) {
            if (direction == 0 || direction == 2) {
                img = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2,
                        Sprite.oneal_right3,
                        animate, 18).getFxImage();
            } else if (direction == 1 || direction == 3) {
                img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2,
                        Sprite.oneal_left3,
                        animate, 18).getFxImage();
            }
        } else {
            img = Sprite.movingSprite(Sprite.oneal_dead, Sprite.mob_dead2, Sprite.mob_dead3, animate, 18)
                    .getFxImage();
        }
    }

    @Override
    public void move() {

    }

}
