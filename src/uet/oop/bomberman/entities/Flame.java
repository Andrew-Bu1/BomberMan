package uet.oop.bomberman.entities;

//import javafx.scene.image.Image;

public class Flame extends Entity {
    public Flame(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        animateSprite();
        animate++;
        if (animate > 20) {
            animate = 0;
        }
    }

    @Override
    public void animateSprite() {

    }

    @Override
    public void move() {

    }
}
