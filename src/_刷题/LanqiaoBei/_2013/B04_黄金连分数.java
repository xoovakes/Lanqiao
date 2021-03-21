package _刷题.LanqiaoBei._2013;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * B04_黄金连分数
 * 
 * @author zixi
 *
 */
public class B04_黄金连分数 {
	// 1. 化为求斐波那契相邻两项的比值，到多少项？
	// 越多越精确，n/n+1项，n再往上增加，这个比值的小数点后101位是稳定的，也就是不变的。
	// 2.double无法表示100位小数，要用到BigInteger和BigDecimal。
	public static void main(String[] args) {
		f(100);
		f(200);
		f(300);
		f(400);
	}

	private static void f(int num) {
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		for (int i = 3; i < num; i++) {
			BigInteger t = b;
			b = a.add(b);
			a = t;
		}
		BigDecimal divide = new BigDecimal(a, 110).divide(new BigDecimal(b, 110), BigDecimal.ROUND_HALF_DOWN);
		System.out.println(divide.toPlainString().substring(0, 103));
	}
}
