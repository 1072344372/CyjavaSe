import java.util.Random;
import java.util.Scanner;

/**
 * @author :�޺�
 * @date : 2023/12/21
 */
public class for12_19 {
    public static void main(String[] args) {
        // ��ȭѭ��
        // method1();
        // ������
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
        String[] arr = new String[]{"ʯͷ", "����", "��"};
        int randomNum, num, result;
        boolean playAgain = true;
        while (playAgain) {
            randomNum = random.nextInt(3) + 1;
            System.out.println("���������֣�1ʯͷ 2���� 3���� 0����");
            num = scanner.nextInt();
            if (num == 0) break;
            else if (num == 1 || num == 2 || num == 3) {
                System.out.println("��������ǣ�" + arr[num - 1] + "    ����������ǣ�" + arr[randomNum - 1]);
                result = (num - randomNum + 3) % 3;
                if (result == 0) {
                    System.out.println("ƽ��");
                } else if (result == 1) {
                    System.out.println("�������");
                } else {
                    System.out.println("��һ�ʤ");
                }
                while (true) {
                    System.out.println("�Ƿ�����һ�֣�������1����������0������");
                    int playChoice = scanner.nextInt();
                    if (playChoice == 0) {
                        playAgain = false;
                        break;
                    } else if (playChoice == 1) {
                        break;
                    } else {
                        System.out.println("��������ȷѡ�1������0������");
                    }
                }
            } else {
                System.out.println("����������������������");
            }

        }
        System.out.println("��Ϸ����");
    }

    private static void method2() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            System.out.println("*********************");
            System.out.println("==��ӭ�����������Ρ�����==");
            System.out.println("*********************");
            System.out.println("��ѡ�����ľ��飺1-���ܻ�  2-ˮ����  3-�����");
            int option = scanner.nextInt();
            int skill;
            boolean flag = true;
            switch (option) {
                case 1:
                    while (flag) {
                        System.out.println("��ѡ����[���ܻ�]��������1-����Ҷ�쵶��  2-���Ͷ��ء�");
                        skill = scanner.nextInt();
                        switch (skill) {
                            case 1:
                                System.out.println("��Ҷ�쵶�������з���ɲ������˺���������95%");
                                System.out.println(isSuccess(95));
                                flag = false;
                                break;
                            case 2:
                                System.out.println("�Ͷ��أ�ʹ�з����Ͷ���������90%");
                                System.out.println(isSuccess(90));
                                flag = false;
                                break;
                            default:
                                System.out.println("���ļ���ѡ������");
                        }
                    }
                    playAgain = false;
                    break;
                case 2:
                    while (flag) {
                        System.out.println("��ѡ����[ˮ����]��1-��ˮ�ݡ�   2-���׿Ƿ�����");
                        skill = scanner.nextInt();
                        switch (skill) {
                            case 1:
                                System.out.println("ˮ�ݣ������з����ˮ�����˺���������80%");
                                System.out.println(isSuccess(80));
                                flag = false;
                                break;
                            case 2:
                                System.out.println("�׿Ƿ������ֵ�һ�ζԷ��Ĺ������ɹ���50%");
                                System.out.println(isSuccess(50));
                                flag = false;
                                break;
                            default:
                                System.out.println("���ļ���ѡ������");
                        }
                    }
                    playAgain = false;
                    break;
                case 3:
                    while (flag) {
                        System.out.println("��ѡ����[�����]��������1-��������桿  2-�����ֱ���;");
                        skill= scanner.nextInt();
                        switch (skill) {
                            case 1:
                                System.out.println("������棺�����з���ɻ������˺������У���30%�������˵з�");
                                System.out.println(isSuccess(100));
                                flag = false;
                                break;
                            case 2:
                                System.out.println("���ֱ��������з���ɻ������˺���������70%����50%�������˵з�");
                                System.out.println(isSuccess(70));
                                flag = false;
                                break;
                            default:
                                System.out.println("���ļ���ѡ������");
                        }
                    }
                    playAgain = false;
                    break;
                default:
                    System.out.println("����ѡ������");
            }
        }
    }

    private static String isSuccess(double num) {
        Random random = new Random();
        int res = random.nextInt(100) + 1;
        String res1 = "���������������" + res;
        String res2 = "";
        if (res > num) {
            res2 = " �ɹ�����";
        } else {
            res2 = " ��δ����";
        }
        return res1 + res2;
    }
}
