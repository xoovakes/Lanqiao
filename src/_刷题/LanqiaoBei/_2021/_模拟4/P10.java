package _刷题.LanqiaoBei._2021._模拟4;

import java.util.Scanner;

public class P10 {
	private static int ans;
	private static int[] a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		a = new int[n];
		b = new int[m];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
		ans = 0;
		// 公共序列
		f(0, 0, k);
		System.out.println(ans % 1000007);
	}

	// 5 4 2 3 2 7 6 7 2 3 5 7

	private static void f(int pa, int pb, int k) {
		if (k == 0) {
			ans++;
			return;
		}
		for (int i = pb; i < b.length; i++) {
			for (int j = pa; j < a.length; j++) {
				if (a[j] == b[i]) {
					// test
					System.out.println(a[j] + " " + b[i]);
					f(j + 1, i + 1, k - 1);
				}
			}
		}
	}
}
