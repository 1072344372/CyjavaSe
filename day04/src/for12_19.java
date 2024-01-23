import java.util.Random;
import java.util.Scanner;

/**
 * @author :罗汉
 * @date : 2023/12/21
 */
public class for12_19 {
    public static void main(String[] args) {
        // 猜拳循环
        // method1();
        // 宝可梦
        method2();
        // method3();
        // method4();
        // method5();
    }

    private static void method4() {
        for (double y = 0; y < 7; y += 1) {
            for (double x = 0; x < 7; x += 1) {
                if (y == -1 * x + 3 || y == 3 || y == x - 3) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                if (y > 3 && x == 2) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    private static void method3() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("0");
            }
            System.out.println();
        }
        System.out.println("**********************************");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                if (i % 2 == 0) {
                    System.out.print("z");
                } else {
                    System.out.print("o");
                }

            }
            System.out.println();
        }
        System.out.println("**************************************");
        for (double y = 0; y < 4; y += 1) {
            for (double x = 0; x < 10; x += 1) {
                if (y >= -1 * x + 3 && y <= 3 && y >= x - 3) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");

    }

    private static void method1() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] arr = new String[]{"石头", "剪刀", "布"};
        int randomNum, num, result;
        boolean playAgain = true;
        while (playAgain) {
            randomNum = random.nextInt(3) + 1;
            System.out.println("请输入数字（1石头 2剪刀 3布） 0结束");
            num = scanner.nextInt();
            if (num == 0) break;
            else if (num == 1 || num == 2 || num == 3) {
                System.out.println("您输入的是：" + arr[num - 1] + "    电脑输入的是：" + arr[randomNum - 1]);
                result = (num - randomNum + 3) % 3;
                if (result == 0) {
                    System.out.println("平局");
                } else if (result == 1) {
                    System.out.println("玩家输了");
                } else {
                    System.out.println("玩家获胜");
                }
                while (true) {
                    System.out.println("是否再来一局？（输入1继续，输入0结束）");
                    int playChoice = scanner.nextInt();
                    if (playChoice == 0) {
                        playAgain = false;
                        break;
                    } else if (playChoice == 1) {
                        break;
                    } else {
                        System.out.println("请输入正确选项（1继续，0结束）");
                    }
                }
            } else {
                System.out.println("您的输入有误，请重新输入");
            }

        }
        System.out.println("游戏结束");
    }

    private static void method2() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            System.out.println("*********************");
            System.out.println("==欢迎来到【宝可梦】世界==");
            System.out.println("*********************");
            System.out.println("请选择您的精灵：1-妙蛙花  2-水箭龟  3-喷火龙");
            int option = scanner.nextInt();
            int skill;
            boolean flag = true;
            switch (option) {
                case 1:
                    while (flag) {
                        System.out.println("您选择了[妙蛙花]，技能有1-【飞叶快刀】  2-【猛毒素】");
                        skill = scanner.nextInt();
                        switch (skill) {
                            case 1:
                                System.out.println("飞叶快刀：攻击敌方造成草属性伤害，命中率95%");
                                System.out.println(isSuccess(95));
                                flag = false;
                                break;
                            case 2:
                                System.out.println("猛毒素：使敌方中猛毒，命中率90%");
                                System.out.println(isSuccess(90));
                                flag = false;
                                break;
                            default:
                                System.out.println("您的技能选择有误！");
                        }
                    }
                    playAgain = false;
                    break;
                case 2:
                    while (flag) {
                        System.out.println("您选择了[水箭龟]，1-【水泡】   2-【甲壳防御】");
                        skill = scanner.nextInt();
                        switch (skill) {
                            case 1:
                                System.out.println("水泡：攻击敌方造成水属性伤害，命中率80%");
                                System.out.println(isSuccess(80));
                                flag = false;
                                break;
                            case 2:
                                System.out.println("甲壳防御：抵挡一次对方的攻击，成功率50%");
                                System.out.println(isSuccess(50));
                                flag = false;
                                break;
                            default:
                                System.out.println("您的技能选择有误！");
                        }
                    }
                    playAgain = false;
                    break;
                case 3:
                    while (flag) {
                        System.out.println("您选择了[喷火龙]，技能有1-【喷射火焰】  2-【大字爆】;");
                        skill= scanner.nextInt();
                        switch (skill) {
                            case 1:
                                System.out.println("喷射火焰：攻击敌方造成火属性伤害，必中，有30%概率烧伤敌方");
                                System.out.println(isSuccess(100));
                                flag = false;
                                break;
                            case 2:
                                System.out.println("大字爆：攻击敌方造成火属性伤害，命中率70%，有50%概率烧伤敌方");
                                System.out.println(isSuccess(70));
                                flag = false;
                                break;
                            default:
                                System.out.println("您的技能选择有误！");
                        }
                    }
                    playAgain = false;
                    break;
                default:
                    System.out.println("您的选择有误！");
            }
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
}
