import java.util.Random;

public class text1 {
    public static void main(String[] args) {
        // 方法基础练习：
        // 1.写一个方法showNineTable可以展示九九乘法表
        showNineTable();
        System.out.println("------------------------------------------------");
        // 2.写一个方法printRect用于打印指定行数和指定列数的矩形
        printRect(1, 2);
        System.out.println("------------------------------------------------");
        // 3.写一个方法ranNum用于获取指定范围的随机正整数(例如随机43-68之间的整数)
        int res = ranNum(43, 68);
        System.out.println("返回的随机数："+res);
        System.out.println("------------------------------------------------");
        // 4.写一个方法checkRunYear用于判断一个大于0的年份是闰年还是平年
        int year=2024;
        boolean b = checkRunYear(year);
        System.out.println(year+"年是否是闰年?"+b);
        System.out.println("------------------------------------------------");
        // 5.写一个方法checkPrime用于判断一个正整数是否为质数
        checkPrime(15);
    }

    private static boolean checkPrime(int num) {
        for (int i = 2; i < num/2; i++) {
            if (num%i==0) return false;
        }
        return true;
    }

    private static boolean checkRunYear(int year) {
        return (year % 400 == 0) && (year % 100 != 0 || year % 4 == 0);
    }

    private static int ranNum(int beginNum, int endNum) {// 两个边界都包括
        endNum = endNum + 1;
        return new Random().nextInt(endNum - beginNum) + beginNum;
    }

    private static void printRect(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void showNineTable() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "  ");
            }
            System.out.println();
        }
    }
}
