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
     * �������뿪��һ�����Ʊ����Ϸ����������ز���һ����λ���Ĳ�Ʊ����ʾ�û�����һ����λ����Ȼ��������Ĺ����ж��û��Ƿ��н���
     * 1)����û��������ƥ���Ʊ��ʵ��˳�򣬽���10000��Ԫ��
     * 2)����û��������������ƥ���Ʊ���������֣���˳��һ�£�����3000��Ԫ��
     * 3)����û������һ�����ֽ�����˳�������ƥ���Ʊ��һ�����֣�����1000��Ԫ��
     * 4)����û������һ�����ֽ������˳�������ƥ���Ʊ��һ�����֣�����500��Ԫ��
     * 5)����û����������û��ƥ���κ�һ�����֣����Ʊ���ϡ�
     */
    private static void method6() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNum = random.nextInt(90) + 10;
        System.out.println("������һ����λ��");
        int userNum = scanner.nextInt();
        // ��Ʊ�ĸ�λ��ʮλ
        int randomNum1 = randomNum % 10;
        int randomNum2 = randomNum / 10;
        // �û��ĸ�λ��ʮλ
        int userNum1 = userNum % 10;
        int userNum2 = userNum / 10;
        int res = -1;
        int money = 0;

        if (userNum < 10 || userNum >= 100) {
            System.out.println("�����������������һ��10~99����λ��~");
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
                System.out.println("���н��ˣ����������" + userNum + "   �н�����Ϊ��" + randomNum + "  ����" + res + "�Ƚ�������" + money + "��Ԫ");
            } else {
                System.out.println("��û���н������������" + userNum + "   �н�����Ϊ��" + randomNum);
            }
        }
    }

    /**
     * ����ǰ����ÿһ���൱�������10.5�꣬
     * ֮��ÿ����һ����������ꡣ��ô5��Ĺ�
     * �൱��������������أ�
     * ����û����븺��������ʾһ����ʾ��Ϣ
     */
    private static void method5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("�����빷������");
        double dogAge = scanner.nextDouble();
        double age = 0;
        if (dogAge < 0) {
            System.out.println("������Ĺ�����������,����Ϊ����");
        } else {
            if (dogAge <= 2) {
                age = dogAge * 10.5;
            } else {
                age = (dogAge - 2) * 4 + 21;
            }
            System.out.println("��ǰ��������:" + dogAge + " �൱���˵����䣺" + age);
        }

    }

    private static void method4() {
        System.out.println("������һ������");
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
            System.out.println(oldNum + " ��ˮ�ɻ���");
        } else {
            System.out.println(oldNum + " ����ˮ�ɻ���");
        }
    }

    /**
     * ��1~100֮���ż���ݺͣ�������ͽ���ڿ���̨���
     */
    private static void method3() {
        int sum = 0;
        for (int i = 0; i < 100; i += 2) {
            sum += i;
        }
        System.out.println("1~100֮���ż����Ϊ��" + sum);
    }

    /**
     * ��1~100֮������ݺ�
     */
    private static void method2() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        System.out.println("1~100�ܺ�Ϊ��" + sum);
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
