package _刷题.Dotcpp;

import java.util.Scanner;

//https://www.dotcpp.com/oj/problem1098.html

public class _1098_陶陶摘苹果 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] apples = new int[10];
		for (int i = 0; i < apples.length; i++) {
			apples[i] = sc.nextInt();
		}
		int high = sc.nextInt() + 30;
		// 快速排序改写
		int p = 0;
		int r = apples.length - 1;
		while (p <= r) {
			if (apples[p] > high) {
				int t = apples[p];
				apples[p] = apples[r];
				apples[r] = t;
				r--;
			} else {
				p++;
			}
		}
		// 结果
		System.out.println(p);
	}
}
