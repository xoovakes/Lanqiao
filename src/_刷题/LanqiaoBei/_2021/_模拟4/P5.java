package _刷题.LanqiaoBei._2021._模拟4;

public class P5 {
	public static void main(String[] args) {
		String input = "110101202102219998";
		int[] quan = { 1, 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4, 8, 5, 10, 9, 7 };
		int[] nums = new int[18];
		for (int i = 17; i >= 0; i--) {
			char c = input.charAt(i);
			if (c == 'X') {
				nums[17 - i] = 10;
			} else {
				nums[17 - i] = c - '0';
			}
		}
		int sum = 0;
		for (int i = 0; i < 18; i++) {
			System.out.println(quan[i] + " " + nums[i]);
			sum += quan[i] * nums[i];
		}
		int ans = sum % 11;
		System.out.println(ans);
	}
}
