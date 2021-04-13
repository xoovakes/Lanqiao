package _刷题.LanqiaoBei._2018;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * B02_方格计数
 * 半径为1000的圆，先求1/4圆，勾股定理
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/13 下午 6:09
 */
public class B02_方格计数 {
    private static int ans;

    public static void main(String[] args) {
        ans = 0;
        // 右下角开始找起
        for (int i = 0; i < 1000; i++) {
            for (int j = 999; j >= 0; j--) {
                if (check(i, j)) {
                    ans++;
                }
            }
        }
        System.out.println(ans * 4);
        // 3137548
    }

    // 检查正方形朝外的三个顶点是否在圆内
    private static boolean check(int i, int j) {
        double a = 1000.0;
        if (gou(i + 1, j + 1) > a) return false;
        if (gou(i + 1, j) > a) return false;
        if (gou(i, j + 1) > a) return false;
        return true;
    }

    // 勾股定理
    private static double gou(int i, int j) {
        return sqrt(pow(i, 2) + pow(j, 2));
    }
}
