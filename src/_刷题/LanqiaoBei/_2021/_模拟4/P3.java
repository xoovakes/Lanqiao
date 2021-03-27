package _刷题.LanqiaoBei._2021._模拟4;

public class P3 {
	public static void main(String[] args) {
		int ans = 0;
		// fib
		int a, b, c;
		a = b = 1;
		for (int i = 3; i <= 100; i++) {
			c = a + b;
			a = b;
			b = c;
			if (c % 3 == 0) {
				System.out.println(c + " ");
				ans++;
			}
		}
		System.out.println("res:" + ans);
	}
}
