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
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Bombs.Bomb;
import uet.oop.bomberman.entities.Bombs.Flame;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {

    private Scene scene;
    private GraphicsContext gc;
    private Group root;
    private Canvas canvas;
    public static Bomber bomberman;
    public static List<Entity> hiddenItem = new ArrayList<>();
    public static List<Entity> enemies = new ArrayList<>();
    public static List<Entity> stillObject = new ArrayList<>();
    public static List<Entity> grass = new ArrayList<>();
    public static final List<Bomb> bombs = new ArrayList<>();
    public static final List<Flame> flames = new ArrayList<>();
    private tileManager level = new tileManager();
    public static handleKey input = new handleKey();

    private final int FPS = 60;
    private final int frameDelay = 1000000000 / FPS;

    public BombermanGame() {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * tileManager.WIDTH, Sprite.SCALED_SIZE * tileManager.HEIGHT);
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
                bomberman.handleEventPressed(event);
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                bomberman.handleEventReleased(event);
            }
        });
        AnimationTimer timer = new AnimationTimer() {
            long frameStart = System.nanoTime();

            @Override
            public void handle(long l) {
                level.render(gc);
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

        level.loadMap("res\\levels\\Level0.txt");
        level.createObjects();
        level.createEnemies();
    }

    public void removeObject() {
        bombs.removeIf(Bomb::isExploded);
        enemies.removeIf(Entity::isDead);
        stillObject.removeIf(Entity::isOff);
        flames.removeIf(Flame::isOff);
        hiddenItem.removeIf(Entity::isOff);
    }

    public void update() {
        enemies.forEach(Entity::update);
        bomberman.update();
        bombs.forEach(Bomb::update);
        stillObject.forEach(Entity::update);
        flames.forEach(Entity::update);
        removeObject();
    }

    public void render(GraphicsContext gc) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        level.render(gc);
    }
}
