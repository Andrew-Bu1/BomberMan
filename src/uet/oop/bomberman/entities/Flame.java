package uet.oop.bomberman.entities;

import static uet.oop.bomberman.BombermanGame.flames;
import static uet.oop.bomberman.tileManager.mapInGame;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Flame extends Entity {

    private int flameLefts = 0;
    private int flameRights = 0;
    private int flameUps = 0;
    private int flameDowns = 0;
    private int radius = 1;
    private int time = 0;
    private boolean isOff = false;

    // public void removeDuplicates() {
    // for (int i = 0; i < flames.size() - 1; i++) {
    // for (int j = 0; j < flames.size(); j++) {
    // if (flames.get(i).getX() == flames.get(j).getX() && flames.get(i).getY() ==
    // flames.get(i).getY()
    // && i != j) {
    // System.out.println("collided");
    // }
    // }
    // }

    // }

    public boolean isOff() {
        return isOff;
    }

    public void setOff(boolean isOff) {
        this.isOff = isOff;
    }

    // stop = 0, up = 1, down = 2, left = 3, right = 4, lastUp = 5, LastDown = 6,
    // LastLeft = 7, LastRight = 8
    public Flame(int x, int y, Image img, int direction) {
        super(x, y, img);
        this.direction = direction;
    }

    public Flame(int x, int y, int direction) {
        super(x, y);
        this.direction = direction;
    }

    public Flame(int x, int y) {
        super(x, y, Sprite.bomb_exploded.getFxImage());
    }

    @Override
    public void update() {
        animateSprite();
        animate++;
        time++;
        if (animate > 20) {
            animate = 0;
        }
        if (time == 40) {
            isOff = true;
        }
        System.out.println(flames.size());
    }

    private void countFlameUps() {
        for (int i = 1; i <= radius; i++) {
            if (mapInGame[(int) x / Sprite.SCALED_SIZE][(int) y / Sprite.SCALED_SIZE - i] == '#') {
                return;
            } else if (mapInGame[(int) x / Sprite.SCALED_SIZE][(int) y / Sprite.SCALED_SIZE - i] == '*') {
                flameUps++;
                break;
            } else {
                flameUps++;
            }
        }
        System.out.println(flameUps);
    }

    private void countFlameDowns() {
        for (int i = 1; i <= radius; i++) {
            if (mapInGame[(int) x / Sprite.SCALED_SIZE][(int) y / Sprite.SCALED_SIZE + i] == '#') {
                return;
            } else if (mapInGame[(int) x / Sprite.SCALED_SIZE][(int) y / Sprite.SCALED_SIZE + i] == '*') {
                flameDowns += 1;
                break;
            } else {
                flameDowns++;
            }
        }
        System.out.println(flameDowns);
    }

    private void countFlameLefts() {
        for (int i = 1; i <= radius; i++) {
            if (mapInGame[(int) x / Sprite.SCALED_SIZE - i][(int) y / Sprite.SCALED_SIZE] == '#') {
                return;
            } else if (mapInGame[(int) x / Sprite.SCALED_SIZE + i][(int) y / Sprite.SCALED_SIZE] == '*') {
                flameLefts++;
                break;
            } else {
                flameLefts++;
            }
        }
        System.out.println(flameRights);
    }

    private void countFlameRights() {
        for (int i = 1; i <= radius; i++) {
            if (mapInGame[(int) x / Sprite.SCALED_SIZE + i][(int) y / Sprite.SCALED_SIZE] == '#') {
                return;
            } else if (mapInGame[(int) x / Sprite.SCALED_SIZE + i][(int) y / Sprite.SCALED_SIZE] == '*') {
                flameRights++;
                break;
            } else {
                flameRights++;
            }
        }
        System.out.println(flameRights);
    }

    public void createFlame(int x, int y, int radius) {
        this.radius = radius;
        flames.add(new Flame(x / Sprite.SCALED_SIZE, y / Sprite.SCALED_SIZE,
                Sprite.bomb_exploded.getFxImage(), 0));
        countFlameUps();
        countFlameDowns();
        countFlameLefts();
        countFlameRights();
        for (int i = 1; i <= flameUps; i++) {
            if (i == flameUps) {
                flames.add(new Flame(x / Sprite.SCALED_SIZE, y / Sprite.SCALED_SIZE - i, 5));
            } else {
                flames.add(new Flame(x / Sprite.SCALED_SIZE, y / Sprite.SCALED_SIZE - i, 1));
            }
        }

        for (int i = 1; i <= flameDowns; i++) {
            if (i == flameDowns) {
                flames.add(new Flame(x / Sprite.SCALED_SIZE, y / Sprite.SCALED_SIZE + i,
                        6));
            } else {
                flames.add(new Flame(x / Sprite.SCALED_SIZE, y / Sprite.SCALED_SIZE + i,
                        2));
            }
        }

        for (int i = 1; i <= flameLefts; i++) {
            if (i == flameLefts) {
                flames.add(new Flame(x / Sprite.SCALED_SIZE - i, y / Sprite.SCALED_SIZE,
                        7));
            } else {
                flames.add(new Flame(x / Sprite.SCALED_SIZE - i, y / Sprite.SCALED_SIZE,
                        3));
            }
        }

        for (int i = 1; i <= flameRights; i++) {
            if (i == flameRights) {
                flames.add(new Flame(x / Sprite.SCALED_SIZE + i, y / Sprite.SCALED_SIZE,
                        8));
            } else {
                flames.add(new Flame(x / Sprite.SCALED_SIZE + i, y / Sprite.SCALED_SIZE,
                        4));
            }
        }
        System.out.println(flames.size());
    }

    @Override
    public void animateSprite() {
        switch (direction) {
            case 0:
                img = Sprite.movingSprite(Sprite.bomb_exploded, Sprite.bomb_exploded1, Sprite.bomb_exploded2, time, 18)
                        .getFxImage();
                break;
            case 1:
                img = Sprite.movingSprite(Sprite.explosion_vertical, Sprite.explosion_vertical1,
                        Sprite.explosion_vertical2, time, 18).getFxImage();
                break;
            case 2:
                img = Sprite.movingSprite(Sprite.explosion_vertical, Sprite.explosion_vertical1,
                        Sprite.explosion_vertical2, time, 18).getFxImage();
                break;
            case 3:
                img = Sprite.movingSprite(Sprite.explosion_horizontal, Sprite.explosion_horizontal1,
                        Sprite.explosion_horizontal2, time, 18).getFxImage();
                break;
            case 4:
                img = Sprite.movingSprite(Sprite.explosion_horizontal, Sprite.explosion_horizontal1,
                        Sprite.explosion_horizontal2, time, 18).getFxImage();
                break;
            case 5:
                img = Sprite.movingSprite(Sprite.explosion_vertical_top_last, Sprite.explosion_vertical_top_last1,
                        Sprite.explosion_vertical_top_last2, time, 18).getFxImage();
                break;
            case 6:
                img = Sprite.movingSprite(Sprite.explosion_vertical_down_last, Sprite.explosion_vertical_down_last1,
                        Sprite.explosion_vertical_down_last2, time, 18).getFxImage();
                break;
            case 7:
                img = Sprite.movingSprite(Sprite.explosion_horizontal_left_last, Sprite.explosion_horizontal1,
                        Sprite.explosion_horizontal_left_last2, time, 18).getFxImage();
                break;
            case 8:
                img = Sprite
                        .movingSprite(Sprite.explosion_horizontal_right_last, Sprite.explosion_horizontal_right_last1,
                                Sprite.explosion_horizontal_right_last2, time, 18)
                        .getFxImage();
                break;
        }
        // if (isLast) {
        // switch (direction) {
        // case 1:
        // img = Sprite.movingSprite(Sprite.explosion_vertical_top_last,
        // Sprite.explosion_vertical_top_last1, Sprite.explosion_vertical_top_last2,
        // animate, 18)
        // .getFxImage();
        // break;
        // case 2:
        // img = Sprite.movingSprite(Sprite.explosion_vertical_down_last,
        // Sprite.explosion_vertical_down_last1, Sprite.explosion_vertical_down_last2,
        // animate, 18)
        // .getFxImage();
        // break;
        // case 3:
        // img = Sprite.movingSprite(Sprite.explosion_horizontal_left_last,
        // Sprite.explosion_horizontal_left_last1,
        // Sprite.explosion_horizontal_left_last2, animate,
        // 18).getFxImage();
        // break;
        // case 4:
        // img = Sprite.movingSprite(Sprite.explosion_horizontal_right_last,
        // Sprite.explosion_horizontal_right_last1,
        // Sprite.explosion_horizontal_right_last2,
        // animate,
        // 18).getFxImage();
        // break;
        // }
        // } else {
        // switch (direction) {
        // case 0:
        // img = Sprite.movingSprite(Sprite.bomb_exploded, Sprite.bomb_exploded1,
        // Sprite.bomb_2, animate, 18)
        // .getFxImage();
        // break;
        // case 1:
        // img = Sprite.movingSprite(Sprite.explosion_vertical,
        // Sprite.explosion_vertical1, Sprite.explosion_vertical2, animate, 18)
        // .getFxImage();
        // break;
        // case 2:
        // img = Sprite.movingSprite(Sprite.explosion_vertical,
        // Sprite.explosion_vertical1, Sprite.explosion_vertical2, animate, 18)
        // .getFxImage();
        // break;
        // case 3:
        // img = Sprite.movingSprite(Sprite.explosion_horizontal,
        // Sprite.explosion_horizontal1, Sprite.explosion_horizontal2, animate,
        // 18).getFxImage();
        // break;
        // case 4:
        // img = Sprite.movingSprite(Sprite.explosion_horizontal,
        // Sprite.explosion_horizontal1, Sprite.explosion_horizontal2,
        // animate,
        // 18).getFxImage();
        // break;
        // }
        // }
    }

    @Override
    public void move() {

    }

}
