package gamehall.entry;

import gamehall.controller.DaDiShuController;
import gamehall.controller.UserController;

import java.util.Scanner;

public class GameHall {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserController userController = new UserController();
    private static  DaDiShuController diShuController;


    public static void Run() {
        //1 暂时默认开启打地鼠游戏
        diShuController=DaDiShuController.getInstance();
        diShuController.show();
    }
}
