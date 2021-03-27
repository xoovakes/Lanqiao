package _刷题.LanqiaoBei._2021._模拟4;

public class P1 {
	static int ans;

	public static void main(String[] args) {
		ans = 0;
		for (int i = 1900; i <= 2020; i++) {
			check(i);
		}
		System.out.println(ans);
	}

	private static void check(int n) {
		boolean flag = true;
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println(n);
			ans++;
		}
	}
}
