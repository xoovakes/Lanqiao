package _刷题.LanqiaoBei._2015;

//全排列问题

public class B05_九数组分数 {
	public static void test(int[] x) {
		int a = x[0] * 1000 + x[1] * 100 + x[2] * 10 + x[3];
		int b = x[4] * 10000 + x[5] * 1000 + x[6] * 100 + x[7] * 10 + x[8];
		if (a * 3 == b)
			System.out.println(a + " " + b);
	}

	public static void f(int[] x, int k) {
		if (k >= x.length) {
			test(x);
			return;
		}
		for (int i = k; i < x.length; i++) {
			{
				int t = x[k];
				x[k] = x[i];
				x[i] = t;
			} // 提示多条语句也可以是一行
			f(x, k + 1);
			{
				int t = x[k];
				x[k] = x[i];
				x[i] = t;
			} // 填空
		}
	}

	public static void main(String[] args) {
		int[] x = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		f(x, 0);
	}
}