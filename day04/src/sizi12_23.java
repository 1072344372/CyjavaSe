import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author :罗汉
 * @date : 2023/12/25
 */
public class sizi12_23 {
    public static void main(String[] args) {
        //添加元素
        // method1();
        //杨辉三角
        // method2();
        //打地鼠
        method3();
    }

    private static void method3() {
        System.out.println("欢迎开始打地鼠~输入对应的需要进行击打");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int count = 0; // 游戏次数
        int result = 0; // 游戏分数
        int randomNum; // 随机洞穴个数

        int randomNum2; // 随机地鼠位置
        int num;//用户输入
        while (count < 5) {
            randomNum = random.nextInt(8) + 2;
            for (int k = 1; k <= randomNum; k++) System.out.print(k + " ");
            System.out.println();
            randomNum2 = random.nextInt(randomNum) + 1;
            for (int j = 1; j <= randomNum; j++) System.out.print(j == randomNum2 ? "x " : "o ");
            System.out.println("\n------------------------------------------\n请输入对应坐标进行击打 按99重新开始，按88退出游戏");
             num = scanner.nextInt();
            if (num == 88) {
                break;
            } else if (num == 99) {
                result = 0;
                count = 0;
            } else {
                result += num == randomNum2 ? 2 : -1;
                count++;
            }
        }
        System.out.println("游戏结束");
        System.out.println("您的得分：" + result + "分");
    }


    private static void method2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入行号");
        int size = scanner.nextInt();
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            arr[i][0] = 1;
            for (int j = 0; j < size; j++) {
                if (i > 0 && j > 0) {
                    // if (i > 0 ) {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
                if (arr[i][j] != 0) {
                    System.out.print(arr[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    private static void method1() {
        Integer[] arr1 = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        System.out.println("当前数组：\n" + Arrays.toString(arr1));

        System.out.println("在末尾添加100后");
        Integer[] arr = (Integer[]) arrAdd(arr1, -1, 100);
        System.out.println(Arrays.toString(arr));

        System.out.println("在第2位添加10后");
        Integer[] arr2 = (Integer[]) arrAdd(arr1, 2, 10);
        System.out.println(Arrays.toString(arr2));
        System.out.println("--------------------------------------------------------");
        String[] strArr = {"张三", "李四", "王二", "麻子"};
        System.out.println("当前数组：\n" + Arrays.toString(strArr));

        System.out.println("在末尾添加罗汉后");
        String[] strArr2 = (String[]) arrAdd(strArr, -1, "罗汉");
        System.out.println(Arrays.toString(strArr2));

        System.out.println("在第1位添加牛魔王后");
        String[] strArr3 = (String[]) arrAdd(strArr, 1, "牛魔王");
        System.out.println(Arrays.toString(strArr3));
    }

    /**
     * 添加
     */
    private static Object[] arrAdd(Object[] arr, int index, Object obj) {
        if (index == -1) index = arr.length;// 表示末尾添加
        if (index >= 0 && index <= arr.length) {
            if (arr instanceof Integer[] && obj instanceof Integer) {// 表示要添加的和原来数组都是Int类型
                // System.out.println("arr是int类型的数组");
                Object[] res = add(arr, index, obj);
                return (Integer[]) res;
            } else if (arr instanceof String[] && obj instanceof String) {// 表示要添加的和原来数组都是String类型
                // System.out.println("arr是String类型的数组");
                Object[] res = add(arr, index, obj);
                return (String[]) res;
            } else {
                System.out.println("要添加的元素类型与数组中元素类型不匹配");
            }
        } else {
            System.out.println("索引超出范围");
        }
        return null;
    }

    /**
     * 数组的真正添加方法
     * 已经确保了arr和要添加的obj是同一个类型
     *
     * @param arr   需要添加的数组
     * @param index 要添加的位置
     * @param obj   要添加的数组
     */
    private static Object[] add(Object[] arr, int index, Object obj) {
        int size = arr.length;
        // arr = grow(arr, Math.max(10, arr.length + 1));// 扩容
        arr = grow(arr, arr.length + 1);// 扩容
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = obj;
        return arr;
    }

    /**
     * 数组扩容
     *
     * @param minCapacity 最小容量
     * @param arr         需要扩容的数组
     */
    private static Object[] grow(Object[] arr, int minCapacity) {
        int oldCapacity = arr.length;
        // int newCapacity = oldCapacity + (oldCapacity >> 1);// 1.5倍
        int newCapacity = oldCapacity + 1;// +1
        if (newCapacity - minCapacity <= 0)
            newCapacity = minCapacity;
        return Arrays.copyOf(arr, newCapacity);
    }
}
