import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. 判断153、471、499 这三个数字是否是水仙花数，所谓水仙花数是指一个三位数，其各位数字⽴方和等于该数本身。例如:
        // 153 是⼀个⽔仙花数, 因为 1³+5³+3³等于 153
        // method1();
        // 2. 定义两个变量保存⼀个⼈的身高和体重，编程实现判断这个⼈的身材是否正常 !公式：体重(kg) / (身⾼(m) 的平⽅)在18 .5 ~24.9 之间属于正常。输出格式：是否正常
        // method2();
        // 3. 从键盘输入一个数字，写出判断其否能同时被2和5整除的条件语句, 并且打印对应的结果
        // method3();
        // 4. #玩家出拳 判断出拳文字 （判断玩家输入有误情况, 直接结束）
        //    #电脑出拳 判断出拳的文字
        //    #判断胜负以及平局
        method4();
        // 5.宝可梦系统
        // method5();
    }

    private static void method5() {
        System.out.println("*********************");
        System.out.println("==欢迎来到【宝可梦】世界==");
        System.out.println("*********************");
        System.out.println("请选择您的精灵：1-妙蛙花  2-水箭龟  3-喷火龙");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("您选择了[妙蛙花]，技能有1-【飞叶快刀】  2-【猛毒素】");
                int skill1 = scanner.nextInt();
                switch (skill1) {
                    case 1:
                        System.out.println("飞叶快刀：攻击敌方造成草属性伤害，命中率95%");
                        System.out.println(isSuccess(95));
                        break;
                    case 2:
                        System.out.println("猛毒素：使敌方中猛毒，命中率90%");
                        System.out.println(isSuccess(90));
                        break;
                    default:
                        System.out.println("您的技能选择有误！");
                }
                break;
            case 2:
                System.out.println("您选择了[水箭龟]，1-【水泡】   2-【甲壳防御】");
                int skill2 = scanner.nextInt();
                switch (skill2) {
                    case 1:
                        System.out.println("水泡：攻击敌方造成水属性伤害，命中率80%");
                        System.out.println(isSuccess(80));
                        break;
                    case 2:
                        System.out.println("甲壳防御：抵挡一次对方的攻击，成功率50%");
                        System.out.println(isSuccess(50));
                        break;
                    default:
                        System.out.println("您的技能选择有误！");
                }
                break;
            case 3:
                System.out.println("您选择了[喷火龙]，技能有1-【喷射火焰】  2-【大字爆】;");
                int skill3 = scanner.nextInt();
                switch (skill3) {
                    case 1:
                        System.out.println("喷射火焰：攻击敌方造成火属性伤害，必中，有30%概率烧伤敌方");
                        System.out.println(isSuccess(100));
                        break;
                    case 2:
                        System.out.println("大字爆：攻击敌方造成火属性伤害，命中率70%，有50%概率烧伤敌方");
                        System.out.println(isSuccess(70));
                        break;
                    default:
                        System.out.println("您的技能选择有误！");
                }
                break;
            default:
                System.out.println("您的选择有误！");
        }
    }

    private static String isSuccess(double num) {
        Random random = new Random();
          int res = random.nextInt(100) + 1;
            String res1 = "本次命中随机数：" + res;
            String res2 = "";
            if (res > num) {
                res2 = " 成功命中";
            } else {
                res2 = " 并未命中";
            }
            return res1 + res2;
    }

    private static void method4() {
        Random random = new Random();
        int randomNum = random.nextInt(3) + 1;// 先闭后开0-2  +1
        String [] arr= new String[]{"石头", "剪刀", "布"};
        System.out.println("请输入数字（1石头 2剪刀 3布）");
        int num = scanner.nextInt();
        System.out.println("您输入的是："+arr[num-1]+"    电脑输入的是："+arr[randomNum-1]);
        int result = (num - randomNum + 3) % 3;
        if (result == 0) {
            System.out.println("平局");
        } else if (result == 1) {
            System.out.println("玩家输了");
        } else {
            System.out.println("玩家获胜");
        }
    }

    private static void method3() {
        System.out.println("请输入一个整数");
        int num = scanner.nextInt();
        if (num % 2 == 0 && num % 5 == 0) {
            System.out.println(num + "能被2和5整除");
        } else {
            System.out.println(num + "不能被2和5整除");
        }
    }

    private static void method2() {
        System.out.println("请输入身高(m)");
        double height = scanner.nextDouble();
        System.out.println("请输入体重(kg)");
        double weight = scanner.nextDouble();
        double res = Math.pow(weight / height, 2);
        System.out.println("是否正常：" + (res >= 18.4 && res <= 24.9));

    }

    private static void method1() {
        System.out.println("请输入一个整数");
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
}
