package uet.oop.bomberman.entities;

//import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.removObject;

public class Bomb extends Entity {
    private static int numBomb = 0;
    private static int maxBombs = 1;
    private static boolean canBomb = true;
    private boolean isFinish = false;

    // private static int

    public static int getMaxBombs() {
        return maxBombs;
    }

    public static int getNumBomb() {
        return numBomb;
    }

    public static void placeBomb() {
        if (canBomb && numBomb <= maxBombs) {
            numBomb++;
            int x = bomberman.getX() / 32;
            int y = bomberman.getY() / 32;

            Entity bombt = new Bomb(x, y);
            removObject.add(bombt);
        }
    }

    public Bomb(int x, int y) {
        super(x, y, Sprite.bomb.getFxImage());
    }

    @Override
    public void update() {
        animateSprite();
        animate++;
        if (animate > 20) {
            animate = 0;
        }
    }

    @Override
    public void animateSprite() {
        if (numBomb > 0) {
            img = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, 5, 20).getFxImage();
        }
    }

    public void removeBomb() {

    }

    @Override
    public void move() {

    }
}