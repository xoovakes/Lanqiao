package _刷题.LanqiaoProblem._2016;

import java.util.Scanner;

/**
 * C语言网 题目 2268: [蓝桥杯][2016年第七届真题]密码脱落 题目描述: X星球的考古学家发现了一批古代留下来的密码。
 * 这些密码是由A、B、C、D 四种植物的种子串成的序列。 仔细分析发现，这些密码串当初应该是前后对称的（也就是我们说的镜像串）。
 * 由于年代久远，其中许多种子脱落了，因而可能会失去镜像的特征。 你的任务是:
 * 给定一个现在看到的密码串，计算一下从当初的状态，它要至少脱落多少个种子，才可能会变成现在的样子 输入输出:
 * 输入一行，表示现在看到的密码串（长度不大于1000） 要求输出一个正整数，表示至少脱落了多少个种子。
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/18 下午 11:09
 */
public class A_密码脱落 {

	private static String A;
	private static String backA;

	public static void main(String[] args) {
		// ABDCDCBABC
		Scanner scanner = new Scanner(System.in);
		A = scanner.nextLine();
		char[] a = A.toCharArray();
		// a.
		Utils.ComputingTime.beginCompute();
		code(a);
		Utils.ComputingTime.endCompute();
		// b.
		Utils.ComputingTime.beginCompute();
		findBydfs();
		Utils.ComputingTime.endCompute();
	}

	private static void findBydfs() {
		backA = "";
		for (int i = A.length() - 1; i >= 0; i--) {
			backA += "" + A.charAt(i);
		}
		int res = A.length() - dfs(A.length() - 1, backA.length() - 1);
		System.out.println(res);
	}

	private static int dfs(int lenA, int lenB) {
		if (lenA == -1 || lenB == -1) {
			return 0;
		}
		if (A.charAt(lenA) == backA.charAt(lenB)) {
			return dfs(lenA - 1, lenB - 1) + 1;
		} else {
			return Math.max(dfs(lenA - 1, lenB), dfs(lenA, lenB - 1));
		}
	}

	private static void code(char[] a) {
		int num = 0;
		int i = 0, j = a.length - 1;
		while (i <= j) {
			int n = 0, m = 0;
			if (a[i] == a[j]) {
				i++;
				j--;
			} else {
				int tj = j;
				while (a[i] != a[tj]) {
					tj--;
					n++;
				}
				int ti = i;
				while (a[j] != a[ti]) {
					ti++;
					m++;
				}
				if (n < m) {
					j -= n;
				} else {
					i += m;
				}
				num += Math.min(n, m);
			}
		}
		System.out.println(num);
	}
}
