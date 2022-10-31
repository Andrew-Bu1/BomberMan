package uet.oop.bomberman.entities.StaticEntity.Blocks;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.StaticEntity.StaticEntity;

public abstract class Block extends StaticEntity {

    public Block(int xUnit, int yUnit) {
        super(xUnit, yUnit);
    }

    public Block(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

}
