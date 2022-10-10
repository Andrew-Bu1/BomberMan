package uet.oop.bomberman.entities;

//import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class BombItem extends Entity {
    public BombItem(int x, int y) {
        super(x, y, Sprite.powerup_bombs.getFxImage());
    }

    @Override
    public void update() {

    }

    @Override
    public void animateSprite() {

    }

    @Override
    public void move() {

    }
}
