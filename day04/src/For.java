/**
 * @author :罗汉
 * @date : 2023/12/14
 */
public class For {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // if (i==3){
                //     System.out.print("*");
                // }
                // if (i==j-3){
                //     System.out.print("*");
                // }
                // if (i==-j+3){
                //     System.out.print("*");
                // }
                if (i==-j+3||i==j-3||i==3){
                    System.out.print("*");
                }else {
                    System.out.println(" ");
                }
            }
            System.out.println();
        }

    }
}
