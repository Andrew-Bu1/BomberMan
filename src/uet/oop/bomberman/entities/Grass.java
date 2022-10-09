package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Grass extends Entity {

    public Grass(int x, int y) {
        super(x, y, Sprite.grass.getFxImage());
    }

    @Override
    public void update() {

    }

    @Override
    public void objectRender(int direction) {

    }

    @Override
    public void move(int direction) {

    }
}
