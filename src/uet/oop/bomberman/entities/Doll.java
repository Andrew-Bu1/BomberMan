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
        if (!isDead) {
            if (direction == 0 || direction == 2) {
                img = Sprite.movingSprite(Sprite.doll_right1, Sprite.doll_right2,
                        Sprite.doll_right3,
                        animate, 18).getFxImage();
            } else if (direction == 1 || direction == 3) {
                img = Sprite.movingSprite(Sprite.doll_left1, Sprite.doll_left2,
                        Sprite.doll_left3,
                        animate, 18).getFxImage();
            }
        } else {
            img = Sprite.movingSprite(Sprite.doll_dead, Sprite.mob_dead2, Sprite.mob_dead3, animate, 18)
                    .getFxImage();
        }
    }

    @Override
    public void move() {

    }

}
