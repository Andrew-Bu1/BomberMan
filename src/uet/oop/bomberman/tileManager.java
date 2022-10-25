package uet.oop.bomberman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.entities.Blocks.Brick;
import uet.oop.bomberman.entities.Blocks.Grass;
import uet.oop.bomberman.entities.Blocks.Portal;
import uet.oop.bomberman.entities.Blocks.Wall;
import uet.oop.bomberman.entities.Enemies.Ballom;
import uet.oop.bomberman.entities.Enemies.Doll;
import uet.oop.bomberman.entities.Enemies.Kondoria;
import uet.oop.bomberman.entities.Enemies.Oneal;
import uet.oop.bomberman.entities.Items.BombItem;
import uet.oop.bomberman.entities.Items.FlameItem;
import uet.oop.bomberman.entities.Items.SpeedItem;

import static uet.oop.bomberman.BombermanGame.enemies;
import static uet.oop.bomberman.BombermanGame.stillObject;
import static uet.oop.bomberman.BombermanGame.grass;
import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.bombs;
import static uet.oop.bomberman.BombermanGame.flames;

public class tileManager {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 15;
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
                    stillObject.add(new Brick(i, j));
                } else if (map[i][j] == '#') {
                    stillObject.add(new Wall(i, j));
                }

                if (map[i][j] == 'x') {
                    stillObject.add(new Portal(i, j));
                    stillObject.add(new Brick(i, j));
                } else if (map[i][j] == 's') {
                    stillObject.add(new SpeedItem(i, j));
                    stillObject.add(new Brick(i, j));
                } else if (map[i][j] == 'f') {
                    stillObject.add(new FlameItem(i, j));
                    stillObject.add(new Brick(i, j));
                } else if (map[i][j] == 'b') {
                    stillObject.add(new BombItem(i, j));
                    stillObject.add(new Brick(i, j));
                }

                if (map[i][j] != '#') {
                    grass.add(new Grass(i, j));
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
        grass.forEach(g -> g.render(gc));
        stillObject.forEach(g -> g.render(gc));
        enemies.forEach(g -> g.render(gc));
        bomberman.render(gc);
        bombs.forEach(g -> g.render(gc));
        flames.forEach(g -> g.render(gc));
    }

    public void clearMap() {
        stillObject.clear();
        enemies.clear();
        grass.clear();
        bombs.clear();
        flames.clear();
    }
}
