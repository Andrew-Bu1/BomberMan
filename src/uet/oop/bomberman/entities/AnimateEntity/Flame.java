package uet.oop.bomberman.entities.AnimateEntity;

import static uet.oop.bomberman.BombermanGame.flames;
import static uet.oop.bomberman.tileManager.mapInGame;
import static uet.oop.bomberman.tileManager.map;
import static uet.oop.bomberman.BombermanGame.enemies;
import static uet.oop.bomberman.BombermanGame.menu;
import static uet.oop.bomberman.BombermanGame.bricks;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Flame extends AnimateEntity {

    private int flameLefts = 0;
    private int flameRights = 0;
    private int flameUps = 0;
    private int flameDowns = 0;
    private int radius = 1;
    private int time = 0;
    private boolean isOff = false;

    public boolean isOff() {
        return isOff;
    }

    public void setOff(boolean isOff) {
        this.isOff = isOff;
    }

    public void removeDuplicates() {

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
        if (menu.getGameState() == menu.getPlayState()) {
            animateSprite();
            animate++;
            time++;
            if (animate > 20) {
                animate = 0;
            }
            if (time == 40) {
                isOff = true;
            }
        }
    }

    private void countFlameUps() {
        for (int i = 1; i <= radius; i++) {
            int coordinateX = (int) x / Sprite.SCALED_SIZE;
            int coordinateY = (int) y / Sprite.SCALED_SIZE - i;
            if (mapInGame[coordinateX][coordinateY] == '#') {
                return;
            } else if (mapInGame[coordinateX][coordinateY] == '*') {
                if (map[coordinateX][coordinateY] != '*') {
                    mapInGame[coordinateX][coordinateY] = map[coordinateX][coordinateY];
                } else {
                    mapInGame[coordinateX][coordinateY] = ' ';
                }
                setExploded(coordinateX, coordinateY);
                flameUps++;
                break;
            } else {
                flameUps++;
            }
        }
    }

    private void countFlameDowns() {
        for (int i = 1; i <= radius; i++) {
            int coordinateX = (int) x / Sprite.SCALED_SIZE;
            int coordinateY = (int) y / Sprite.SCALED_SIZE + i;
            if (mapInGame[coordinateX][coordinateY] == '#') {
                return;
            } else if (mapInGame[coordinateX][coordinateY] == '*') {
                if (map[coordinateX][coordinateY] != '*') {
                    mapInGame[coordinateX][coordinateY] = map[coordinateX][coordinateY];
                } else {
                    mapInGame[coordinateX][coordinateY] = ' ';
                }
                setExploded(coordinateX, coordinateY);
                flameDowns += 1;
                break;
            } else {
                flameDowns++;
            }
        }
    }

    private void countFlameLefts() {
        for (int i = 1; i <= radius; i++) {
            int coordinateX = (int) x / Sprite.SCALED_SIZE - i;
            int coordinateY = (int) y / Sprite.SCALED_SIZE;
            if (mapInGame[coordinateX][coordinateY] == '#') {
                return;
            } else if (mapInGame[coordinateX][coordinateY] == '*') {
                if (map[coordinateX][coordinateY] != '*') {
                    mapInGame[coordinateX][coordinateY] = map[coordinateX][coordinateY];
                } else {
                    mapInGame[coordinateX][coordinateY] = ' ';
                }
                setExploded(coordinateX, coordinateY);
                flameLefts++;
                break;
            } else {
                flameLefts++;
            }
        }
    }

    private void countFlameRights() {
        for (int i = 1; i <= radius; i++) {
            int coordinateX = (int) x / Sprite.SCALED_SIZE + i;
            int coordinateY = (int) y / Sprite.SCALED_SIZE;
            if (mapInGame[coordinateX][coordinateY] == '#') {
                return;
            } else if (mapInGame[coordinateX][coordinateY] == '*') {
                if (map[coordinateX][coordinateY] != '*') {
                    mapInGame[coordinateX][coordinateY] = map[coordinateX][coordinateY];
                } else {
                    mapInGame[coordinateX][coordinateY] = ' ';
                }
                setExploded(coordinateX, coordinateY);
                flameRights++;
                break;
            } else {
                flameRights++;
            }
        }
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
            for (int j = 0; j < enemies.size(); j++) {
                if (checkDynamicObject(x, y - Sprite.SCALED_SIZE * i, enemies.get(j))) {
                    enemies.get(j).setDead(true);
                }
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
            for (int j = 0; j < enemies.size(); j++) {
                if (checkDynamicObject(x, y + Sprite.SCALED_SIZE * i, enemies.get(j))) {
                    enemies.get(j).setDead(true);
                }
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
            for (int j = 0; j < enemies.size(); j++) {
                if (checkDynamicObject(x - Sprite.SCALED_SIZE * i, y, enemies.get(j))) {
                    enemies.get(j).setDead(true);
                }
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
            for (int j = 0; j < enemies.size(); j++) {
                if (checkDynamicObject(x + Sprite.SCALED_SIZE * i, y, enemies.get(j))) {
                    enemies.get(j).setDead(true);
                }
            }
        }
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
    }

    public void setExploded(int x, int y) {
        for (int i = 0; i < bricks.size(); i++) {
            if (bricks.get(i).getX() == x * Sprite.SCALED_SIZE
                    && bricks.get(i).getY() == y * Sprite.SCALED_SIZE) {
                bricks.get(i).setDead(true);
            }
        }
    }

    public String getName() {
        return "Flame";
    }
}
