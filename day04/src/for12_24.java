import java.util.Random;
import java.util.Scanner;

/**
 * @author :�޺�
 * @date : 2023/12/21
 */
public class for12_24 {
    public static void main(String[] args) {

        // method1();
        // ����һ�������ж�������ǲ�������
        // method2();
        // method3();
        // method4();
        method5();
    }

    /**
     ���ӳ�������
     ���ӵ�һ��ժ�����ɸ����ӣ���������һ�룬����񫣬�ֶ����һ��
     �ڶ��������ֽ�ʣ�µ����ӳԵ�һ�룬�ֶ����һ����
     �Ժ�ÿ�����϶�����ǰһ��ʣ�µ�һ����һ����
     ����10���������ٳ�ʱ����ֻʣ��һ�������ˡ�
     ���һ�칲ժ�˶���
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
        System.out.println("������һ����");
        int num = scanner.nextInt();
        for (int i = num; i > 0; i--) {
            System.out.print(i + " ");
        }
    }

    private static void method2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������һ����");
        int num = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= num/2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
        System.out.println(sum == num?"������":"��������");
    }

    private static void method1() {
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

    /**
     * һ���ڴ��з���12����
     * ��֪����3���Ǻ�ģ�3���ǰ׵ģ�6���Ǻڵģ�
     * �ִ�����ȡ8�����ʹ��ж����ֿ��ܵ���ɫ���䣿
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
