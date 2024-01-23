

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class suzu12_26 {
    public static void main(String[] args) {
        // 不死神兔
        // method1();

        // 五子棋
        method2_1();

        // 打地鼠
        // method3();

        // 五子棋（有待更新）
        // method2();
    }

    /**
     * 使用char类型二维数组构建，元素全部为'-'，(行数和列数随意，比如从1行1列 到 9行9列  都行)
     * 展示全部为'-'的空棋盘，展示行号与列号
     * 提示玩家输入行与列，玩家输入后，对应位置改为'o'
     * 玩家先手，落子不能落在已存在的棋子处，也不能超出数组的范围
     * 展示玩家落子后的棋盘状态
     * 电脑后手，随机坐标进行落子，对应位置改为'x'
     * 电脑随机坐标时，必须随机在空位
     * 展示电脑落子后棋盘的状态
     * 判断结束：只要棋盘被填满，程序结束
     */
    private static void method2_1() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int count = 0; // 游戏次数
        int rowSIZE = random.nextInt(9)+1;// 行的最大值
        int colSIZE = random.nextInt(9)+1;;// 列的最大值
        int rowBORDER = rowSIZE - 1;// 边界值
        int colBORDER = colSIZE - 1;// 边界值
        int row = 0;// 用户输入的行
        int col = 0;// 用户输入的列
        char[][] qiPan = new char[rowSIZE][colSIZE]; // 初始化4行5列的二维数组，表示地洞位置
        for (char[] chars : qiPan) Arrays.fill(chars, '-');
        //初始化绘制一次
        // 画列的提示数字
        for (int i = 0; i < colSIZE; i++) {
            System.out.print(i);
        }
        System.out.println();
        // 画棋盘内容
        for (int i = 0; i < qiPan.length; System.out.println(i++)) System.out.print(qiPan[i]);

        while (count < rowSIZE * colSIZE) {
            //用户输入 2个do while
            do {
                System.out.print("请输入行号，输入负数退出）：");
                row = scanner.nextInt();
                if (row < 0) return;
            } while (row > rowBORDER);
            do {
                System.out.print("请输入列号，输入负数退出）：");
                col = scanner.nextInt();
                if (col < 0) return;
            } while (col > colBORDER);
            qiPan[row][col] = 'x';

            // 画列的提示数字
            for (int i = 0; i < colSIZE; i++) {
                System.out.print(i);
            }
            System.out.println();
            // 画棋盘内容
            for (int i = 0; i < qiPan.length; System.out.println(i++)) System.out.print(qiPan[i]);

            count++;
            if (count == rowSIZE * colSIZE) break;
            System.out.println("\n电脑随机下棋");
            while (true) {
                row = random.nextInt(rowSIZE);
                col = random.nextInt(colSIZE);
                // System.out.println("电脑随机下的位置是:（"+row+","+col+")");
                if ((qiPan[row][col] != 'x')) {
                    qiPan[row][col] = 'x';
                    break; // 下棋后返回
                }
            }

            // 画列的提示数字
            for (int i = 0; i < colSIZE; i++) {
                System.out.print(i);
            }
            System.out.println();
            // 画棋盘内容
            for (int i = 0; i < qiPan.length; System.out.println(i++)) System.out.print(qiPan[i]);

            count++;
        }
        System.out.println("游戏结束");
    }

    /**
     * 初始化char类型的二维数组（4行5列）或随机（5 -9）  ，每个洞都是大写字母 O
     * 游戏循环10次,展示游戏地图的行号和列号
     * 地鼠随机出现在二维数组中的某个元素位置，即随机行与列，X
     * 提示玩家击打。输入行与列（ 两次 nextInt() ）
     * 判断是否打中
     * 击中得2分，未击中扣1分（乱输入数字也视为没打中）
     * 游戏结束，统计击中次数，未击中次数 和最后的得分。
     * 中途可以 只输入行 99重新开始，只输入行 88退出游戏
     */
    private static void method3() {
        System.out.println("欢迎开始打地鼠~输入对应的需要进行击打");
        //////////////////////////////////////////////////////////////////////////////
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int count = 0; // 游戏次数
        int result = 0; // 游戏分数
        int rowSIZE = 4;// 行的最大值
        int colSIZE = 5;// 列的最大值
        char[][] arr = new char[rowSIZE][colSIZE]; // 初始化4行5列的二维数组，表示地洞位置
        //////////////////////////////////////////////////////////////////////////////
        int randomRow = random.nextInt(rowSIZE); // 随机地鼠位置的行
        int randomCol = random.nextInt(colSIZE); // 随机地鼠位置的列
        arr[randomRow][randomCol] = 1; // 在随机位置放置地鼠
        while (true) {
            System.out.print("   ");
            for (int i = 1; i <= colSIZE; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 1; i <= rowSIZE; i++) {
                System.out.print(i + "  ");
                for (int j = 1; j <= colSIZE; j++) {
                    System.out.print(arr[i - 1][j - 1] == 1 ? "x " : "o ");
                }
                System.out.println();
            }
            System.out.println("------------------------------------------\n请输入对应行和列进行击打，输入99重新开始游戏，输入88退出游戏");
            int row = scanner.nextInt();
            if (row == 88) {
                break;
            } else if (row == 99) {
                result = 0;
                count = 0;
                randomRow = random.nextInt(rowSIZE);
                randomCol = random.nextInt(colSIZE);
                arr = new char[rowSIZE][colSIZE]; // 重新初始化地洞位置
                arr[randomRow][randomCol] = 1; // 放置新的地鼠
            } else {
                int col = scanner.nextInt();
                if (row < 1 || row > rowSIZE || col < 1 || col > colSIZE) {
                    System.out.println("请输入有效行列数进行击打！");
                    continue;
                }
                if (arr[row - 1][col - 1] == 1) {
                    result += 2;
                    System.out.println("击中地鼠！得2分");
                    count++;
                    if (count == 10) break;
                    randomRow = random.nextInt(rowSIZE);
                    randomCol = random.nextInt(colSIZE);
                    arr = new char[rowSIZE][colSIZE]; // 重新初始化地洞位置
                    arr[randomRow][randomCol] = 1; // 放置新的地鼠
                } else {
                    result -= 1;
                    System.out.println("未击中地鼠！扣1分");
                }
            }
        }
        System.out.println("游戏结束");
        System.out.println("您的得分：" + result + "分");
    }


    /**
     * 使用char类型二维数组构建，元素全部为'-'，(行数和列数随意，比如从1行1列 到 9行9列  都行)
     * 展示全部为'-'的空棋盘，展示行号与列号
     * 提示玩家输入行与列，玩家输入后，对应位置改为'o'
     * 玩家先手，落子不能落在已存在的棋子处，也不能超出数组的范围
     * 展示玩家落子后的棋盘状态
     * 电脑后手，随机坐标进行落子，对应位置改为'x'
     * 电脑随机坐标时，必须随机在空位
     * 展示电脑落子后棋盘的状态
     * 判断结束：只要棋盘被填满，程序结束
     */
    private static void method2() {//○、●、○、■、十、├、┬、┴、┤、┌、┐、└、┘\
        ////////////////////////////////////////////////////////////////////////定义变量、初始化
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        // 范围
        final int SIZE = 3;
        // 边界
        final int BORDER = SIZE - 1;
        // 创建棋盘
        char[][] qiPan = new char[SIZE][SIZE];
        // 初始化棋盘的方法
        initQiPan(SIZE, BORDER, qiPan);
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
        ///////////////////////////////////////////////////////////////////////////
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

    /**
     * 不死兔神：有一对兔子，从出生后第3个月起每个月都生一对兔子，
     * 小兔子长到第三个月后每个月又生一对小兔子，假如兔子都不死，问第二十个月的兔子对有多少对？
     * 1,1,2,3,5,8,13
     * 找出规律就行
     */
    private static void method1() {
        Scanner scanner = new Scanner(System.in);
        // int res = getTuZi(scanner.nextInt());//递归
        int res = getTuZi2(scanner.nextInt());// 循环
        System.out.println("第20个月的兔子：" + res);
    }

    private static int getTuZi2(int nextInt) {
        int[] arr = new int[nextInt];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < nextInt; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        // System.out.println(Arrays.toString(arr));
        return arr[nextInt - 1];
    }

    private static int getTuZi(int n) {
        if (n >= 1) {
            if (n == 1 || n == 2) {
                return 1;
            } else {
                return getTuZi(n - 1) + getTuZi(n - 2);
            }
        } else {
            System.out.println("要求输入的 n>=1 的整数");
            return -1;
        }
    }
}
