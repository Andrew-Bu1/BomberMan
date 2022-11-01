package uet.oop.bomberman;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.menu;

public class handleKey {
    private boolean pressUp = false;
    private boolean pressDown = false;
    private boolean pressLeft = false;
    private boolean pressRight = false;
    private boolean isHolding = false;

    public boolean isHolding() {
        return isHolding;
    }

    public handleKey(Scene scene) {
        scene.setOnKeyPressed(event -> {
            pressKey(event);
        });

        scene.setOnKeyReleased(event -> {
            releaseKey(event);
        });
    }

    public void setHolding(boolean isHolding) {
        this.isHolding = isHolding;
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

    public void pressKey(KeyEvent e) {
        if (menu.getGameState() == menu.getMenuState()) {
            if (Sound.isMusicOn() && !Sound.isPlaying()) {
                Sound.playMusic("menuMusic");
            }
            if (e.getCode() == KeyCode.UP) {
                if (Sound.isEffectOn()) {
                    Sound.playEffect("menuMove");
                }
                menu.increaseMenuButton();
            } else if (e.getCode() == KeyCode.DOWN) {
                if (Sound.isEffectOn()) {
                    Sound.playEffect("menuMove");
                }
                menu.decreaseMenuButton();
            }

            if (e.getCode() == KeyCode.ENTER) {
                if (Sound.isEffectOn()) {
                    Sound.playEffect("menuEntered");
                }
                if (menu.getMenuButton() == 0) {
                    Sound.stopMusic();
                    menu.setGameState(menu.getPlayState());
                } else if (menu.getMenuButton() == 1) {
                    menu.setGameState(menu.getHelpState());
                } else if (menu.getMenuButton() == 2) {
                    BombermanGame.logout(BombermanGame.stageGame);
                }
            }
        } else if (menu.getGameState() == menu.getHelpState()) {
            if (e.getCode() == KeyCode.ENTER) {
                if (Sound.isEffectOn()) {
                    Sound.playEffect("menuEntered");
                }
                menu.setGameState(menu.getMenuState());
            }
        } else if (e.getCode() == KeyCode.P) {
            if (Sound.isEffectOn()) {
                Sound.playEffect("menuMove");
            }
            if (menu.getGameState() == menu.getPlayState()) {
                menu.setGameState(menu.getOptionState());
            } else if (menu.getGameState() == menu.getOptionState()) {
                menu.setGameState(menu.getPlayState());
            }
        }

        if (menu.getGameState() == menu.getPlayState()) {
            if (Sound.isMusicOn() && !Sound.isPlaying()) {
                Sound.playMusic("background");
            }
            switch (e.getCode()) {
                case W:
                    pressUp = true;
                    setHolding(true);
                    break;
                case A:
                    pressLeft = true;
                    setHolding(true);
                    break;
                case D:
                    pressRight = true;
                    setHolding(true);
                    break;
                case S:
                    pressDown = true;
                    setHolding(true);
                    break;
                case SPACE:
                    if (Sound.isEffectOn()) {
                        Sound.playEffect("bombPut");
                    }
                    bomberman.placeBomb();
                    break;
                default:
                    break;
            }
        }

    }

    public void releaseKey(KeyEvent e) {
        switch (e.getCode()) {
            case W:
                pressUp = false;
                setHolding(false);
                break;
            case A:
                pressLeft = false;
                setHolding(false);
                break;
            case D:
                pressRight = false;
                setHolding(false);
                break;
            case S:
                pressDown = false;
                setHolding(false);
                break;
            default:
                break;
        }
    }

}