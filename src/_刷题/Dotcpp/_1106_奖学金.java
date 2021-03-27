package _刷题.Dotcpp;

import java.util.Arrays;
import java.util.Scanner;

//https://www.dotcpp.com/oj/problem1106.html

public class _1106_奖学金 {
	// 用面向对象简单很多
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Score[] score = new Score[N];
		for (int i = 0; i < N; i++) {
			score[i] = new Score(i + 1, sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(score);
		// 结果
		int i = 0;
		while (i <= 5) {
			if ((N < 5 && i == N - 1) || i == 4) {
				System.out.print(score[i].getId() + " " + score[i].getTotal());
				break;
			}
			System.out.println(score[i].getId() + " " + score[i].getTotal());
			i++;
		}
	}

	private static class Score implements Comparable<Score> {
		int id;
		int a;
		int b;
		int c;

		public int getId() {
			return id;
		}

		public Score(int id, int a, int b, int c) {
			super();
			this.id = id;
			this.a = a;
			this.b = b;
			this.c = c;
		}

		public int getTotal() {
			return a + b + c;
		}

		@Override
		public int compareTo(Score o) {
			int x = o.getTotal() - this.getTotal();
			if (x == 0) {
				int y = o.a - this.a;
				if (y == 0) {
					return this.getId() - o.getId();
				} else {
					return y;
				}
			} else {
				return x;
			}
		}

	}
}
