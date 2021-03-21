package _刷题.LanqiaoBei._2013;

import java.util.Arrays;

public class B06_三部排序 {
	public static void main(String[] args) {
		int[] arr = { 25, 18, -2, 0, 16, -5, 33, 21, 0, 19, -16, 25, -3, 0 };
		sort(arr);
		// 排序后：-3,-2,-16,-5,0,0,0,21,19,33,25,16,18,25
		System.out.println(Arrays.toString(arr));
	}

	static void sort(int[] x) {
		int p = 0;
		int left = 0;
		int right = x.length - 1;

		while (p <= right) {
			if (x[p] < 0) {
				int t = x[left];
				x[left] = x[p];
				x[p] = t;
				left++;
				p++;
			} else if (x[p] > 0) {
				int t = x[right];
				x[right] = x[p];
				x[p] = t;
				right--;
			} else {
				p++; // 代码填空位置
			}
		}
	}
}
