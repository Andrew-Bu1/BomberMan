package uet.oop.bomberman.entities.AnimateEntity;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public abstract class AnimateEntity extends Entity {

    protected int time = 0;

    protected int animate = 0;

    protected int direction;

    protected boolean isDead = false;

    public boolean isDead() {
        return isDead;
    }

    protected boolean isOff = false;

    public void setOff(boolean isOff) {
        this.isOff = isOff;
    }

    public boolean isOff() {
        return isOff;
    }

    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }

    public AnimateEntity(int x, int y) {
        super(x, y);
    }

    public AnimateEntity(int x, int y, Image image) {
        super(x, y, image);
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

    public abstract void animateSprite();

    public abstract void update();

}
