package uet.oop.bomberman;

import javafx.scene.input.KeyEvent;
import static uet.oop.bomberman.entities.Bomber.bombPlaced;

public class handleKey {
    private boolean pressUp, pressDown, pressLeft, pressRight;
    private boolean isMoving;
    private boolean isPress;

    public handleKey() {
        pressDown = pressLeft = pressRight = pressUp = false;
        isMoving = false;
    }

    public void setPress(boolean isPress) {
        this.isPress = isPress;
    }

    public boolean isPress() {
        return isPress;
    }

    public boolean isPressUp() {
        return pressUp;
    }

    public boolean isPressDown() {
        return pressDown;
    }

    public boolean isPressLeft() {
        return pressLeft;
    }

    public boolean isPressRight() {
        return pressRight;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public void pressKey(KeyEvent e) {
        switch (e.getCode()) {
            case W:
                pressUp = true;
                break;
            case A:
                pressLeft = true;
                break;
            case D:
                pressRight = true;
                break;
            case S:
                pressDown = true;
                break;
            case SPACE:
                bombPlaced = true;
                break;
            default:
                break;
        }
    }

    public void releaseKey(KeyEvent e) {
        switch (e.getCode()) {
            case W:
                pressUp = false;
                break;
            case A:
                pressLeft = false;
                break;
            case D:
                pressRight = false;
                break;
            case S:
                pressDown = false;
                break;
            default:
                break;
        }
    }

}