package _刷题.LanqiaoProblem._2013;

import java.util.ArrayList;
import java.util.Scanner;

public class B08_幸运数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int lucky = 2;
		int index = 1;// 幸运数下标
		int lucky_count = 0;
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> list_r = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}

		while (lucky < n) {
			for (int i = 1; i < list.size(); i++) {
				if (i % lucky == 0) {
					list_r.add(list.get(i));
				}
			}
			index++;
			list.removeAll(list_r);
			list_r.clear();
			if (index >= list.size())
				break;// 越界问题
			lucky = list.get(index);
		}

		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) < n && list.get(i) > m)
				lucky_count++;
		}
		System.out.println(lucky_count);
	}
}
