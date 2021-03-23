package _刷题.LanqiaoBei._2013;

import java.util.Scanner;

//https://www.dotcpp.com/oj/problem1440.html

public class A08_带分数 {
	private static int N, ans;// N< 1000*1000

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// 递归-全排列
		ans = 0;
		pai(arr, 0);
		System.out.println(ans);
	}

	private static void pai(int[] arr, int k) {
		if (k == 9) {
			check(arr);
			return;
		}
		for (int i = k; i < arr.length; i++) {
			swap(arr, k, i);
			pai(arr, k + 1);
			swap(arr, k, i);
		}
	}

	// 检查这些排列是否符合条件
	private static void check(int[] arr) {
		// 加号前的字符最多是 7 个
		for (int i = 1; i <= 7; i++) {
			int num1 = toInt(arr, 0, i);
			if (num1 >= N)
				continue;
			// 除号前的字符最多是 9-i-1 个
			for (int j = 1; j <= 8 - i; j++) {
				int num2 = toInt(arr, i, j);
				int num3 = toInt(arr, i + j, 9 - i - j);
				if (num2 % num3 == 0 && num1 + num2 / num3 == N) {
					ans++;
				}
			}
		}
	}

	private static int toInt(int[] arr, int pos, int len) {
		int sum = 0;
		int t = 1;
		for (int i = pos + len - 1; i >= pos; i--) {
			sum += arr[i] * t;
			t *= 10;
		}
		return sum;
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
