package uet.oop.bomberman;

public class Menu {

    private int gameState;

    private final int playState = 0;
    private final int optionState = 1;
    private final int menuState = 2;

    public int getPlayState() {
        return playState;
    }

    public int getOptionState() {
        return optionState;
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
        gameState = playState;
    }

    public void drawMenu() {

    }

    public void drawOption() {

    }

}
