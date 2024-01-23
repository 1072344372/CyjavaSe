import java.util.Random;
import java.util.Scanner;

public class Test {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // method1();
        method2();
    }

    private static void method1() {
        Random random = new Random();
        int randomNum = random.nextInt(3) + 1;// 先闭后开0-2  +1
        String[] arr = new String[]{"石头", "剪刀", "布"};
        System.out.println("请输入数字（1石头 2剪刀 3布）");
        int num = scanner.nextInt();
        System.out.println("您输入的是：" + arr[num - 1] + "    电脑输入的是：" + arr[randomNum - 1]);
        int result = (num - randomNum + 3) % 3;
        if (result == 0) {
            System.out.println("平局");
        } else if (result == 1) {
            System.out.println("玩家输了");
        } else {
            System.out.println("玩家获胜");
        }
    }
    private static void method2() {
        System.out.print("请输入本次消费的金额：");
        int amount = scanner.nextInt();
        if (amount >= 100) {
            System.out.println("满100元可参与换购");
            System.out.println("选项一： +1元换购鼠标");
            System.out.println("选项二： +5元换购键盘");
            System.out.println("选项三： +10元换购充电宝");
            System.out.println("选项四： +20元换购移动硬盘");
            System.out.print("请输入选项（1-4）：");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    amount += 1;
                    System.out.println("您选择了换购鼠标，最终消费为：" + amount + "元");
                    break;
                case 2:
                    amount += 5;
                    System.out.println("您选择了换购键盘，最终消费为：" + amount + "元");
                    break;
                case 3:
                    amount += 10;
                    System.out.println("您选择了换购充电宝，最终消费为：" + amount + "元");
                    break;
                case 4:
                    amount += 20;
                    System.out.println("您选择了换购移动硬盘，最终消费为：" + amount + "元");
                    break;
                default:
                    System.out.println("无效选项，最终消费为：" + amount + "元");
            }
        } else {
            System.out.println("不满100元，直接结算，消费金额为：" + amount + "元");
        }
    }

    private static void method3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入三个数，用空格分隔：");

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int max = Math.max(a, Math.max(b, c));
        System.out.println("最大值为：" + max);
    }
}
