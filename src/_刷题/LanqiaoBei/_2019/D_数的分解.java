package _刷题.LanqiaoBei._2019;

/**
 * D_数的分解
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/16 下午 8:38
 */
public class D_数的分解 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		int input = 2019;

		int ans = 0;
		for (int i = 1; i < 2019; ++i) {
			if (check(i))
				for (int j = i + 1; j < 2019; ++j) {
					if (check(j))
						for (int k = j + 1; k < 2019; ++k) {
							if (check(k) && i + j + k == 2019) {
//								System.out.printf("%d+%d+%d=%d\n", i, j, k, i + j + k);// t
								ans++;
							}
						}
				}
		}
		System.out.println(ans);
	}

	private static boolean check(int num) {
		while (num != 0) {
			if (num % 10 == 2 || num % 10 == 4) {
				return false;
			}
			num /= 10;
		}
		return true;
	}
}
