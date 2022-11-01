package uet.oop.bomberman.entities.AnimateEntity.DynamicEntity;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.AnimateEntity.AnimateEntity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.hiddenItems;
import static uet.oop.bomberman.BombermanGame.enemies;
import static uet.oop.bomberman.tileManager.mapInGame;

import static uet.oop.bomberman.BombermanGame.bomberman;

public abstract class DynamicEntity extends AnimateEntity {

    protected int speed;

    protected boolean isDead = false;

    public int getSpeed() {
        return speed;
    }

    public void increaseSpeed() {
        speed++;
    }

    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }

    public boolean isDead() {
        return isDead;
    }

    public DynamicEntity(int xUnit, int yUnit) {
        super(xUnit, yUnit);
    }

    public DynamicEntity(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public abstract void move();

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
            if (this instanceof Bomber) {
                bomberman.increaseSpeed();
                mapInGame[xBottomRight][yBottomRight] = ' ';
                itemUsed(xBottomRight, yBottomRight);
                return false;
            }

        } else if (mapInGame[xBottomLeft][yBottomLeft] == 's') {
            if (this instanceof Bomber) {
                bomberman.increaseSpeed();
                mapInGame[xBottomLeft][yBottomLeft] = ' ';
                itemUsed(xBottomLeft, yBottomLeft);
                return false;
            }

        } else if (mapInGame[xTopRight][yTopRight] == 's') {
            if (this instanceof Bomber) {
                bomberman.increaseSpeed();
                mapInGame[xTopRight][yTopRight] = ' ';
                itemUsed(xTopRight, yTopRight);
                return false;
            }

        } else if (mapInGame[xTopLeft][yTopLeft] == 's') {
            if (this instanceof Bomber) {
                bomberman.increaseSpeed();
                mapInGame[xTopLeft][yTopLeft] = ' ';
                itemUsed(xTopLeft, yTopLeft);
                return false;
            }
        }

        if (mapInGame[xBottomRight][yBottomRight] == '*' || mapInGame[xBottomLeft][yBottomLeft] == '*'
                || mapInGame[xTopRight][yTopRight] == '*' || mapInGame[xTopLeft][yTopLeft] == '*') {
            return true;
        }

        if (enemies.size() == 0 && (mapInGame[xBottomRight][yBottomRight] == 'x'
                || mapInGame[xBottomLeft][yBottomLeft] == 'x'
                || mapInGame[xTopRight][yTopRight] == 'x' || mapInGame[xTopLeft][yTopLeft] == 'x')) {
            bomberman.increaseHighScore();
        }

        return false;
    }

    public boolean checkDynamicObject(AnimateEntity object1, AnimateEntity object2) {
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

    public void itemUsed(int x, int y) {
        for (int i = 0; i < hiddenItems.size(); i++) {
            if ((hiddenItems.get(i).getName() == "BombItem" || hiddenItems.get(i).getName() == "SpeedItem"
                    || hiddenItems.get(i).getName() == "FlameItem")
                    && hiddenItems.get(i).getX() == x * Sprite.SCALED_SIZE
                    && hiddenItems.get(i).getY() == y * Sprite.SCALED_SIZE) {
                bomberman.increaseHighScore();
                hiddenItems.get(i).setOff(true);
            }
        }
    }

}
