package gamehall.model.domain;

import gamehall.common.ErrorCode;
import gamehall.constant.GameConstant;
import gamehall.controller.DaDiShuController;
import gamehall.exception.BusinessException;
import gamehall.model.domain.mouse.Mouse;

import java.util.Scanner;

/**
 * 玩家
 * 账户、姓名、金钱、（名称，坐标，得分，自定义地图方法，输入坐标打地鼠方法）
 */
public class Player extends User {
    private String playerName;
    private int playerX;
    private int playerY;
    private int playerScore;
    private MapInterface map;

    public Player() {
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public Player(MapInterface map) {
        this.map = map;
    }

    /**
     * 自定义地图
     */
    public void customMap(){
        Map mouseMap= (Map)map;
        Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("请输入你想要的宽度");
                playerX=scanner.nextInt();
                mouseMap.setColSize(playerX);
                //
                // mouseMap.setColSize(5);
                System.out.println("请输入你想要的高度");
                playerY=scanner.nextInt();
                mouseMap.setRowSize(playerY);
                //
                // mouseMap.setRowSize(5);
                mouseMap.initializeBoard();
                if (playerX>mouseMap.getColSize()||playerY>mouseMap.getRowSize()){
                    System.out.println("超出地图坐标");
                }else {
                    break;
                }
            }
    }

    public void hitMouse(Mouse mouse){
        MouseMap mouseMap= (MouseMap)map;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\n请输入你要击打的Y坐标 输入负数出");
            playerY=scanner.nextInt();
            if (playerY < 0) {
                DaDiShuController.gameOver=true;
                return;
            }
            System.out.println("请输入你要击打的X坐标 输入-1退出");
            playerX=scanner.nextInt();
            if (playerX < 0) {
                DaDiShuController.gameOver=true;
                return;
            }
            if (playerX>mouseMap.getColSize()-1||playerY>mouseMap.getRowSize()-1){
                System.out.println("超出地图坐标");
            }else {
                break;
            }
        }
        String[][] mouseBoard = mouseMap.getMouseBoard();
        String mouseType = mouseBoard[playerY][playerX];
        switch (mouseType) {
            case GameConstant.YELLOW_MOUSE:
                this.playerScore += 1;
                System.out.println("击中白老鼠！得1分");
                mouse.cry();
                break;
            case GameConstant.FIELD_MOUSE:
                this.playerScore += 2;
                System.out.println("击中田鼠！得2分");
                mouse.cry();
                break;
            case GameConstant.TUBO_MOUSE:
                this.playerScore += 3;
                System.out.println("击中土拨鼠！得3分");
                mouse.cry();
                break;
            case GameConstant.ZHA_DAN:
                try {
                    throw new BusinessException(ErrorCode.ZHADAN_ERROR,"击中炸弹！游戏结束");
                } catch (BusinessException e) {
                    e.printStackTrace();
                }
                System.out.println("击中炸弹！游戏结束");
                DaDiShuController.gameOver=true;
                break;
            default:
                this.playerScore -= 1; // 未击中老鼠扣1分
                System.out.println("未击中老鼠！扣1分");
        }
        mouseMap.initializeBoard();
    }
}
