package uet.oop.bomberman.entities.AnimateEntity.DynamicEntity;

import uet.oop.bomberman.Sound;
import uet.oop.bomberman.entities.AnimateEntity.Bomb;
import uet.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

import static uet.oop.bomberman.BombermanGame.input;
import static uet.oop.bomberman.BombermanGame.bombs;
import static uet.oop.bomberman.BombermanGame.enemies;
import static uet.oop.bomberman.BombermanGame.flames;
import static uet.oop.bomberman.BombermanGame.menu;

public class Bomber extends DynamicEntity {
    private int speed = 2;
    public static int direction;

    private int numBomb = 0;
    private int maxBomb = 3;

    private int radius = 2;

    public int getRadius() {
        return radius;
    }

    public void placeBomb() {
        if (numBomb < maxBomb) {
            numBomb++;
            bombs.add(new Bomb((int) x / Sprite.SCALED_SIZE, (int) (y / Sprite.SCALED_SIZE)));
        }
    }

    public void increaseBomb() {
        maxBomb++;
    }

    public void increaseRadius() {
        radius++;
    }

    public void bombFinished() {
        numBomb--;
    }

    public void increaseSpeed() {
        speed++;
    }

    public Bomber(int x, int y) {
        super(x, y, Sprite.player_right.getFxImage());
    }

    @Override
    public void update() {
        if (menu.getGameState() == menu.getPlayState()) {
            animate++;
            if (animate > 20) {
                animate = 0;
            }
            move();
            animateSprite();
            checkDeath();
        }
    }

    @Override
    public void animateSprite() {
        if (input.isPressUp()) {
            if (input.isHolding()) {
                img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, animate, 18)
                        .getFxImage();
                isDead = false;
            } else {
                img = Sprite.player_up.getFxImage();
            }
        } else if (input.isPressDown()) {
            if (input.isHolding()) {
                img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_down.getFxImage();
            }
        } else if (input.isPressLeft()) {
            if (input.isHolding()) {
                img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_left.getFxImage();
            }

        } else if (input.isPressRight()) {
            if (input.isHolding()) {
                img = Sprite
                        .movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_right.getFxImage();
            }
        }
    }

    @Override
    public void move() {
        int y1;
        int x1;
        if (input.isPressDown()) {
            y1 = y + speed;
            if (!checkStaticObject(x, y1)) {
                y = y1;
            }
        }
        if (input.isPressUp()) {
            y1 = y - speed;
            if (!checkStaticObject(x, y1)) {
                y = y1;
            }
        }
        if (input.isPressLeft()) {
            x1 = x - speed;
            if (!checkStaticObject(x1, y)) {
                x = x1;
            }
        }
        if (input.isPressRight()) {
            x1 = x + speed;
            if (!checkStaticObject(x1, y)) {
                x = x1;
            }
        }

    }

    @Override
    public void render(GraphicsContext gc) {
        if (!isDead) {
            gc.drawImage(img, x, y);
        } else {
            img = Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2, Sprite.player_dead3, animate, 18)
                    .getFxImage();
            gc.drawImage(img, x, y);
        }
    }

    public void checkDeath() {
        for (int i = 0; i < enemies.size(); i++) {
            if (checkDynamicObject(enemies.get(i), this)) {
                isDead = true;
                if (Sound.isEffectOn()) {
                    Sound.playEffect("bomberDie");
                }
            }
        }
        for (int i = 0; i < flames.size(); i++) {
            if (checkDynamicObject(flames.get(i), this)) {
                isDead = true;
                if (Sound.isEffectOn()) {
                    Sound.playEffect("bomberDie");
                }

            }
        }
    }

    public String getName() {
        return "Bomber";
    }
}