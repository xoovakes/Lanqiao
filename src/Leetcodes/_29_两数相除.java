package Leetcodes;

/**
 * 要求：
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 来源：力扣（LeetCode）
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/25 下午 5:28
 */
public class _29_两数相除 {
    public static void main(String[] args) {
        int a = 8;
        int b = 2;
        _29_两数相除 c = new _29_两数相除();
        System.out.println("结果："+c.divide(a,b));
    }
    public int divide(int dividend, int divisor) {
        return 1;
    }
}
