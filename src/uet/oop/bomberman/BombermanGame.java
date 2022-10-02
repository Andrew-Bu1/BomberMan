package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.entities.Oneal;
import uet.oop.bomberman.entities.Wall;
import uet.oop.bomberman.entities.ballon;
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
    private Bomber bomberman;
    private ballon ballon1;
    private Oneal oneal1;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();

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

        bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        ballon1 = new ballon(10, 10, Sprite.balloom_left1.getFxImage());
        oneal1 = new Oneal(6, 8, Sprite.oneal_left1.getFxImage());
        entities.add(bomberman);
        entities.add(ballon1);
        entities.add(oneal1);

    }

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            long frameStart = System.nanoTime();

            @Override
            public void handle(long l) {
                render();
                handleEvent();
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

    public void handleEvent() {
        scene.setOnKeyPressed(keyEvent -> {
            bomberman.handleEvent(keyEvent);
        });
        scene.setOnKeyReleased(keyEvent -> {
            bomberman.handleEvent(keyEvent);
        });

    }

    public void createMap() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Entity object;
                if (j == 0 || j == HEIGHT - 1 || i == 0 || i == WIDTH - 1) {
                    object = new Wall(i, j, Sprite.wall.getFxImage());
                } else {
                    object = new Grass(i, j, Sprite.grass.getFxImage());
                }
                stillObjects.add(object);
            }
        }
    }

    public void update() {
        entities.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
}
