package uet.oop.bomberman.entities.StaticEntity.HiddenBlock;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.StaticEntity.StaticEntity;

public abstract class HiddenBlock extends StaticEntity {

    public HiddenBlock(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    protected boolean isOff = false;

    public void setOff(boolean isOff) {
        this.isOff = isOff;
    }

    public boolean isOff() {
        return isOff;
    }
}
