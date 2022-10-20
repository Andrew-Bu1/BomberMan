package uet.oop.bomberman;

import javafx.scene.input.KeyEvent;
import static uet.oop.bomberman.BombermanGame.bomberman;

public class handleKey {
    private boolean pressUp;
    private boolean pressDown;
    private boolean pressLeft;
    private boolean pressRight;
    private boolean isMoving;

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public handleKey() {
        pressDown = pressLeft = pressRight = pressUp = false;
        isMoving = false;
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
                bomberman.placeBomb();
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