package gamehall.controller;

import gamehall.View.DaDiShuView;
import gamehall.View.GameJFrame;
import gamehall.View.UI;
import gamehall.controller.itf.GameHallController;
import gamehall.controller.time.MouseTime;
import gamehall.model.domain.Player;
import gamehall.model.domain.mouse.Mouse;

import java.awt.*;

/**
 * 大数字控制器
 */
public class DaDiShuController extends GameHallController {
    private String GAMENAME = "打地鼠游戏";
    private static DaDiShuController instance;
    public static boolean gameOver = false;
    public static Integer count = 0;
    private Player player;
    private DaDiShuView daDiShuView;
    private Mouse mouse;
    private MouseTime mouseTime;

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
        player=new Player();
        mouseTime = new MouseTime(this);
        // LoginJFrame loginJFrame = ui.getLoginJFrame();
        GameJFrame gameJFrame = ui.getGameJFrame();
        gameJFrame.setVisible(true);


    }

    public void startGame() {
        mouseTime.setCountdownSeconds(60);
        mouseTime.getMouseTimer().start();
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
    public void showGameOver() {

    }

    /**
     * 结束的方法
     */
    public void goodBye() {

    }

    /**
     * 欢迎的方法
     */
    public void welcome() {

    }

    /**
     * 判断是否击中
     * @return boolean
     */
    public boolean isHitMouse() {
        Rectangle mouseRectangle=new Rectangle(mouse.getMouseX(),mouse.getMouseY(),mouse.getMouseW(),mouse.getMouseH());//地鼠矩形
        Rectangle playRectangle=new Rectangle(player.getPlayerX(),player.getPlayerY(),player.getChuiW(),player.getChuiH());//锤子矩形
        if (playRectangle.intersects(mouseRectangle)){
            if (!mouse.isHit()){
                mouse.setHit(true);
                System.out.println("打到了！");
            }
        }else {
            System.out.println("没打中");
        }
        return false;
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

    @Override
    public String toString() {
        return "DaDiShuController{" +
                "GAMENAME='" + GAMENAME + '\'' +
                ", player=" + player +
                ", daDiShuView=" + daDiShuView +
                ", mouse=" + mouse +
                ", mouseTime=" + mouseTime +
                ", ui=" + ui +
                '}';
    }
}
