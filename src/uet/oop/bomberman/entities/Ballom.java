package uet.oop.bomberman.entities;

import java.util.Random;

//import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Ballom extends Entity {
    private Random random = new Random();

    public Ballom(int x, int y) {
        super(x, y, Sprite.balloom_left1.getFxImage());

    }

    public void update() {
        animateSprite();
        animate++;
        if (animate > 20) {
            animate = 0;
            moveRandom();
        }
        move();
    }

    @Override
    public void animateSprite() {
        switch (direction) {
            case 0:
            case 2:
                img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2,
                        Sprite.balloom_right3,
                        animate, 18).getFxImage();
                break;
            case 1:
            case 3:
                img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2,
                        Sprite.balloom_left3,
                        animate, 18).getFxImage();
                break;
        }
    }

    public void moveRandom() {
        direction = random.nextInt(4);
    }

    @Override
    public void move() {
        switch (direction) {
            case 0:
                y -= 1;
                break;
            case 1:
                y += 1;
                break;
            case 2:
                x -= 1;
                break;
            case 3:
                x += 1;
                break;
        }
    }

    public String getName() {
        return "Ballom";
    }
}
