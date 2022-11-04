package uet.oop.bomberman.entities.AnimateEntity;

import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.menu;
import static uet.oop.bomberman.tileManager.mapInGame;
import static uet.oop.bomberman.tileManager.map;

import uet.oop.bomberman.Sound;

public class Bomb extends AnimateEntity {

    private boolean isExploded = false;

    public boolean isExploded() {
        return isExploded;
    }

    public Bomb(int x, int y) {
        super(x, y, Sprite.bomb.getFxImage());

    }

    @Override
    public void update() {
        if (menu.getGameState() == menu.getPlayState()) {
            animateSprite();
            animate++;
            time++;
            if (animate > 20) {
                animate = 0;
            }
            if (time >= 100) {
                isExploded = true;
                if (map[x / Sprite.SCALED_SIZE][y
                        / Sprite.SCALED_SIZE] != '*') {
                    mapInGame[x / Sprite.SCALED_SIZE][y / Sprite.SCALED_SIZE] = map[x / Sprite.SCALED_SIZE][y
                            / Sprite.SCALED_SIZE];
                } else {
                    mapInGame[x / Sprite.SCALED_SIZE][y / Sprite.SCALED_SIZE] = ' ';
                }
                bomberman.bombFinished();
                if (Sound.isEffectOn()) {
                    Sound.playEffect("bombExploded");
                }
                Flame flame1 = new Flame(x / Sprite.SCALED_SIZE, y / Sprite.SCALED_SIZE);
                flame1.createFlame(x, y, bomberman.getRadius());
            }
        }

    }

    @Override
    public void animateSprite() {
        if (!isExploded) {
            img = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, animate, 18).getFxImage();
        }
    }

    public String getName() {
        return "Bomb";
    }

}