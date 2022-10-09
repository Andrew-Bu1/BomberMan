package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
//import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.graphics.Sprite;

public class Bomb extends Entity {
    private static int numBomb = 1;
    private double timeExplode;

    public static int getNumBomb() {
        return numBomb;
    }

    private boolean canBomb = true;

    public boolean isCanBomb() {
        return canBomb;
    }

    public Bomb(int x, int y) {
        super(x, y, Sprite.bomb.getFxImage());
    }

    @Override
    public void update() {

    }

    @Override
    public void objectRender(int direction) {
        // if (canBomb) {
        // img = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, animate,
        // 18)
        // .getFxImage();
        // }
    }

    @Override
    public void move(int direction) {

    }
}