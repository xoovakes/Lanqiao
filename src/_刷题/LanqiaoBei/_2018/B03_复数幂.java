package _刷题.LanqiaoBei._2018;

import java.util.Scanner;

/**
 * 标题：复数幂
 * 
 * 设i为虚数单位。对于任意正整数n，(2+3i)^n 的实部和虚部都是整数。 求 (2+3i)^123456 等于多少？
 * 即(2+3i)的123456次幂，这个数字很大，要求精确表示。
 * 
 * 
 * 答案写成 "实部±虚部i" 的形式，实部和虚部都是整数（不能用科学计数法表示），中间任何地方都不加空格，实部为正时前面不加正号。(2+3i)^2 写成:
 * -5+12i， (2+3i)^5 的写成: 122-597i
 * 
 * 注意：需要提交的是一个很庞大的复数，不要填写任何多余内容。
 * 
 * @author zixi
 *
 */

// i * i = -1
// 填空题来的，其实可以用excel做，很多题都可以

public class B03_复数幂 {
	private static long a, b, c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inStr = sc.nextLine();
		// 处理输入数据
		StringBuilder s = new StringBuilder();
		// 跳过“（”
		for (int i = 1; i < inStr.length(); i++) {
			char c = inStr.charAt(i);
			if (c == ')' || c == '^') {
				continue;
			}
			if (c == '+') {
				char[] str1 = s.toString().toCharArray();
				a = toLong(str1);
				s.delete(0, s.length());
			} else if (c == 'i') {
				char[] str2 = s.toString().toCharArray();
				b = toLong(str2);
				s.delete(0, s.length());
			} else {
				s.append(c);
			}
		}
		char[] str3 = s.toString().toCharArray();
		c = toLong(str3);
		System.out.println(a + " " + b + " " + c);
		// 快速幂运算
		long[] ans = new long[2];
		ans = pow(c);
		System.out.println("result: " + ans[0] + " " + ans[1] + "i");
	}

	// test - (2+3i)^2 - -5+12i
	// test - (2+3i)^5 - 122-597i
	// (2+3i)^123456
	private static long[] pow(long n) {
		long res1 = 1, res2 = 1;
		long pfs1 = a, pfs2 = b;
		boolean change = false;
		while (n != 0) {
			if ((n & 1) == 1) {
				if (!change) {
					res1 = pfs1;
					res2 = pfs2;
					change = true;
				} else {
					long t2 = res1 * pfs1 - res2 * pfs2;
					res2 = res1 * pfs2 + res2 * pfs1;
					res1 = t2;
					System.out.println(res1 + " " + res2);
				}
			}
			long t1 = pfs1 * pfs1 - pfs2 * pfs2;
			pfs2 = 2 * pfs1 * pfs2;
			pfs1 = t1;
			System.out.println(pfs1 + " " + pfs2);
			n >>= 1;
		}
		return new long[] { res1, res2 };
	}

	private static long toLong(char[] arr) {
		long ans = 0;
		long p = 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			int q = arr[i] - '0';
			ans += q * p;
			p *= 10;
		}
		return ans;
	}
}
