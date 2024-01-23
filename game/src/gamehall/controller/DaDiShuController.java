package gamehall.controller;

import gamehall.View.UI;
import gamehall.dao.MouseFactory;
import gamehall.model.domain.Bomb;
import gamehall.model.domain.Map;
import gamehall.model.domain.MouseMap;
import gamehall.model.domain.Player;
import gamehall.model.domain.mouse.Mouse;

/**
 * 大数字控制器
 */
public class DaDiShuController implements GameHallController{

    private static DaDiShuController instance;
    public static boolean gameOver = false;
    public static Integer count = 0;
    private Player player;
    private Map mouseMap;
    private Mouse mouse;
    private Bomb bomb=new Bomb();
    private UI ui;

    private DaDiShuController() {

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
        gameOver=false;
        count=0;
        mouseMap = new MouseMap();
        player = new Player(mouseMap);
        player.customMap();
        player.setUsername(UserController.UserName);

    }

    /**
     * 显示窗口
     */
    public void show() {
        initDaDiShuGame();
        welcome(); // 欢迎
        while (!gameOver) {
            mouse = MouseFactory.getInstance().createRandomMouse();
            mouse.randomMouse(mouseMap);// 随机地鼠的方法
            bomb.randomMouse(mouseMap);//随机一个炸弹
            mouseMap.plantBoard();// 绘制棋盘的方法
            player.hitMouse(mouse);// 打地鼠的方法
            DaDiShuController.count++; // 每一轮结束后计数器加一
            if (DaDiShuController.count >= 3) { // 指定的回合数
                gameOver = true;
            }
        }
        showGameOver();
        goodBye();
    }

    /**
     * 游戏结束
     */
    private void showGameOver() {
        System.out.println(player.getUsername()+"的得分：" + player.getPlayerScore() + "分");
        System.out.println("总的游玩次数：" + count);
    }

    /**
     * 结束的方法
     */
    private void goodBye() {
        System.out.println("游戏结束，回到大厅~");
    }

    /**
     * 欢迎的方法
     */
    private void welcome() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + player.getUsername() + "欢迎开始打地鼠(回合数为3)~输入对应的坐标进行击打~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    public static void main(String[] args) {
        new DaDiShuController();
    }


    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }
}
