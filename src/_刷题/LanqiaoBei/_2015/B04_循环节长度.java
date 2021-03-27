package _刷题.LanqiaoBei._2015;

import java.util.Vector;

// 小学除法

public class B04_循环节长度 {
	public static void main(String[] args) {
		System.out.println(f(11, 13));
	}

	private static int f(int n, int m) {
		n = n % m;
		Vector v = new Vector();
		for (;;) {
			v.add(n);
			n *= 10;
			n = n % m;
			if (n == 0)
				return 0;
			if (v.indexOf(n) >= 0)
				return v.size() - v.indexOf(n);
		}
	}
}
