package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.tileManager.map;

public abstract class Entity {
    // Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;
    protected int direction;

    // Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;

    protected Image img;

    protected int animate = 0;

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

    public abstract void move();

    public boolean checkStaticObject(int x1, int y1) {
        int xBottomRight = (int) ((x1) / (Sprite.SCALED_SIZE));
        int yBottomRight = (int) ((y1) / (Sprite.SCALED_SIZE));

        int xBottomLeft = (int) (0.7 + (double) x1 / (Sprite.SCALED_SIZE));
        int yBottomLeft = (int) ((y1) / (Sprite.SCALED_SIZE));

        int xTopRight = (int) (x1 / (Sprite.SCALED_SIZE));
        int yTopRight = (int) (0.9 + (double) y1 / (Sprite.SCALED_SIZE));

        int xTopLeft = (int) (0.7 + (double) x1 / (Sprite.SCALED_SIZE));
        int yTopLeft = (int) (0.9 + (double) y1 / (Sprite.SCALED_SIZE));

        if (map[xBottomRight][yBottomRight] == '#' || map[xBottomLeft][yBottomLeft] == '#'
                || map[xTopRight][yTopRight] == '#' || map[xTopLeft][yTopLeft] == '#') {
            System.out.println("detected1");
            return true;
        }

        if (map[xBottomRight][yBottomRight] == '*' || map[xBottomLeft][yBottomLeft] == '*'
                || map[xTopRight][yTopRight] == '*' || map[xTopLeft][yTopLeft] == '*') {
            System.out.println("detected2");
            return true;
        }
        return false;
    }

    public void checkDynamicObject(int direction) {

    }

}
