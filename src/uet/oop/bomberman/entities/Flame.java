package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class Flame extends Entity {
    public Flame(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        objectRender(direction);
        animate++;
        if (animate > 20) {
            animate = 0;
        }
    }

    @Override
    public void objectRender(int direction) {

    }

    @Override
    public void move(int direction) {

    }
}
