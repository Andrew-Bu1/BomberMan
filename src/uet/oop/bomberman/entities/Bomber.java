package uet.oop.bomberman.entities;

import uet.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import static uet.oop.bomberman.BombermanGame.input;
import static uet.oop.bomberman.BombermanGame.enemies;

public class Bomber extends Entity {
    private int speed = 2;
    public static int direction;

    public static boolean bombPlaced = false;
    // left = 0, right = 1, up = 2, down = 3

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bomber(int x, int y) {
        super(x, y, Sprite.player_right.getFxImage());
    }

    @Override
    public void update() {
        move();
        animateSprite();
        checkDeath();
    }

    public void handleEventPressed(KeyEvent e) {
        input.pressKey(e);
        input.setMoving(true);
    }

    public void handleEventReleased(KeyEvent e) {
        input.releaseKey(e);
        input.setMoving(false);

    }

    @Override
    public void animateSprite() {
        if (input.isPressUp()) {
            if (input.isMoving()) {
                img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_up.getFxImage();
            }
        } else if (input.isPressDown()) {
            if (input.isMoving()) {
                img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_down.getFxImage();
            }
        } else if (input.isPressLeft()) {
            if (input.isMoving()) {
                img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_left.getFxImage();
            }

        } else if (input.isPressRight()) {
            if (input.isMoving()) {
                img = Sprite
                        .movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, animate, 18)
                        .getFxImage();
            } else {
                img = Sprite.player_right.getFxImage();
            }
        }
        animate++;
        if (animate > 20) {
            animate = 0;
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
        if (isAlive) {
            gc.drawImage(img, x, y);
        } else {
            img = Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2, Sprite.player_dead3, animate, 18)
                    .getFxImage();
            gc.drawImage(img, x, y);
        }
    }

    public void checkDeath() {
        for (int i = 0; i < enemies.size(); i++) {
            if (checkDynamicObject(this, enemies.get(i))) {
                isAlive = false;
            }
        }
    }

}