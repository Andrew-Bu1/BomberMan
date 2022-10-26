package uet.oop.bomberman.entities.Enemies;

import java.util.Random;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.menu;

public class Ballom extends Entity {
    private Random random = new Random();
    private int time = 0;

    public Ballom(int x, int y) {
        super(x, y, Sprite.balloom_left1.getFxImage());
        direction = random.nextInt(4);
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
                img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2,
                        Sprite.balloom_right3,
                        animate, 18).getFxImage();
            } else if (direction == 1 || direction == 3) {
                img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2,
                        Sprite.balloom_left3,
                        animate, 18).getFxImage();
            }
        } else {
            img = Sprite.movingSprite(Sprite.balloom_dead, Sprite.mob_dead2, Sprite.mob_dead3, animate, 18)
                    .getFxImage();
        }
    }

    @Override
    public void move() {
        int y1, x1;
        switch (direction) {
            case 0:
                y1 = y - 1;
                if (!checkStaticObject(x, y1)) {
                    y = y1;
                } else {
                    direction = random.nextInt(4);
                }
                break;
            case 1:
                y1 = y + 1;
                if (!checkStaticObject(x, y1)) {
                    y = y1;
                } else {
                    direction = random.nextInt(4);
                }
                break;
            case 2:
                x1 = x - 1;
                if (!checkStaticObject(x1, y)) {
                    x = x1;
                } else {
                    direction = random.nextInt(4);
                }
                break;
            case 3:
                x1 = x + 1;
                if (!checkStaticObject(x1, y)) {
                    x = x1;
                } else {
                    direction = random.nextInt(4);
                }
                break;
        }
    }

    public String getName() {
        return "Ballom";
    }

}
