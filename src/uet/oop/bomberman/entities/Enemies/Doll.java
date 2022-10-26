package uet.oop.bomberman.entities.Enemies;

import static uet.oop.bomberman.BombermanGame.menu;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Doll extends Entity {
    private int time = 0;

    public Doll(int x, int y) {
        super(x, y, Sprite.doll_left1.getFxImage());
    }

    @Override
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

    public String getName() {
        return "Doll";
    }

}
