package uet.oop.bomberman.entities.AnimateEntity.DynamicEntity;

import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.menu;
import static uet.oop.bomberman.BombermanGame.bomberman;

import uet.oop.bomberman.Algorithm.Astar;

public class Kondoria extends DynamicEntity {
    private Astar pathFind = new Astar();

    public Kondoria(int x, int y) {
        super(x, y, Sprite.kondoria_left1.getFxImage());
        pathFind.setStepsMax(100);
        speed = 2;
    }

    @Override
    public void update() {
        if (menu.getGameState() == menu.getPlayState()) {
            animateSprite();
            animate++;
            if (animate > 20) {
                animate = 0;
            }
            move();
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
                img = Sprite.movingSprite(Sprite.kondoria_left1, Sprite.kondoria_left2,
                        Sprite.kondoria_left3,
                        animate, 18).getFxImage();
            } else if (direction == 1 || direction == 3) {
                img = Sprite.movingSprite(Sprite.kondoria_right1, Sprite.kondoria_right2,
                        Sprite.kondoria_right3,
                        animate, 18).getFxImage();
            }
        } else {
            img = Sprite.movingSprite(Sprite.kondoria_dead, Sprite.mob_dead2, Sprite.mob_dead3, animate, 18)
                    .getFxImage();
        }
    }

    public void findPath() {
        pathFind.setNodes(x / Sprite.SCALED_SIZE, y / Sprite.SCALED_SIZE, bomberman.getX() / Sprite.SCALED_SIZE,
                bomberman.getY() / Sprite.SCALED_SIZE);
        pathFind.abolishSolid();
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
        }
    }

    @Override
    public void move() {
        findPath();
        switch (direction) {
            case 0:
                y -= speed;
                break;
            case 1:
                y += speed;
                break;
            case 2:
                x -= speed;
                break;
            case 3:
                x += speed;
                break;
        }

    }

    public String getName() {
        return "Kondoria";
    }

}
