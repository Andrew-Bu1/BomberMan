package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Brick;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.FlameItem;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.entities.Oneal;
import uet.oop.bomberman.entities.Portal;
import uet.oop.bomberman.entities.SpeedItem;
import uet.oop.bomberman.entities.Wall;
import uet.oop.bomberman.entities.Ballom;
import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.BombItem;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {

    public static final int WIDTH = 20;
    public static final int HEIGHT = 15;

    private Scene scene;
    private GraphicsContext gc;
    private Group root;
    private Canvas canvas;
    public static Bomber bomberman;
    public List<Entity> unRemovObject = new ArrayList<>();
    public static List<Entity> removObject = new ArrayList<>();

    private final int FPS = 60;
    private final int frameDelay = 1000000000 / FPS;

    public BombermanGame() {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        scene = new Scene(root);
        bomberman = new Bomber(1, 1);
    }

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // if (event.getCode() == KeyCode.SPACE) {
                // Bomb.placeBomb();
                // }
                bomberman.pressKey(event);
                // bomberman.handleEvent(event);
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                bomberman.releaseKey(event);
                // bomberman.handleEvent(event);
            }
        });
        AnimationTimer timer = new AnimationTimer() {
            long frameStart = System.nanoTime();

            @Override
            public void handle(long l) {
                render();
                update();
                long frameTime = System.nanoTime() - frameStart;
                if (frameDelay > frameTime) {
                    try {
                        Thread.sleep((frameDelay - frameTime) / 1000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        timer.start();
        // "res/levels/Level0.txt"
        createMap("res/levels/Level0.txt");
    }

    public void createMap(String file) {
        char[][] map = new char[WIDTH][HEIGHT];
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

        for (int i = 0; i < WIDTH; i++) {
            boolean isRemovable = false;
            Entity object;
            for (int j = 0; j < HEIGHT; j++) {
                switch (map[i][j]) {
                    case '*':
                        object = new Brick(i, j);
                        isRemovable = true;
                        break;
                    case '#':
                        object = new Wall(i, j);
                        break;
                    case '1':
                        object = new Ballom(i, j);
                        isRemovable = true;
                        break;
                    case '2':
                        object = new Oneal(i, j);
                        isRemovable = true;
                        break;
                    case 'f':
                        object = new FlameItem(i, j);
                        isRemovable = true;
                        break;
                    case 'x':
                        object = new Portal(i, j);
                        isRemovable = true;
                        break;
                    default:
                        object = new Grass(i, j);
                        break;
                }
                if (isRemovable) {
                    removObject.add(object);
                    Entity object1 = new Grass(i, j);
                    unRemovObject.add(object1);
                }
                unRemovObject.add(object);

            }
        }

    }

    public void update() {
        removObject.forEach(Entity::update);
        bomberman.update();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        removObject.forEach(g -> g.render(gc));
        unRemovObject.forEach(g -> g.render(gc));
        bomberman.render(gc);
    }
}
