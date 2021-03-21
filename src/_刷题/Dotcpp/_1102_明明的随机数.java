package _刷题.Dotcpp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//https://www.dotcpp.com/oj/problem1102.html

public class _1102_明明的随机数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// N<=100,用普通排序;Set去重，转Arraylist排序.
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			set.add(sc.nextInt());
		}
		ArrayList<Integer> list = new ArrayList<>(set);
		list.sort(null);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				System.out.print(list.get(i));
				break;
			}
			System.out.print(list.get(i) + " ");
		}
	}
}
