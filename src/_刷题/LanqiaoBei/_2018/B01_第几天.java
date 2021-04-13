package _刷题.LanqiaoBei._2018;

import java.util.Calendar;

/**
 * B01_第几天
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/13 下午 5:46
 */
public class B01_第几天 {
    public static void main(String[] args) {
        Calendar day1 = Calendar.getInstance();
        day1.set(2000, Calendar.JANUARY, 1);
        Calendar day2 = Calendar.getInstance();
        day2.set(2000, Calendar.MAY, 4);

        System.out.println(day1.get(Calendar.DATE));
        System.out.println(day2.get(Calendar.DATE));

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            day1.add(Calendar.DATE, i);
            if (day1.get(Calendar.MONTH) == day2.get(Calendar.MONTH)) {
                if (day1.get(Calendar.DATE) == day2.get(Calendar.DATE)) {
                    System.out.println(i+1);
                    break;
                }
            }
            day1.add(Calendar.DATE, -i);
        }
    }
}
