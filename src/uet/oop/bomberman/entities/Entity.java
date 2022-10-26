package uet.oop.bomberman.entities;

import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.tileManager.mapInGame;
import static uet.oop.bomberman.BombermanGame.flames;
import static uet.oop.bomberman.BombermanGame.stillObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Entity {
    // Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;
    protected int direction;

    // Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected Image img;

    public Image getImg() {
        return img;
    }

    protected int animate = 0;

    protected boolean isDead = false;

    protected boolean isOff = false;

    public void setOff(boolean isOff) {
        this.isOff = isOff;
    }

    public boolean isOff() {
        return isOff;
    }

    protected boolean isHidden = false;

    public void setHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }

    public boolean isDead() {
        return isDead;
    }

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

    public abstract void move();

    public abstract void animateSprite();

    public abstract void update();

    public void checkDeath() {
        for (int i = 0; i < flames.size(); i++) {
            if (checkDynamicObject(this, flames.get(i))) {
                isDead = true;
            }
        }
    }

    public boolean checkStaticObject(int x1, int y1) {
        int xBottomRight = (int) ((x1) / (Sprite.SCALED_SIZE));
        int yBottomRight = (int) ((y1) / (Sprite.SCALED_SIZE));

        int xBottomLeft = (int) (0.8 + (double) x1 / (Sprite.SCALED_SIZE));
        int yBottomLeft = (int) ((y1) / (Sprite.SCALED_SIZE));

        int xTopRight = (int) (x1 / (Sprite.SCALED_SIZE));
        int yTopRight = (int) (0.8 + (double) y1 / (Sprite.SCALED_SIZE));

        int xTopLeft, yTopLeft;

        if (this instanceof Bomber) {
            xTopLeft = (int) (0.8 + (double) x1 / (Sprite.SCALED_SIZE));
            yTopLeft = (int) (0.8 + (double) y1 / (Sprite.SCALED_SIZE));

        } else {
            xTopLeft = (int) (0.9 + (double) x1 / (Sprite.SCALED_SIZE));
            yTopLeft = (int) (0.9 + (double) y1 / (Sprite.SCALED_SIZE));
        }

        if (mapInGame[xBottomRight][yBottomRight] == '#' || mapInGame[xBottomLeft][yBottomLeft] == '#'
                || mapInGame[xTopRight][yTopRight] == '#' || mapInGame[xTopLeft][yTopLeft] == '#') {
            return true;
        }

        if (mapInGame[xBottomRight][yBottomRight] == 'b') {
            mapInGame[xBottomRight][yBottomRight] = ' ';
            if (this instanceof Bomber) {
                bomberman.increaseBomb();
            }
            itemUsed(xBottomRight, yBottomRight);
            return false;
        } else if (mapInGame[xBottomLeft][yBottomLeft] == 'b') {
            if (this instanceof Bomber) {
                bomberman.increaseBomb();
            }
            mapInGame[xBottomLeft][yBottomLeft] = ' ';
            itemUsed(xBottomLeft, yBottomLeft);
            return false;
        } else if (mapInGame[xTopRight][yTopRight] == 'b') {
            if (this instanceof Bomber) {
                bomberman.increaseBomb();
            }
            mapInGame[xTopRight][yTopRight] = ' ';
            itemUsed(xTopRight, yTopRight);
            return false;
        } else if (mapInGame[xTopLeft][yTopLeft] == 'b') {
            if (this instanceof Bomber) {
                bomberman.increaseBomb();
            }
            mapInGame[xTopLeft][yTopLeft] = ' ';
            itemUsed(xTopLeft, yTopLeft);
            return false;
        }

        if (mapInGame[xBottomRight][yBottomRight] == 'f') {
            mapInGame[xBottomRight][yBottomRight] = ' ';
            if (this instanceof Bomber) {
                bomberman.increaseRadius();
            }
            itemUsed(xBottomRight, yBottomRight);
            return false;
        } else if (mapInGame[xBottomLeft][yBottomLeft] == 'f') {
            if (this instanceof Bomber) {
                bomberman.increaseRadius();
            }
            mapInGame[xBottomLeft][yBottomLeft] = ' ';
            itemUsed(xBottomLeft, yBottomLeft);
            return false;
        } else if (mapInGame[xTopRight][yTopRight] == 'f') {
            if (this instanceof Bomber) {
                bomberman.increaseRadius();
            }
            mapInGame[xTopRight][yTopRight] = ' ';
            itemUsed(xTopRight, yTopRight);
            return false;
        } else if (mapInGame[xTopLeft][yTopLeft] == 'f') {
            if (this instanceof Bomber) {
                bomberman.increaseRadius();
            }
            mapInGame[xTopLeft][yTopLeft] = ' ';
            itemUsed(xTopLeft, yTopLeft);
            return false;
        }

        if (mapInGame[xBottomRight][yBottomRight] == 's') {
            mapInGame[xBottomRight][yBottomRight] = ' ';
            if (this instanceof Bomber) {
                bomberman.increaseSpeed();
            }
            itemUsed(xBottomRight, yBottomRight);
            return false;
        } else if (mapInGame[xBottomLeft][yBottomLeft] == 's') {
            if (this instanceof Bomber) {
                bomberman.increaseSpeed();
            }
            mapInGame[xBottomLeft][yBottomLeft] = ' ';
            itemUsed(xBottomLeft, yBottomLeft);
            return false;
        } else if (mapInGame[xTopRight][yTopRight] == 's') {
            if (this instanceof Bomber) {
                bomberman.increaseSpeed();
            }
            mapInGame[xTopRight][yTopRight] = ' ';
            itemUsed(xTopRight, yTopRight);
            return false;
        } else if (mapInGame[xTopLeft][yTopLeft] == 's') {
            if (this instanceof Bomber) {
                bomberman.increaseSpeed();
            }
            mapInGame[xTopLeft][yTopLeft] = ' ';
            itemUsed(xTopLeft, yTopLeft);
            return false;
        }

        if (mapInGame[xBottomRight][yBottomRight] == '*' || mapInGame[xBottomLeft][yBottomLeft] == '*'
                || mapInGame[xTopRight][yTopRight] == '*' || mapInGame[xTopLeft][yTopLeft] == '*') {
            return true;
        }

        return false;
    }

    public boolean checkDynamicObject(Entity object1, Entity object2) {
        int Left1 = object1.getX();
        int Left2 = object2.getX();

        int Right1 = object1.getX() + (int) object1.getImg().getWidth();
        int Right2 = object2.getX() + (int) object2.getImg().getWidth();

        int Top1 = object1.getY();
        int Top2 = object2.getY();

        int Bottom1 = object1.getY() + (int) object1.getImg().getHeight();
        int Bottom2 = object2.getY() + (int) object2.getImg().getHeight();

        return Left1 < Right2 && Right1 > Left2
                && Top1 < Bottom2 && Bottom1 > Top2;
    }

    public boolean checkDynamicObject(int x, int y, Entity object1) {
        int Left1 = x;
        int Left2 = object1.getX();

        int Right1 = x + Sprite.SCALED_SIZE;
        int Right2 = object1.getX() + (int) object1.getImg().getWidth();

        int Top1 = y;
        int Top2 = object1.getY();

        int Bottom1 = y + Sprite.SCALED_SIZE;
        int Bottom2 = object1.getY() + (int) object1.getImg().getHeight();

        return Left1 < Right2 && Right1 > Left2
                && Top1 < Bottom2 && Bottom1 > Top2;
    }

    public abstract String getName();

    public void itemUsed(int x, int y) {
        for (int i = 0; i < stillObject.size(); i++) {
            if ((stillObject.get(i).getName() == "BombItem" || stillObject.get(i).getName() == "SpeedItem"
                    || stillObject.get(i).getName() == "FlameItem")
                    && stillObject.get(i).getX() == x * Sprite.SCALED_SIZE
                    && stillObject.get(i).getY() == y * Sprite.SCALED_SIZE) {
                stillObject.get(i).setOff(true);
            }
        }
    }

}
