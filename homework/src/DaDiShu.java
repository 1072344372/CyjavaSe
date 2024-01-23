import java.util.Random;
import java.util.Scanner;

public class DaDiShu {
    public static void main(String[] args) {
        welcome(); // 欢迎
        ///////////////////////////////////变量定义
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int playCount = 0;
        int result = 0;
        int rowSIZE = 4;
        int colSIZE = 5;
        char[][] arr = new char[rowSIZE][colSIZE];
        ///////////////////////////////////
        initHole(arr); // 初始化

        while (true) {
            showHole(arr);
            System.out.println(
                    "------------------------------------------\n请输入对应行和列进行击打，输入99重新开始游戏，输入88退出游戏");
            int row = scanner.nextInt();
            if (row == 88) {
                break;
            } else if (row == 99) {
                result = 0;
                count = 0;
                playCount = 0;
                initHole(arr); // 重新初始化地洞位置
            } else {
                int col = scanner.nextInt();
                if (row < 1 || row > rowSIZE || col < 1 || col > colSIZE) {
                    System.out.println("请输入有效行列数进行击打！");
                    continue;
                }
                playCount++;
                if (arr[row - 1][col - 1] == 'x') {
                    result += 2;
                    System.out.println("击中地鼠！得2分");
                    count++;

                    if (count == 10) {
                        break;
                    }

                    initHole(arr);
                } else {
                    result -= 1;
                    System.out.println("未击中地鼠！扣1分");
                }
            }
        }

        showOver(count, result, playCount);
    }

    // 欢迎的方法
    private static void welcome() {
        System.out.println("欢迎开始打地鼠~输入对应的需要进行击打");
    }

    // 初始化洞穴的方法
    private static void initHole(char[][] arr) {
        // 初始化地洞，将数组元素设置为 'o'
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 'o';
            }
        }
        mouseAppear(arr);//随机地鼠
    }

    // 展示地洞
    private static void showHole(char[][] arr) {
        System.out.print("   ");
        for (int i = 1; i <= arr[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= arr.length; i++) {
            System.out.print(i + "  ");
            for (int j = 1; j <= arr[i - 1].length; j++) {
                System.out.print(arr[i - 1][j - 1] + " ");
            }
            System.out.println();
        }
    }

    // 随机出现地鼠
    private static void mouseAppear(char[][] arr) {
        Random random = new Random();
        int randomRow = random.nextInt(arr.length);
        int randomCol = random.nextInt(arr[0].length);
        arr[randomRow][randomCol] = 'x';
    }

    // 游戏结束统计展示
    private static void showOver(int a, int b, int c) {
        System.out.println("游戏结束");
        System.out.println("您的得分：" + b + "分");
        System.out.println("击中次数：" + a);
        System.out.println("总的游玩次数：" + c);
    }
}
