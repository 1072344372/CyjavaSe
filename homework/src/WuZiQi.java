import java.util.Random;
import java.util.Scanner;

public class WuZiQi {
    public static void main(String[] args) {
        welcome();
        Scanner sc = new Scanner(System.in);
        // 范围
        final int SIZE = 10;
        // 边界
        final int BORDER = SIZE - 1;
        // 创建棋盘
        char[][] qiPan = new char[SIZE][SIZE];
        // 初始化棋盘的方法
        initQiPan(SIZE, BORDER, qiPan);
        printQiPan(qiPan);
        // 声明行列变量
        int row, col;
        boolean color = false;
        ///////////////////////////////////////////////////////////////////////////
        while (true) {
            do {
                System.out.print("请输入行号，输入负数退出）：");
                row = sc.nextInt();
                if (row < 0) return;
            } while (row > BORDER);
            do {
                System.out.print("请输入列号，输入负数退出）：");
                col = sc.nextInt();
                if (col < 0) return;
            } while (col > BORDER);
            // 用户下棋
            qiPan[row][col] = '●';
            printQiPan(qiPan);
            // 电脑随机下棋
            randomXiaQi(qiPan);

            System.out.println();// 换行
        }
    }

    private static void welcome() {
        System.out.println("欢迎来到五子棋");
    }

    /**
     * 随机下旗
     *
     * @param qiPan 气盘
     */
    private static void randomXiaQi(char[][] qiPan) {
        System.out.println("\n电脑随机下棋");
        ///TODO: 判断电脑下棋是否已满
        Random random = new Random();
        int SIZE = qiPan.length;

        while (true) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            if (!(qiPan[row][col] == '○') && !(qiPan[row][col] == '●')) {
                qiPan[row][col] = '○';
                break; // 下棋后返回
            }
        }
        printQiPan(qiPan);
    }

    /**
     * Init qi pan
     *
     * @param SIZE   大小
     * @param BORDER 边境
     * @param qiPan  气盘
     */
    private static void initQiPan(int SIZE, int BORDER, char[][] qiPan) {
        // 两层循环画中心
        for (int i = 0; i < SIZE; i++) for (int j = 0; j < SIZE; j++) qiPan[i][j] = '┼';
        // 画边
        for (int i = 1; i < BORDER; i++) {
            qiPan[0][i] = '┬';
            qiPan[BORDER][i] = '┴';
            qiPan[i][0] = '├';
            qiPan[i][BORDER] = '┤';
        }
        // 直接画角
        qiPan[0][0] = '┌';
        qiPan[0][BORDER] = '┐';
        qiPan[BORDER][0] = '└';
        qiPan[BORDER][BORDER] = '┘';
    }

    /**
     * 是否有效输入
     *
     * @param userNum 用户num
     * @return boolean
     */
    private static boolean isValidInput(String userNum, int size) {
        // TODO: 合法输入
        String[] split = userNum.split(",");
        // 情况1 没有输入',' 或者输入多个',' 或者输入的不是英文的','
        if (split.length != 2) return false;
        // 情况2 输入的坐标不是数字
        int x = 0, y = 0;
        try {
            x = Integer.parseInt(split[0]);
            y = Integer.parseInt(split[0]);
        } catch (NumberFormatException e) {
            return false;
        }
        // 情况3 输入的坐标大于棋盘的长度
        if (x > size || y > size) return false;
        // 情况4 输入的坐标上已经有了棋子


        return true;
    }

    /**
     * 刷新棋盘 重新打印棋盘
     *
     * @param qiPan 传入的棋盘数组
     */
    private static boolean printQiPan(char[][] qiPan) {

        // for (int i = 0; i < qiPan.length; i++) {
        //     System.out.print(qiPan[i]);
        //     System.out.println(i);
        // }
        // 优化打印
        for (int i = 0; i < qiPan.length; System.out.println(i++)) System.out.print(qiPan[i]);

        // 画棋盘底部
        for (int i = 0; i < qiPan.length; i++) {
            System.out.print(i + " ");
        }

        // 判断棋盘是否画满
        return isGameOver(qiPan);
    }

    /**
     * 游戏结束了吗?
     *
     * @param qiPan 识字课
     * @return boolean
     */
    private static boolean isGameOver(char[][] qiPan) {
        boolean isGameOver = true;
        // 弃用，改用计数判断
        // for (char[] aChar : qiPan) {
        //     for (char c : aChar) {
        //         if (c == '十') {
        //             isGameOver = false;
        //             break;
        //         }
        //     }
        // }
        // 情况1  下子个数达到SIZE*SIZE（下满棋盘）

        // 情况2  横向，纵向 达到5个
        // TODO： 游戏结束的判断逻辑
        // 情况3  斜着达到5个
        return isGameOver;
    }
}
