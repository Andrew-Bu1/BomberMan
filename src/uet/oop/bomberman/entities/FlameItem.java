package uet.oop.bomberman.entities;

//import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class FlameItem extends Entity {
    public FlameItem(int x, int y) {
        super(x, y, Sprite.powerup_flames.getFxImage());
    }

    @Override
    public void update() {

    }

    @Override
    public void animateSprite() {

    }

    @Override
    public void move(int direction) {

    }
}
