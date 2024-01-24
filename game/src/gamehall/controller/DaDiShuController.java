package gamehall.controller;

import gamehall.View.DaDiShuView;
import gamehall.View.GameJFrame;
import gamehall.View.LoginJFrame;
import gamehall.View.UI;
import gamehall.controller.itf.GameHallController;
import gamehall.controller.time.MouseTime;
import gamehall.model.domain.Bomb;
import gamehall.model.domain.Map;
import gamehall.model.domain.Player;
import gamehall.model.domain.mouse.Mouse;

import java.awt.*;

/**
 * 大数字控制器
 */
public class DaDiShuController extends GameHallController {
    private  String GAMENAME="打地鼠游戏";
    private static DaDiShuController instance;
    public static boolean gameOver = false;
    public static Integer count = 0;
    private Player player;
    private DaDiShuView daDiShuView;
    private Map mouseMap;
    private Mouse mouse;
    private Bomb bomb = new Bomb();

    private UI ui;

    private DaDiShuController() {
        daDiShuView = new DaDiShuView(this);
    }

    public static DaDiShuController getInstance() {
        if (instance == null) {
            instance = new DaDiShuController();
        }
        return instance;
    }

    /**
     * 初始化打地鼠游戏
     */
    private void initDaDiShuGame() {
        setMouse(new Mouse());
        ui = new UI(this);
        MouseTime mouseTime = new MouseTime(this);
        mouseTime.getMouseTimer().start();
        LoginJFrame loginJFrame = ui.getLoginJFrame();
        GameJFrame gameJFrame = ui.getGameJFrame();
        gameJFrame.setVisible(true);

        // gameOver=false;
        // count=0;
        // mouseMap = new MouseMap();
        // player = new Player(mouseMap);
        // player.customMap();
        // player.setUsername(UserController.UserName);
    }

    /**
     * 显示窗口
     */
    public void show() {
        initDaDiShuGame();
    }

    @Override
    public Component getGameView() {
        return daDiShuView;
    }

    @Override
    public Player getPlay() {
        return player;
    }

    /**
     * 游戏结束
     */
    private void showGameOver() {

    }

    /**
     * 结束的方法
     */
    private void goodBye() {

    }

    /**
     * 欢迎的方法
     */
    private void welcome() {

    }

    @Override
    public String getGAMENAME() {
        return GAMENAME;
    }

    @Override
    public void setGAMENAME(String GAMENAME) {
        this.GAMENAME = GAMENAME;
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public DaDiShuView getDaDiShuView() {
        return daDiShuView;
    }

    public void setDaDiShuView(DaDiShuView daDiShuView) {
        this.daDiShuView = daDiShuView;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

}
