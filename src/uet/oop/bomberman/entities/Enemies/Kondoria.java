package uet.oop.bomberman.entities.Enemies;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Kondoria extends Entity {
    private int time = 0;

    public Kondoria(int x, int y) {
        super(x, y, Sprite.kondoria_left1.getFxImage());
    }

    @Override
    public void update() {
        animateSprite();
        animate++;
        if (animate > 20) {
            animate = 0;
        }
        move();
        if (isDead) {
            time++;
            if (time == 40) {
                isOff = true;
            }
        }
    }

    @Override
    public void animateSprite() {
        if (!isDead) {
            if (direction == 0 || direction == 2) {
                img = Sprite.movingSprite(Sprite.kondoria_right1, Sprite.kondoria_left2,
                        Sprite.kondoria_left3,
                        animate, 18).getFxImage();
            } else if (direction == 1 || direction == 3) {
                img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2,
                        Sprite.oneal_left3,
                        animate, 18).getFxImage();
            }
        } else {
            img = Sprite.movingSprite(Sprite.kondoria_dead, Sprite.mob_dead2, Sprite.mob_dead3, animate, 18)
                    .getFxImage();
        }
    }

    @Override
    public void move() {

    }

    public String getName() {
        return "Kondoria";
    }

}
