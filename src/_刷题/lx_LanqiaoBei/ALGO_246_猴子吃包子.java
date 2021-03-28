package _刷题.lx_LanqiaoBei;

import java.util.Scanner;

// http://lx.lanqiao.cn/problem.page?gpid=T632
// 大数除法

public class ALGO_246_猴子吃包子 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double z = sc.nextDouble();
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double z1 = sc.nextDouble();
		int p = sc.nextInt();
		double res = x1 / x + y1 / y + z1 / z;
		System.out.printf("%." + p + "f", res);
	}
}
