package _刷题.LanqiaoBei._2014;

import java.util.Scanner;

/**
 * A08_兰顿蚂蚁
 * https://www.dotcpp.com/oj/problem1429.html
 * https://www.bilibili.com/video/BV1GE411F7Pj?p=152
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/30 下午 1:04
 */
public class A08_兰顿蚂蚁 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int t = 0; t < n; t++) {
                arr[i][t] = sc.nextInt();
            }
        }
        int x = sc.nextInt();//所处行号
        int y = sc.nextInt();//所处列号
        String s = sc.next();//头的方向、
        int k = sc.nextInt();//步数
        for (int i = 0; i < k; i++) {
            //所处白格
            if (arr[x][y] == 0) {
                arr[x][y] = 1;
                if (s.equals("U")) {
                    s = "L";
                    --y;
                } else if (s.equals("L")) {
                    s = "D";
                    ++x;
                } else if (s.equals("D")) {
                    s = "R";
                    ++y;
                } else if (s.equals("R")) {
                    s = "U";
                    --x;
                }
            } else if (arr[x][y] == 1) {
                arr[x][y] = 0;
                if (s.equals("U")) {
                    s = "R";
                    ++y;
                } else if (s.equals("R")) {
                    s = "D";
                    ++x;
                } else if (s.equals("D")) {
                    s = "L";
                    --y;
                } else if (s.equals("L")) {
                    s = "U";
                    --x;
                }
            }
        }
        System.out.print(x + " " + y);
    }
}
