package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Entity {
    // Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    // Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;

    protected Image img;

    protected int animate = 0;

    protected int direction;
    protected final int up = 2;
    protected final int down = 3;
    protected final int left = 0;
    protected final int right = 1;

    // Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity(int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
    }

    public Entity(int xUnit, int yUnit) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    public abstract void animateSprite();

    public abstract void update();

    public abstract void move(int direction);
}
