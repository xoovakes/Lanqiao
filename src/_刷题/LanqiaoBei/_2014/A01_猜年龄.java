package _刷题.LanqiaoBei._2014;

/**
 * A01_猜年龄
 * 暴力求解
 * 答案：10
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/30 下午 5:42
 */
public class A01_猜年龄 {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (6 * (i + j) == i * j && Math.abs(i - j) <= 8) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}
