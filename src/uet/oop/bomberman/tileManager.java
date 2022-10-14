package uet.oop.bomberman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import uet.oop.bomberman.entities.Ballom;
import uet.oop.bomberman.entities.BombItem;
import uet.oop.bomberman.entities.Brick;
import uet.oop.bomberman.entities.FlameItem;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.entities.Oneal;
import uet.oop.bomberman.entities.Portal;
import uet.oop.bomberman.entities.SpeedItem;
import uet.oop.bomberman.entities.Wall;
import uet.oop.bomberman.entities.Doll;
import uet.oop.bomberman.entities.Kondoria;

import static uet.oop.bomberman.BombermanGame.enemies;
import static uet.oop.bomberman.BombermanGame.stillObject;
import static uet.oop.bomberman.BombermanGame.hiddenItem;
import static uet.oop.bomberman.BombermanGame.grass;

public class tileManager {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 15;
    public static int level = 0;

    private char[][] map = new char[WIDTH][HEIGHT];

    public String path() {
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
                }
                j++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                    hiddenItem.add(new Portal(i, j));
                    stillObject.add(new Brick(i, j));
                }
                if (map[i][j] == 's') {
                    hiddenItem.add(new SpeedItem(i, j));
                    stillObject.add(new Brick(i, j));
                } else if (map[i][j] == 'f') {
                    hiddenItem.add(new FlameItem(i, j));
                    stillObject.add(new Brick(i, j));
                } else if (map[i][j] == 'b') {
                    hiddenItem.add(new BombItem(i, j));
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

    // public void render() {
    // for (int i = 0; i < WIDTH; i++) {
    // boolean isRemovable = false;
    // Entity object;
    // for (int j = 0; j < HEIGHT; j++) {
    // switch (map[i][j]) {
    // case '*':
    // object = new Brick(i, j);
    // isRemovable = true;
    // break;
    // case '#':
    // object = new Wall(i, j);
    // break;
    // case '1':
    // object = new Ballom(i, j);
    // isRemovable = true;
    // break;
    // case '2':
    // object = new Oneal(i, j);
    // isRemovable = true;
    // break;
    // case 'f':
    // object = new FlameItem(i, j);
    // isRemovable = true;
    // break;
    // case 'x':
    // object = new Portal(i, j);
    // isRemovable = true;
    // break;
    // default:
    // object = new Grass(i, j);
    // break;
    // }
    // board.add(object);
    // if (isRemovable) {
    // removable.add(object);
    // Entity object1 = new Grass(i, j);
    // removable.add(object1);
    // }
    // unremovable.add(object);
    // }
    // }
    // }

}
