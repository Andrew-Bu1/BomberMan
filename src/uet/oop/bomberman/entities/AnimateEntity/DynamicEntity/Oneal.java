package uet.oop.bomberman.entities.AnimateEntity.DynamicEntity;

import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.menu;

public class Oneal extends DynamicEntity {
    private int time = 0;

    public Oneal(int x, int y) {
        super(x, y, Sprite.oneal_left1.getFxImage());
    }

    public void update() {
        if (menu.getGameState() == menu.getPlayState()) {
            animateSprite();
            animate++;
            if (animate > 20) {
                animate = 0;
            }
            move();
            if (isDead) {
                time++;
                if (time == 60) {
                    isOff = true;
                }
            }
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

    public String getName() {
        return "Oneal";
    }

}