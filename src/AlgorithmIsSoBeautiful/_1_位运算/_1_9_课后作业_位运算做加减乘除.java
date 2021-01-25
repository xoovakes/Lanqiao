package AlgorithmIsSoBeautiful._1_位运算;

import java.util.Scanner;

/**
 * TODO: 除法没看懂
 * _1_9_课后作业_位运算做加减乘除
 * 整数的,
 * reference: https://www.cnblogs.com/kiven-code/archive/2012/09/15/2686922.html
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/24 下午 2:46
 */
public class _1_9_课后作业_位运算做加减乘除 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("这样输入（1 + 2）：");
        int a = in.nextInt();
        String fu = in.next();
        int b = in.nextInt();
        switch (fu) {
            case "+":
                System.out.println(add(a, b));
                break;
            case "-":
                System.out.println(jian(a, b));
                break;
            case "*":
                System.out.println(cheng(a, b));
                break;
            case "/":
                System.out.println(chu(a, b));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + fu);
        }
    }

    //累减方法
    private static int chu1(int a, int b) {
        //两个数取绝对值
        int c = a < 0 ? add(~a, 1) : a;
        int d = b < 0 ? add(~b, 1) : b;
        //求商
        int result = c;
        int count = 0;
        while (result >= d) {
            result = result - d;
            count++;
        }
        //符号变回来
        if ((a ^ b) < 0) {
            count = ~count + 1;
        }
        return count;
    }

    //加权累减方法
    private static int chu(int a, int b) {
        //对被除数和除数取绝对值
        int dividend = a < 0 ? add(~a, 1) : a;
        int divisor = b < 0 ? add(~b, 1) : b;
        //获得被除数的反序 比如dividend=101011 invert=1110101,invert最高位会多一个1,
        //这是为了防止dividend=1010,则直接反转为0101,这个时候原来的最低位的0就会丢失
        int invert = 2;
        while (dividend != 0) {
            invert |= dividend & 0x1;
            invert = invert << 1;
            dividend = dividend >> 1;
        }
        int quotient = 0;
        int remainder = 0;
        //排除最高位的1
        while (invert > 1) {
            remainder = remainder << 1;
            remainder |= invert & 0x1;
            invert = invert >> 1;
            quotient = quotient << 1;

            if (remainder >= divisor) {
                quotient |= 0x1;
                remainder = remainder - divisor;
            }
        }
        //求商的符号
        if ((a ^ b) < 0) {
            quotient = add(~quotient, 1);
        }
        return quotient;
    }

    private static int cheng(int a, int b) {
        //两个数取绝对值
        int c = a < 0 ? add(~a, 1) : a;
        int d = b < 0 ? add(~b, 1) : b;
        //乘积
        int result = 0;
        while (c != 0) {
            //减少运算步骤，像小学乘法一样，0的地方不用乘
            if ((c & 0x1) != 0) {
                result = add(result, d);
            }
            d <<= 1;
            //其实c在while循环里面只用看最右边那位是1还是0，还有判断乘法结束没有
            c >>= 1;
        }
        //符号换回来
        if ((a ^ b) < 0) {
            result = add(~result, 1);
        }
        return result;
    }

    private static int jian(int a, int b) {
        //取减数b的相反数
        int fan = add(~b, 1);
        int jian = add(a, fan);
        return jian;
    }

    private static int add(int a, int b) {
        int sum = a;
        int carry = b;
        while (carry != 0) {
            int tmp = sum;
            // 第一次执行：两个数不进位相加，结果赋值给sum
            // 第二次执行：把进位的数再加进来给sum
            sum = tmp ^ carry;
            // 用&运算得到进位的数
            carry = (tmp & carry) << 1;
        }
        return sum;
    }
}
