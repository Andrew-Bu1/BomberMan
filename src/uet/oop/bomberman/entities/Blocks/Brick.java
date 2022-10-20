package uet.oop.bomberman.entities.Blocks;

//import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import uet.oop.bomberman.entities.Entity;

public class Brick extends Entity {
    private int time = 0;

    public Brick(int x, int y) {
        super(x, y, Sprite.brick.getFxImage());
    }

    @Override
    public void update() {

        animate++;
        if (animate > 20) {
            animate = 0;
        }
        if (isDead) {
            time++;
            if (time == 20) {
                isOff = true;
            }
        }
        animateSprite();
    }

    @Override
    public void animateSprite() {
        if (isDead) {
            img = Sprite.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2, animate,
                    18).getFxImage();
        }
    }

    @Override
    public void move() {

    }

    public String getName() {
        return "Brick";
    }

}