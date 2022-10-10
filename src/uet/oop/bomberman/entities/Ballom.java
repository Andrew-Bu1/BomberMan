package uet.oop.bomberman.entities;

//import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Ballom extends Entity {
    public Ballom(int x, int y) {
        super(x, y, Sprite.balloom_left1.getFxImage());
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
            img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, animate, 18)
                    .getFxImage();

        } else if (direction == right) {
            img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, animate, 18)
                    .getFxImage();
        }
    }

    @Override
    public void move(int direction) {

    }
}
