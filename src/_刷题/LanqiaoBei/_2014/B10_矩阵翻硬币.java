package _刷题.LanqiaoBei._2014;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * B10_矩阵翻硬币
 * 非常复杂的一道题，数学问题，n,m <= 10^1000
 * <p>
 * 第x行第y列被翻动的总次数？
 * 考虑第1行，第y列，y有多少真因子，就会被翻动多少次，而所有的y中，只有平方数的真因子个数为奇数（约数总数成对出现的）
 * 考虑第1行，第x行，x有多少真因子，就会被翻动多少次，而所有的x中，只有平方数的真因子个数为奇数
 * x,y硬币被翻动的次数=  x真因子个数*y真因子个数，只有奇数*奇数=奇数，所以，若要x,y为反面，必须x,y都是平方数
 * 因此，反面硬币总数=m中的平方数的个数*n中平方数的个数
 * 那么在m中有多少个平方数呢？
 * 答案是sqrt(m)向下取整，如9内有三个平方数1,4,9；16里面有4个平方数，25里面有5个平方数
 * 因此，此题等价于求 sqrt(m)*sqrt(n)，那么怎么对一个很大的数开平方呢？
 * 假设一个数的长度为length，其平方根的长度为length/2 (偶数) 或者length/2+1(奇数)
 * 我们可以从高位不停地试探，每一个去平方后恰好不超过目标平方数的值
 * <p>
 * https://www.dotcpp.com/oj/problem1450.html
 * https://www.bilibili.com/video/BV1GE411F7Pj?p=185
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/30 下午 7:09
 */
public class B10_矩阵翻硬币 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(sqrt(s1).multiply(sqrt(s2)).toString());
    }

    private static BigInteger sqrt(String s) {
        int length = s.length();
        int len = 0;
        if (length % 2 == 0) {
            len = length / 2;
        } else {
            len = length / 2 + 1;
        }
        char[] sArr = new char[len];
        Arrays.fill(sArr, '0');
        BigInteger target = new BigInteger(s);
        for (int pos = 0; pos < len; pos++) {
            for (char c = '1'; c <= '9'; c++) {
                sArr[pos] = c;//在pos这个位置上试着填入1-9
                BigInteger pow = new BigInteger(String.valueOf(sArr)).pow(2);
                if (pow.compareTo(target) == 1) {
                    sArr[pos] -= 1;
                    break;
                }
            }
        }
        return new BigInteger(String.valueOf(sArr));
    }
}
