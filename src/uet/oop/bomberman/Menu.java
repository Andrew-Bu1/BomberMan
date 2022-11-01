package uet.oop.bomberman;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import uet.oop.bomberman.graphics.Sprite;

public class Menu {

    private int gameState;

    private final int playState = 0;
    private final int optionState = 1;
    private final int menuState = 2;
    private final int helpState = 3;
    public final ClassLoader file = ClassLoader.getSystemClassLoader();

    private final Font menuFont = new Font("Arial", 40);
    private final Image menuImage = new Image(file.getResource("menu.png").toString());
    private final Image helpImage = new Image(file.getResource("helpMenu.png").toString());
    private final Image optionImage = new Image(file.getResource("option.png").toString());
    // private final Image optionImage = new
    // Image(file.getResource("Option.png").toString());

    private int menuButton = 0;

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
        gc.setEffect(null);
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

    }

    public void drawLose(GraphicsContext gc) {

    }

    public void drawOption(GraphicsContext gc) {
        gc.drawImage(optionImage, Sprite.SCALED_SIZE * 7, Sprite.SCALED_SIZE * 5);
    }

}
