package _刷题.LanqiaoBei._2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class G_外卖店优先级 {
	private static int n, m, t;
	private static Dates[] dates;
	private static ArrayList<Integer> arr = new ArrayList<>();
	private static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();// 店家
		m = sc.nextInt();// 订单数
		t = sc.nextInt();// 多少时间内
		dates = new Dates[m];
		for (int i = 0; i < dates.length; i++) {
			dates[i] = new Dates(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(dates);
		solve(0, 0);
	}

	private static void solve(int time, int p) {
		for (int i = p; i < dates.length; i++) {
			if (dates[i].ts == time) {
				if (!map.containsKey(dates[i].id)) {
					map.put(dates[i].id, 2);
				} else {
					int ts0 = map.get(dates[i].id);
					map.put(dates[i].id, ts0 + 2);
				}
			} else {
				p = i;
				break;
			}
		}

		if (time != t) {
			solve(time + 1, p);
		}
	}

	private static class Dates implements Comparable<Dates> {
		int ts;
		int id;

		public Dates(int ts, int id) {
			this.ts = ts;
			this.id = id;
		}

		@Override
		public int compareTo(Dates o) {
			if (ts < o.ts)
				return -1;
			else if (ts > o.ts)
				return 1;
			else
				return 0;
		}

	}
}
