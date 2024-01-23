package gamehall.View;

import gamehall.controller.DaDiShuController;
import gamehall.controller.GameHallController;

/**
 * @author :罗汉
 * @date : 2024/1/23
 */
public class UI {
    private LoginJFrame loginJFrame;
    private GameJFrame gameJFrame;
    private GameHallController gameHallController;

    public UI(GameHallController gameHallController) {
        this.gameHallController = gameHallController;
        loginJFrame=new LoginJFrame(this.gameHallController);
        gameJFrame=new GameJFrame((DaDiShuController) this.gameHallController);
    }

    public LoginJFrame getLoginJFrame() {
        return loginJFrame;
    }

    public void setLoginJFrame(LoginJFrame loginJFrame) {
        this.loginJFrame = loginJFrame;
    }

    public GameJFrame getGameJFrame() {
        return gameJFrame;
    }

    public void setGameJFrame(GameJFrame gameJFrame) {
        this.gameJFrame = gameJFrame;
    }

    public GameHallController getGameHallController() {
        return gameHallController;
    }

    public void setGameHallController(GameHallController gameHallController) {
        this.gameHallController = gameHallController;
    }
}
