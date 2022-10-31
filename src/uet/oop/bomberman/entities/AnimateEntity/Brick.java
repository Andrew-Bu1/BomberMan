package uet.oop.bomberman.entities.AnimateEntity;

import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.menu;

public class Brick extends AnimateEntity {

    public Brick(int x, int y) {
        super(x, y, Sprite.brick.getFxImage());
    }

    @Override
    public void update() {
        if (menu.getGameState() == menu.getPlayState()) {
            animate++;
            if (animate > 20) {
                animate = 0;
            }
            if (isDead) {
                time++;
                if (time == 20) {
                    isOff = true;
                }
            }
            animateSprite();
        }

    }

    @Override
    public void animateSprite() {
        if (isDead) {
            img = Sprite.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2, animate,
                    18).getFxImage();
        }
    }

    public String getName() {
        return "Brick";
    }

}
