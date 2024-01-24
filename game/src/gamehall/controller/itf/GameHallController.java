package gamehall.controller.itf;

import gamehall.model.domain.Player;

import java.awt.*;

/**
 * 用来声明的
 */
public abstract class GameHallController {
    private  String GAMENAME;
    public abstract Component getGameView();
    public abstract Player getPlay();

    public  String getGAMENAME() {
        return GAMENAME;
    }

    public  void setGAMENAME(String GAMENAME) {
        this.GAMENAME = GAMENAME;
    }
}
