package _刷题.LanqiaoBei._2019;

import java.util.Scanner;

public class F_特别数的和 {

	// 40 574
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long ans = 0;
		for (int i = 1; i <= n; i++) {
			if (check(i)) {
				ans += i;
			}
		}
		System.out.println(ans);
	}

	private static boolean check(int i) {
		int[] arr0 = { 2, 0, 1, 9 };
		while (i != 0) {
			for (int j = 0; j < arr0.length; j++) {
				if (i % 10 == arr0[j]) {
					return true;
				}
			}
			i /= 10;
		}
		return false;
	}

}
