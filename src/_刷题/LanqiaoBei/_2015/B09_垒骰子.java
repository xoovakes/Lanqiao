package _刷题.LanqiaoBei._2015;

import java.util.Scanner;

/**
 * https://www.dotcpp.com/oj/problem2261.html
 * 也是用矩阵来快速幂运算
 */

public class B09_垒骰子 {
	private static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int m = sc.nextInt();
		int[] im = new int[2 * m + 1];
		for (int i = 1; i <= im.length; i++) {
			im[i] = sc.nextInt();
		}
		// 排列组合
		// TODO: 21/03/30 刷题没刷完 
	}
}
