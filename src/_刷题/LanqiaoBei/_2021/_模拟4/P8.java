package _刷题.LanqiaoBei._2021._模拟4;

// 答案ans用long类型

import java.util.Scanner;

public class P8 {
	private static int N;
	private static long ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 6 1 1 4 3 2 4
		N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		// 贪心
		ans = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				if (arr[j] > arr[i])
					for (int k = j + 1; k < arr.length; k++) {
						if (arr[k] > arr[j]) {
							ans++;
						}
					}
			}
		}
		System.out.println(ans);
	}
}
