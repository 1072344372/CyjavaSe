import java.util.Random;
import java.util.Scanner;

public class HomeWork12_14 {
    public static void main(String[] args) {
        // method1();
        // method2();
        // method3();
        // method4();
        // method5();
        method6();
    }

    /**
     * 假设你想开发一个玩彩票的游戏，程序随机地产生一个两位数的彩票，提示用户输入一个两位数，然后按照下面的规则判定用户是否中奖。
     * 1)如果用户输入的数匹配彩票的实际顺序，奖金10000美元。
     * 2)如果用户输入的所有数字匹配彩票的所有数字，但顺序不一致，奖金3000美元。
     * 3)如果用户输入的一个数字仅满足顺序情况下匹配彩票的一个数字，奖金1000美元。
     * 4)如果用户输入的一个数字仅满足非顺序情况下匹配彩票的一个数字，奖金500美元。
     * 5)如果用户输入的数字没有匹配任何一个数字，则彩票作废。
     */
    private static void method6() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNum = random.nextInt(90) + 10;
        System.out.println("请输入一个两位数");
        int userNum = scanner.nextInt();
        // 彩票的个位、十位
        int randomNum1 = randomNum % 10;
        int randomNum2 = randomNum / 10;
        // 用户的个位、十位
        int userNum1 = userNum % 10;
        int userNum2 = userNum / 10;
        int res = -1;
        int money = 0;

        if (userNum < 10 || userNum >= 100) {
            System.out.println("您输入的有误！请输入一个10~99的两位数~");
        } else {
            if (randomNum == userNum) {

                res = 1;
                money = 10000;
            } else if ((randomNum1 == userNum2 && randomNum2 == userNum1)) {
                res = 2;
                money = 3000;
            } else if ((randomNum1 == userNum1 || randomNum1 == userNum2) && (randomNum2 == userNum1 || randomNum2 == userNum2)) {
                res = 3;
                money = 1000;
            } else if ((randomNum1 == userNum2) || (randomNum2 == userNum1)) {
                res = 4;
                money = 500;
            }

            if (res > 0) {
                System.out.println("您中奖了，您输入的是" + userNum + "   中奖号码为：" + randomNum + "  中了" + res + "等奖，奖金" + money + "美元");
            } else {
                System.out.println("您没有中奖，您输入的是" + userNum + "   中奖号码为：" + randomNum);
            }
        }
    }

    /**
     * 狗的前两年每一年相当于人类的10.5岁，
     * 之后每增加一年就增加四岁。那么5岁的狗
     * 相当于人类多少年龄呢？
     * 如果用户输入负数，请显示一个提示信息
     */
    private static void method5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入狗的年龄");
        double dogAge = scanner.nextDouble();
        double age = 0;
        if (dogAge < 0) {
            System.out.println("您输入的狗的年龄有误,不能为负数");
        } else {
            if (dogAge <= 2) {
                age = dogAge * 10.5;
            } else {
                age = (dogAge - 2) * 4 + 21;
            }
            System.out.println("当前狗的年龄:" + dogAge + " 相当于人的年龄：" + age);
        }

    }

    private static void method4() {
        System.out.println("请输入一个整数");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int oldNum = num;
        int sum = 0;

        while (num > 0) {
            int ge = num % 10;
            sum += Math.pow(ge, 3);
            num = num / 10;
        }
        if (sum == oldNum) {
            System.out.println(oldNum + " 是水仙花数");
        } else {
            System.out.println(oldNum + " 不是水仙花数");
        }
    }

    /**
     * 求1~100之间的偶数据和，并把求和结果在控制台输出
     */
    private static void method3() {
        int sum = 0;
        for (int i = 0; i < 100; i += 2) {
            sum += i;
        }
        System.out.println("1~100之间的偶数和为：" + sum);
    }

    /**
     * 求1~100之间的数据和
     */
    private static void method2() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        System.out.println("1~100总和为：" + sum);
    }

    private static void method1() {
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }

    }

}
