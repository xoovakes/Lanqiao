package _刷题.Dotcpp;

import java.util.Scanner;

//https://www.dotcpp.com/oj/problem1432.html
//代码有错，逻辑没问题

public class _1432_剪格子 {
	private static int M, N;
	private static int ans;
	private static int[][] arr;
	private static int[][] vis;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[M][N];
		vis = new int[M][N];
		int sum = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				sum += arr[i][j];
			}
		// dfs
		ans = M * N;
		sum = sum >> 1;
		dfs(0, 0, sum, 0);
		// 结果
		System.out.println(ans);
	}

	private static void dfs(int i, int j, int sum, int cnt) {
		if (i < 0 || i == N || j < 0 || j == M || sum < 0 || vis[i][j] == 1)
			return;
		if (sum == 0) {
			ans = Math.min(ans, cnt - 1);
			return;
		}
		vis[i][j] = 1;
		dfs(i, j - 1, sum - arr[i][j], cnt + 1);
		dfs(i, j + 1, sum - arr[i][j], cnt + 1);// right
		dfs(i - 1, j, sum - arr[i][j], cnt + 1);
		dfs(i + 1, j, sum - arr[i][j], cnt + 1);// down
		vis[i][j] = 0;
	}
}
