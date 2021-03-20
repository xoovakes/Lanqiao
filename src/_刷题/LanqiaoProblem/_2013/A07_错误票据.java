package _刷题.LanqiaoProblem._2013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A07_错误票据
 * 
 * @author zixi
 *
 */
public class A07_错误票据 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int N = sc.nextInt();
		sc.nextLine();// 吃掉整数后面的换行符
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			String[] split = line.split(" ");
			for (int j = 0; j < split.length; j++) {
				list.add(Integer.parseInt(split[j]));
			}
		}
//		System.out.println(list.size());//测试数据是否正常
		Collections.sort(list);
		int a = 0, b = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) - list.get(i - 1) == 2)
				a = list.get(i) - 1;
			if (list.get(i).equals(list.get(i - 1)))
				b = list.get(i);
		}
		System.out.println(a + " " + b);
	}
}
