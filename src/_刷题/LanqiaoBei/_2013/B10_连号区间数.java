package _刷题.LanqiaoBei._2013;

import java.util.Scanner;

//https://www.dotcpp.com/oj/problem1456.html

public class B10_连号区间数 {
	private static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
//		ComputingTime.beginCompute();
		// 输入完成
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			int max = arr[i];
			int min = arr[i];
			for (int j = i; j <= N; j++) {
				if (i == j) {
					// 一元素区间
//					System.out.println(min + " " + max);
					ans++;
					continue;
				}
				// 是否连号
				max = Math.max(arr[j], max);
				min = Math.min(arr[j], min);
				if (max - min == j - i) {
//					System.out.println(min + " " + max);
					ans++;
				}
			}
		}
		// 结果：
//		ComputingTime.endCompute();
		System.out.println(ans);
	}
}
