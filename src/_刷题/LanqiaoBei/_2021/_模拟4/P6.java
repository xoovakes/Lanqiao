package _刷题.LanqiaoBei._2021._模拟4;

import java.util.Scanner;

public class P6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String ans = "";
//		System.out.println(str);
		// !!start
		char c = str.charAt(0);
		if (c >= 'a' && c <= 'z') {
			c = (char) (c + ('A' - 'a'));
		}
		ans += c + "";
		for (int i = 1; i < str.length(); i++) {
			c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				c = (char) (c - ('A' - 'a'));
			}
			ans += c + "";
		}
		System.out.println(ans);
	}
}
