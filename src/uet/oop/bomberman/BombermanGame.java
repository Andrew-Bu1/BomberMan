package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
// import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.AnimateEntity.Bomb;
import uet.oop.bomberman.entities.AnimateEntity.Brick;
import uet.oop.bomberman.entities.AnimateEntity.Flame;
import uet.oop.bomberman.entities.AnimateEntity.DynamicEntity.Bomber;
import uet.oop.bomberman.entities.AnimateEntity.DynamicEntity.DynamicEntity;
import uet.oop.bomberman.entities.StaticEntity.Blocks.Block;
import uet.oop.bomberman.entities.StaticEntity.HiddenBlock.HiddenBlock;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {

    private Scene scene;
    private GraphicsContext gc;
    private Group root;
    private Canvas canvas;
    public static Bomber bomberman;
    public static List<DynamicEntity> enemies = new ArrayList<>();
    public static List<Block> stillObject = new ArrayList<>();
    public static List<Brick> bricks = new ArrayList<>();
    public static List<HiddenBlock> hiddenItems = new ArrayList<>();
    public static final List<Bomb> bombs = new ArrayList<>();
    public static final List<Flame> flames = new ArrayList<>();
    private tileManager level = new tileManager();
    public static handleKey input;
    public static Menu menu = new Menu();

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * tileManager.WIDTH, Sprite.SCALED_SIZE * tileManager.HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        input = new handleKey(scene);

        AnimationTimer timer = new AnimationTimer() {
            long frameStart = System.nanoTime();

            @Override
            public void handle(long l) {
                level.render(gc);
                update();
            }
        };
        timer.start();

        level.loadMap("res\\levels\\Level0.txt");

    }

    public void removeObject() {
        bombs.removeIf(Bomb::isExploded);
        enemies.removeIf(DynamicEntity::isOff);
        flames.removeIf(Flame::isOff);
        hiddenItems.removeIf(HiddenBlock::isOff);
        bricks.removeIf(Brick::isOff);
    }

    public void update() {
        enemies.forEach(DynamicEntity::update);
        bomberman.update();
        bombs.forEach(Bomb::update);
        flames.forEach(Flame::update);
        bricks.forEach(Brick::update);
        removeObject();
    }

    public void render(GraphicsContext gc) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        level.render(gc);
    }
}
