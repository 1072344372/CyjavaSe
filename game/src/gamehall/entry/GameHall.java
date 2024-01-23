package gamehall.entry;

import gamehall.View.GameJFrame;
import gamehall.View.LoginJFrame;
import gamehall.View.UI;
import gamehall.controller.DaDiShuController;
import gamehall.controller.UserController;

import java.util.Scanner;

public class GameHall {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserController userController = new UserController();
    private static  DaDiShuController diShuController;


    public static void Run() {
        //开启全部画面！
        diShuController=DaDiShuController.getInstance();
        UI ui = new UI(diShuController);
        LoginJFrame loginJFrame = ui.getLoginJFrame();
        GameJFrame gameJFrame = ui.getGameJFrame();
        do {
            if (!UserController.isLogin) {
                // userController.show();
                loginJFrame.setVisible(true);
            }

            System.out.println("--------欢迎来到趣玩中心--------");
            System.out.println("请输入您的选择: 1.打地鼠游戏  0.退出登录 -1.退出");
            String next = scanner.next();
            switch (next) {
                case "1":
                    diShuController.show();
                    break;
                case "2":
                    break;
                case "0":
                    UserController.isLogin=false;
                    UserController.flag=true;
                    userController.show();
                    break;
                case "-1":
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
        } while (true);
    }
}
