/**
 * @author :ยÞบบ
 * @date : 2023/12/26
 */
public class Test12_26 {
    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        int[] arr = {12, 34, 34, 12, 45, 36, 23, 45};
        int num=arr[0];
        for (int i = 0; i < arr.length; i++) {
            num=num^arr[i];
            System.out.println(num);
        }
        System.out.println(num);
    }
}
