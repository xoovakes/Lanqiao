package _刷题.LanqiaoBei._2013;

import java.util.Calendar;

/**
 * B_01_世纪末的星期
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/20 下午 1:42
 */

public class B01_世纪末的星期 {
	// 题目：
	// 曾有邪教称1999年12月31日是世界末日。当然该谣言已经不攻自破。
	// 还有人称今后的某个世纪末的12月31日，如果是星期一则会....
	// 有趣的是，任何一个世纪末的年份的12月31日都不可能是星期一!!
	// 于是，“谣言制造商”又修改为星期日......
	// 1999年的12月31日是星期五，
	// 请问：未来哪一个离我们最近的一个世纪末年（即xx99年）的12月31日正好是星期天（即星期日）？
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		for (int year = 1999; year < 10000; year += 100) {
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, 11);// 是12月
			calendar.set(Calendar.DAY_OF_MONTH, 31);
			System.out.println("Error: " + year + " " + calendar.get(Calendar.DAY_OF_WEEK));
			if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
				System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
				break;
			}
		}
	}
}
