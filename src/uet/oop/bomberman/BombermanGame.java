package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.entities.Oneal;
import uet.oop.bomberman.entities.Wall;
import uet.oop.bomberman.entities.Ballom;
import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.graphics.Sprite;

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
    private Entity ballon1;
    private Entity oneal1;
    public List<Entity> enemies = new ArrayList<>();
    public List<Entity> undamObject = new ArrayList<>();
    public static List<Entity> removObject = new ArrayList<>();
    public static List<Entity> board = new ArrayList<>();

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
        ballon1 = new Ballom(10, 10);
        oneal1 = new Oneal(6, 8);
        enemies.add(ballon1);
        enemies.add(oneal1);
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
                Bomber.isMoving = true;
                if (event.getCode() == KeyCode.SPACE) {
                    Bomb.placeBomb();
                }
                bomberman.handleEvent(event);
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                Bomber.isMoving = false;
                bomberman.handleEvent(event);
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

        createMap();
    }

    public void createMap() {

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Entity object;
                if (j == 0 || j == HEIGHT - 1 || i == 0 || i == WIDTH - 1) {
                    object = new Wall(i, j);
                    undamObject.add(object);
                } else {
                    object = new Grass(i, j);
                    undamObject.add(object);
                }

            }
        }
    }

    public void update() {
        enemies.forEach(Entity::update);
        bomberman.update();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        undamObject.forEach(g -> g.render(gc));
        enemies.forEach(g -> g.render(gc));
        bomberman.render(gc);

    }
}
