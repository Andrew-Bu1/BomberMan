package uet.oop.bomberman.entities;

//import javafx.scene.image.Image;
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
        if (direction == left) {
            img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, animate, 18)
                    .getFxImage();

        } else if (direction == right) {
            img = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3, animate, 18)
                    .getFxImage();
        }
    }

    @Override
    public void move() {

    }
}
