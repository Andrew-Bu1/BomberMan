package uet.oop.bomberman;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import uet.oop.bomberman.entities.AnimateEntity.DynamicEntity.Bomber;
import uet.oop.bomberman.graphics.Sprite;

public class Menu {

    private int gameState;

    private final int playState = 0;
    private final int optionState = 1;
    private final int menuState = 2;
    private final int helpState = 3;
    private final int loseState = 4;
    private final int winState = 5;
    public final ClassLoader file = ClassLoader.getSystemClassLoader();

    private final Font menuFont = new Font("Arial", 40);
    private final Font optionFont = new Font("Arial", 25);
    private final Image menuImage = new Image(file.getResource("menu.png").toString());
    private final Image helpImage = new Image(file.getResource("helpMenu.png").toString());
    private final Image optionImage = new Image(file.getResource("option.png").toString());
    private final Image stateImage = new Image(file.getResource("state.png").toString());
    // private final Image optionImage = new
    // Image(file.getResource("Option.png").toString());

    private int menuButton = 0;

    private int optionButton = 0;

    private int stateButton = 0;

    public int getStateButton() {
        return stateButton;
    }

    public void increaseStateButton() {
        if (stateButton == 0) {
            stateButton = 1;
        } else {
            stateButton--;
        }
    }

    public void decreaseStateButton() {
        if (stateButton == 1) {
            stateButton = 0;
        } else {
            stateButton++;
        }
    }

    public int getOptionButton() {
        return optionButton;
    }

    public void increaseOptionButton() {
        if (optionButton == 0) {
            optionButton = 2;
        } else {
            optionButton--;
        }
    }

    public void decreaseOptionButton() {
        if (optionButton == 2) {
            optionButton = 0;
        } else {
            optionButton++;
        }
    }

    public int getMenuButton() {
        return menuButton;
    }

    public void increaseMenuButton() {
        if (menuButton == 0) {
            menuButton = 2;
        } else {
            menuButton--;
        }
    }

    public void decreaseMenuButton() {
        if (menuButton == 2) {
            menuButton = 0;
        } else {
            menuButton++;
        }
    }

    public int getPlayState() {
        return playState;
    }

    public int getOptionState() {
        return optionState;
    }

    public int getHelpState() {
        return helpState;
    }

    public int getMenuState() {
        return menuState;
    }

    public int getLoseState() {
        return loseState;
    }

    public int getWinState() {
        return winState;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public Menu() {
        gameState = menuState;
    }

    public void drawMenu(GraphicsContext gc) {
        gc.drawImage(menuImage, 0, 0);
        gc.setFill(Color.BLACK);
        gc.setFont(menuFont);
        gc.fillText("New Game", 7 * Sprite.SCALED_SIZE, 7 * Sprite.SCALED_SIZE);

        if (menuButton == 0) {
            gc.fillText(">", 6 * Sprite.SCALED_SIZE, 7 * Sprite.SCALED_SIZE);
            gc.fillText("<", 13.25 * Sprite.SCALED_SIZE, 7 * Sprite.SCALED_SIZE);
        }
        gc.fillText("Help", 8.75 * Sprite.SCALED_SIZE, 9 * Sprite.SCALED_SIZE);

        if (menuButton == 1) {
            gc.fillText(">", 7.75 * Sprite.SCALED_SIZE, 9 * Sprite.SCALED_SIZE);
            gc.fillText("<", 11.5 * Sprite.SCALED_SIZE, 9 * Sprite.SCALED_SIZE);
        }
        gc.fillText("Exit", 8.75 * Sprite.SCALED_SIZE, 11 * Sprite.SCALED_SIZE);

        if (menuButton == 2) {
            gc.fillText(">", 7.75 * Sprite.SCALED_SIZE, 11 * Sprite.SCALED_SIZE);
            gc.fillText("<", 11 * Sprite.SCALED_SIZE, 11 * Sprite.SCALED_SIZE);
        }

    }

    public void drawhelpMenu(GraphicsContext gc) {
        gc.drawImage(helpImage, 0, 0);

    }

    public void drawVictory(GraphicsContext gc) {
        gc.drawImage(stateImage, 0, 0);
        gc.setFill(Color.BLACK);
        gc.fillText("Play Again", 7.75 * Sprite.SCALED_SIZE, 8 * Sprite.SCALED_SIZE);
        gc.fillText("Return Menu", 7 * Sprite.SCALED_SIZE, 9 * Sprite.SCALED_SIZE);

        if (stateButton == 0) {
            gc.fillText(">", 6.75 * Sprite.SCALED_SIZE, 8 * Sprite.SCALED_SIZE);
        }

        if (stateButton == 1) {
            gc.fillText(">", 6 * Sprite.SCALED_SIZE, 9 * Sprite.SCALED_SIZE);
        }
        gc.fillText("You Win", 7.75 * Sprite.SCALED_SIZE, 4 * Sprite.SCALED_SIZE);
        gc.fillText("Score: " + Bomber.highscore, 7.75 * Sprite.SCALED_SIZE, 6 * Sprite.SCALED_SIZE);

    }

    public void drawLose(GraphicsContext gc) {
        gc.drawImage(stateImage, 0, 0);
        gc.setFill(Color.BLACK);
        gc.fillText("Play Again", 7.75 * Sprite.SCALED_SIZE, 8 * Sprite.SCALED_SIZE);
        gc.fillText("Return Menu", 7 * Sprite.SCALED_SIZE, 9 * Sprite.SCALED_SIZE);

        if (stateButton == 0) {
            gc.fillText(">", 6.75 * Sprite.SCALED_SIZE, 8 * Sprite.SCALED_SIZE);
        }

        if (stateButton == 1) {
            gc.fillText(">", 6 * Sprite.SCALED_SIZE, 9 * Sprite.SCALED_SIZE);
        }
        gc.fillText("You Lose", 7.75 * Sprite.SCALED_SIZE, 4 * Sprite.SCALED_SIZE);
        gc.fillText("Score: " + Bomber.highscore, 7.75 * Sprite.SCALED_SIZE, 6 * Sprite.SCALED_SIZE);
    }

    public void drawOption(GraphicsContext gc) {
        gc.drawImage(optionImage, Sprite.SCALED_SIZE * 7, Sprite.SCALED_SIZE * 5);
        gc.setFont(optionFont);

        gc.fillText("Music: " + (Sound.isMusicOn() ? "On" : "Off"), Sprite.SCALED_SIZE * 8, Sprite.SCALED_SIZE * 6.5);
        if (optionButton == 0) {
            gc.fillText(">", Sprite.SCALED_SIZE * 7.5, Sprite.SCALED_SIZE * 6.5);
        }
        gc.fillText("Effect: " + (Sound.isEffectOn() ? "On" : "Off"), Sprite.SCALED_SIZE * 8, Sprite.SCALED_SIZE * 7.5);
        if (optionButton == 1) {
            gc.fillText(">", Sprite.SCALED_SIZE * 7.5, Sprite.SCALED_SIZE * 7.5);
        }
        gc.fillText("Return Menu", Sprite.SCALED_SIZE * 8, Sprite.SCALED_SIZE * 8.5);
        if (optionButton == 2) {
            gc.fillText(">", Sprite.SCALED_SIZE * 7.5, Sprite.SCALED_SIZE * 8.5);
        }
    }

}
