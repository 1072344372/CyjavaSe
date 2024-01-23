import java.util.Random;
import java.util.Scanner;

/**
 * @author :罗汉
 * @date : 2023/12/21
 */
public class for12_24 {
    public static void main(String[] args) {

        // method1();
        // 输入一个数，判断这个数是不是完数
        // method2();
        // method3();
        // method4();
        method5();
    }

    /**
     猴子吃桃问题
     猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个
     第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
     以后每天早上都吃了前一天剩下的一半零一个。
     到第10天早上想再吃时，见只剩下一个桃子了。
     求第一天共摘了多少
     */
    private static void method4() {
        int count=1;
        for (int i = 0; i < 9; i++) {
            count=(count+1)*2;
        }
        System.out.println(count);
    }
    private static void method3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数");
        int num = scanner.nextInt();
        for (int i = num; i > 0; i--) {
            System.out.print(i + " ");
        }
    }

    private static void method2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数");
        int num = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= num/2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
        System.out.println(sum == num?"是完数":"不是完数");
    }

    private static void method1() {
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

    /**
     * 一个口袋中放有12个球，
     * 已知其中3个是红的，3个是白的，6个是黑的，
     * 现从中任取8个，问共有多少种可能的颜色搭配？
     */
    private static void method5() {
        int count = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                for (int k = 2; k <= 6; k++) {
                    if (i + k + j == 8) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

}
