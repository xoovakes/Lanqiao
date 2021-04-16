package _刷题.LanqiaoBei._2019;

/**
 * C_数列求值
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/16 下午 8:22
 */
public class C_数列求值 {
    public static void main(String[] args) {
        int a0 = 7;
        int a = 20190324;

        for (int i = 1; i <= a0; i++) {
            System.out.println(f_fiba(i));
        }//t
        System.out.println(f_fiba(a));
    }

    private static int f_fiba(int a) {
        int[] fiba = {1, 1, 1};
        for (int i = 4; i <= a; i++) {
            fiba[i % 3] = (fiba[0] + fiba[1] + fiba[2])%10000;
        }
        return fiba[a % 3];
    }
}
