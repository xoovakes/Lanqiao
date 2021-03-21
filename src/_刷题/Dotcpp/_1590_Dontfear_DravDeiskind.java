package _刷题.Dotcpp;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.dotcpp.com/oj/problem1590.html
// 这题太奇葩了，水平不够

public class _1590_Dontfear_DravDeiskind {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Car> list = new ArrayList<Car>();
		for (int i = 0; i < N; i++) {
			int v = sc.nextInt();
			int c = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();
			list.add(new Car(v, c, l, r));
		}
	}

	private static class Car implements Comparable<Car> {
		int v;
		int c;
		int l;
		int r;

		public Car(int v, int c, int l, int r) {
			super();
			this.v = v;
			this.c = c;
			this.l = l;
			this.r = r;
		}

		// 按照l排序
		@Override
		public int compareTo(Car o) {
			int x = this.l - o.l;
			return x;
		}
	}
}
