package _刷题.LanqiaoBei._2015;

import java.util.Scanner;

// https://www.dotcpp.com/oj/problem2263.html

public class B08_饮料换购 {
	private static int N;
	private static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = N;
		f(N);
		System.out.println(ans);
	}

	private static void f(int n) {
		int i = 0;
		for (i = 0; i < n; i += 3) {
			ans++;
			n++;
		}
		ans--;
	}
}
