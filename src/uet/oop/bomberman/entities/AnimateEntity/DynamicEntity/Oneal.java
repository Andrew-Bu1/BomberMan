package uet.oop.bomberman.entities.AnimateEntity.DynamicEntity;

import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.menu;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.bomberman;

import uet.oop.bomberman.Algorithm.Astar;

public class Oneal extends DynamicEntity {
    private Astar pathFind = new Astar();
    private Random random = new Random();

    public Oneal(int x, int y) {
        super(x, y, Sprite.oneal_left1.getFxImage());
        pathFind.setStepsMax(40);
    }

    public void update() {
        if (menu.getGameState() == menu.getPlayState()) {
            animateSprite();
            animate++;
            if (animate > 20) {
                animate = 0;
            }
            move();
            if (notMove) {
                timer++;
                if (timer == 10) {
                    direction = random.nextInt(4);
                    timer = 0;
                }
            }
            if (isDead) {
                time++;
                if (time == 60) {
                    isOff = true;
                }
            }
        }
    }

    @Override
    public void animateSprite() {
        if (!isDead) {
            if (direction == 0 || direction == 2) {
                img = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2,
                        Sprite.oneal_right3,
                        animate, 18).getFxImage();
            } else if (direction == 1 || direction == 3) {
                img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2,
                        Sprite.oneal_left3,
                        animate, 18).getFxImage();
            }
        } else {
            img = Sprite.movingSprite(Sprite.oneal_dead, Sprite.mob_dead2, Sprite.mob_dead3, animate, 18)
                    .getFxImage();
        }
    }

    public void findPath() {
        pathFind.setNodes(x / Sprite.SCALED_SIZE, y / Sprite.SCALED_SIZE, bomberman.getX() / Sprite.SCALED_SIZE,
                bomberman.getY() / Sprite.SCALED_SIZE);
        if (pathFind.autoSearch()) {
            int xCoordinate = pathFind.trackPath.get(0).getxCoordinate() * Sprite.SCALED_SIZE;
            int yCoordinate = pathFind.trackPath.get(0).getyCoordinate() * Sprite.SCALED_SIZE;
            if (xCoordinate < x) {
                direction = 2;
            } else if (xCoordinate > x) {
                direction = 3;
            } else if (yCoordinate < y) {
                direction = 0;
            } else if (yCoordinate > y) {
                direction = 1;
            }
            notMove = false;
        } else {
            notMove = true;
        }
    }

    @Override
    public void move() {
        findPath();
        int y1, x1;
        speed = random.nextInt(3) + 1;
        switch (direction) {
            case 0:
                y1 = y - speed;
                if (!checkStaticObject(x, y1)) {
                    y = y1;
                }
                break;
            case 1:
                y1 = y + speed;
                if (!checkStaticObject(x, y1)) {
                    y = y1;
                }
                break;
            case 2:
                x1 = x - speed;
                if (!checkStaticObject(x1, y)) {
                    x = x1;
                }
                break;
            case 3:
                x1 = x + speed;
                if (!checkStaticObject(x1, y)) {
                    x = x1;
                }
                break;
            default:
                break;
        }

    }

    public String getName() {
        return "Oneal";
    }

}
