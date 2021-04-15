package _刷题.LanqiaoBei._2018;

import java.util.Scanner;

/**
 * B07_螺旋折线
 * 搞个简单的思路，用四个象限来看,不行，还是要四边
 * 没写完，思路差不多，这数学题吐了。
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/14 上午 12:53
 */
public class B07_螺旋折线 {
    private static int X, Y, ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        Y = sc.nextInt();

        ans = 0;
        dis();
        System.out.println(ans);
    }

    private static void dis() {
        int x1 = 0, y1 = 0;
        int more = 0;
        if (X >= Y) { //右,下
            if (X >= -Y) {
                x1 = X;
                y1 = -X;
                more = X + Y;
            } else {
                x1 = Y - 1;
                y1 = Y;
                more = -Y + X + 1;
            }
        } else { //左,上
            if (X <= -Y) {
                x1 = X;
                y1 = -X;
                more = -X - Y;
            } else {
                x1 = Y;
                y1 = Y;
                more = Y - X;
            }
        }

        // n * (a1 + an) / 2
        if (x1 > 0 && y1 > 0) {
            //1
        } else if (x1 < 0 && y1 > 0) {
            //2
        } else if (x1 < 0 && y1 < 0) {
            //3
        } else if (x1 > 0 && y1 < 0) {
            //4
        }
        ans = (ans >> 1) - more;
    }
}
