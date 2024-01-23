/**
 * @author :ยÞบบ
 * @date : 2023/12/21
 */
public class for_12_21 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "  ");
            }
            System.out.println();
        }
        System.out.println("*********************");
        for (int i = 9; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "  ");
            }
            System.out.println();
        }
        System.out.println("*********************");
        for (int i = 9; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "  ");
            }
            System.out.println();
        }
        System.out.println("*********************");
        for (int i = 9; i >= 1; i--) {
            for (int j = 9; j >= i; j--) {
                    System.out.print(j + "*" + i + "=" + i * j + "  ");
            }
            System.out.println();
        }
        System.out.println("**************************");
        for (double y = 0; y <4; y+=1) {
            for (double x = 0; x <7; x+=1) {
                if (y>=-1*x+3&&y<=3&&y>=x-3){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
