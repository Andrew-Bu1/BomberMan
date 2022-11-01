package uet.oop.bomberman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.entities.AnimateEntity.Brick;
import uet.oop.bomberman.entities.AnimateEntity.DynamicEntity.Ballom;
import uet.oop.bomberman.entities.AnimateEntity.DynamicEntity.Bomber;
import uet.oop.bomberman.entities.AnimateEntity.DynamicEntity.Doll;
import uet.oop.bomberman.entities.AnimateEntity.DynamicEntity.Kondoria;
import uet.oop.bomberman.entities.AnimateEntity.DynamicEntity.Oneal;
import uet.oop.bomberman.entities.StaticEntity.Blocks.Grass;
import uet.oop.bomberman.entities.StaticEntity.Blocks.Wall;
import uet.oop.bomberman.entities.StaticEntity.HiddenBlock.BombItem;
import uet.oop.bomberman.entities.StaticEntity.HiddenBlock.FlameItem;
import uet.oop.bomberman.entities.StaticEntity.HiddenBlock.Portal;
import uet.oop.bomberman.entities.StaticEntity.HiddenBlock.SpeedItem;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.enemies;
import static uet.oop.bomberman.BombermanGame.stillObject;
import static uet.oop.bomberman.BombermanGame.bricks;
import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.bombs;
import static uet.oop.bomberman.BombermanGame.flames;
import static uet.oop.bomberman.BombermanGame.menu;
import static uet.oop.bomberman.BombermanGame.hiddenItems;

public class tileManager {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 16;
    public static int level = 0;

    public static char[][] map = new char[WIDTH][HEIGHT];
    public static char[][] mapInGame = new char[WIDTH][HEIGHT];

    public String mapPath() {
        return "res/levels/level" + level + ".txt";
    }

    public void loadMap(String file) {
        File read = new File(file);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(read));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        String st;
        try {
            int j = 0;
            while ((st = br.readLine()) != null) {
                for (int i = 0; i < st.length(); i++) {
                    map[i][j] = st.charAt(i);
                    if (map[i][j] == 'x' || map[i][j] == 's' | map[i][j] == 'f' || map[i][j] == 'b') {
                        mapInGame[i][j] = '*';
                    } else {
                        mapInGame[i][j] = map[i][j];
                    }
                }
                j++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        createEnemies();
        createObjects();

    }

    public void createObjects() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (map[i][j] == '*') {
                    bricks.add(new Brick(i, j));
                } else if (map[i][j] == '#') {
                    stillObject.add(new Wall(i, j));
                }

                if (map[i][j] == 'x') {
                    hiddenItems.add(new Portal(i, j));
                    bricks.add(new Brick(i, j));
                } else if (map[i][j] == 's') {
                    hiddenItems.add(new SpeedItem(i, j));
                    bricks.add(new Brick(i, j));
                } else if (map[i][j] == 'f') {
                    hiddenItems.add(new FlameItem(i, j));
                    bricks.add(new Brick(i, j));
                } else if (map[i][j] == 'b') {
                    hiddenItems.add(new BombItem(i, j));
                    bricks.add(new Brick(i, j));
                }

                if (map[i][j] == 'p') {
                    bomberman = new Bomber(i, j);
                    bomberman.setInitialPosition(i * Sprite.SCALED_SIZE, j * Sprite.SCALED_SIZE);
                }

                if (map[i][j] != '#') {
                    stillObject.add(new Grass(i, j));
                }

            }
        }
    }

    public void createEnemies() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (map[i][j] == '1') {
                    enemies.add(new Ballom(i, j));
                } else if (map[i][j] == '2') {
                    enemies.add(new Oneal(i, j));
                } else if (map[i][j] == '3') {
                    enemies.add(new Doll(j, i));
                } else if (map[i][j] == '4') {
                    enemies.add(new Kondoria(i, j));
                }
            }
        }
    }

    public void render(GraphicsContext gc) {
        if (menu.getGameState() != menu.getMenuState() || menu.getGameState() != menu.getHelpState()) {
            stillObject.forEach(g -> g.render(gc));
            hiddenItems.forEach(g -> g.render(gc));
            bricks.forEach(g -> g.render(gc));
            enemies.forEach(g -> g.render(gc));
            bomberman.render(gc);
            bombs.forEach(g -> g.render(gc));
            flames.forEach(g -> g.render(gc));
        }
        if (menu.getGameState() == menu.getMenuState()) {
            menu.drawMenu(gc);
        }
        if (menu.getGameState() == menu.getHelpState()) {
            menu.drawhelpMenu(gc);
        }

    }

    public void clearMap() {
        stillObject.clear();
        enemies.clear();
        bombs.clear();
        flames.clear();
        bricks.clear();
    }
}
