package uet.oop.bomberman.entities;

import java.util.Random;

//import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Ballom extends Entity {
    private Random random = new Random();

    public Ballom(int x, int y) {
        super(x, y, Sprite.balloom_left1.getFxImage());
        direction = random.nextInt(4);
    }

    public void update() {
        animateSprite();
        animate++;
        if (animate > 20) {
            animate = 0;
        }
        move();
    }

    @Override
    public void animateSprite() {
        if (isAlive) {
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

}
