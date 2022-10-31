package uet.oop.bomberman.entities.StaticEntity.Items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.StaticEntity.StaticEntity;

public abstract class Item extends StaticEntity {

    public Item(int xUnit, int yUnit, Image img) {
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
