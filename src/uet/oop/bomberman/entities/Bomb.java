package uet.oop.bomberman.entities;

import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.bomberman;

public class Bomb extends Entity {
    private int time = 0;
    private boolean isExploded = false;

    public boolean isExploded() {
        return isExploded;
    }

    public Bomb(int x, int y) {
        super(x, y, Sprite.bomb.getFxImage());

    }

    @Override
    public void update() {
        animateSprite();
        animate++;
        time++;
        if (animate > 20) {
            animate = 0;
        }
        if (time >= 100) {
            isExploded = true;
            bomberman.bombFinished();
            Flame flame1 = new Flame(x / Sprite.SCALED_SIZE, y / Sprite.SCALED_SIZE);
            flame1.createFlame(x, y, bomberman.getRadius());
        }
    }

    @Override
    public void animateSprite() {
        if (!isExploded) {
            img = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, animate, 18).getFxImage();
        }
    }

    @Override
    public void move() {

    }

}