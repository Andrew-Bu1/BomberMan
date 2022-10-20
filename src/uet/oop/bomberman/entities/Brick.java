package uet.oop.bomberman.entities;

//import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Brick extends Entity {
    public Brick(int x, int y) {
        super(x, y, Sprite.brick.getFxImage());
    }

    @Override
    public void update() {
        if (isDead) {
            animate++;
            if (animate > 20) {
                animate = 0;
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

}
