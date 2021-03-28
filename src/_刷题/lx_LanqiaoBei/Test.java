package _刷题.lx_LanqiaoBei;

import java.math.BigDecimal;

public class Test {
	public static void main(String[] args) {
		BigDecimal t = BigDecimal.ONE;
		t = t.divide(t, 32);
		System.out.println(t.toString());
	}
}
