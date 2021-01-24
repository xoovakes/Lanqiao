package AlgorithmIsSoBeautiful;

import java.util.Scanner;

/**
 * _1_9_课后作业_位运算做加减乘除
 * 整数的,
 * reference:
 * https://www.cnblogs.com/kiven-code/archive/2012/09/15/2686922.html
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

    private static int chu(int a, int b) {
        int x,y,ans=0;
        return 1;
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
