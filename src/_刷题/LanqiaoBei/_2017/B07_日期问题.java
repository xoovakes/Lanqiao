package _刷题.LanqiaoBei._2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * B07_日期问题
 * https://www.bilibili.com/video/BV1GE411F7Pj?p=486
 * https://blog.csdn.net/sunnnnh/article/details/109382773
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/07 下午 1:29
 */
public class B07_日期问题 {
    static TreeSet<Integer> set = new TreeSet<Integer>();
    static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        // 输入日期
        Scanner sc = new Scanner(System.in);
        String[] date = sc.next().split("/");
        // 三种情况处理
        f(date[0], date[1], date[2]);
        f(date[2], date[0], date[1]);
        f(date[2], date[1], date[0]);
        // 输出日期
        list.addAll(set);
        for (Integer integer : list) {
            String ans = "" + integer;
            System.out.println(ans.substring(0, 4) + "-" + ans.substring(4, 6) + "-" + ans.substring(6));
        }
    }

    private static void f(String y, String m, String d) {
        int yy = Integer.parseInt(y);
        int mm = Integer.parseInt(m);
        int dd = Integer.parseInt(d);
        // 年
        if (yy >= 60)
            yy += 1900;
        else
            yy += 2000;
        // 月
        if (isR(yy) && mm == 2 && dd > 0 && dd < 29) {
            set.add(Integer.parseInt("" + yy + m + d));
        }
        if (!isR(yy) && mm == 2 && dd > 0 && dd < 28) {
            set.add(Integer.parseInt("" + yy + m + d));
        }
        // 日
        if ((mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) && dd > 0 && dd <= 31) {
            set.add(Integer.parseInt("" + yy + m + d));
        }
        if ((mm == 4 || mm == 6 || mm == 9 || mm == 11) && dd > 0 && dd <= 30) {
            set.add(Integer.parseInt("" + yy + m + d));
        }
    }

    private static boolean isR(int y) {
        return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
    }
}
