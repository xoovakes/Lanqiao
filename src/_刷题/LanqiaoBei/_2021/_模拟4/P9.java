package _刷题.LanqiaoBei._2021._模拟4;

import java.util.Scanner;

// 7 1 0 4 8 5 7 6

public class P9 {
	private static int N;
	private static int max, min;

	public static void main(String[] args) {
//		float time_S = System.currentTimeMillis();
//		System.out.println("--- start ---");

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] ans = new int[N - 4];
		int begin = 0, end = 4;
		while (end < N) {
			check(arr, begin, end);
			System.out.println(max + " " + min);
			ans[begin] = max - min;
			begin++;
			end++;
		}

		for (int i = 0; i < ans.length; i++) {
			if (i == ans.length - 1) {
				System.out.print(ans[i]);
				continue;
			}
			System.out.print(ans[i] + " ");
		}

//		System.out.println();
//		time_S = System.currentTimeMillis() - time_S;
//		System.out.println("---" + time_S + "---");
	}

	private static void check(int[] arr, int begin, int end) {
		max = arr[begin];
		min = arr[begin];
		for (int i = begin; i <= end; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
	}
}