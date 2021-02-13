package Utils;

/**
 * 还没想好分类的工具类
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/07 下午 10:20
 */
public class Others {

    /**
     * 判断一个数是不是奇数
     *
     * @param number 被判断的数
     * @return 返回布尔值
     */
    public static boolean isOdd(int number) {
        return (number & 0x1) == 1;
    }

    /**
     * findDigitsOfNumber
     *
     * @param number 被判断的数
     * @return 返回最高位的位数
     */
    public static int findDigitsOfNumber(int number) {
        int result = 0;
        while (number!= 0) {
            result++;
            number /= 10;
        }
        return result;
    }

    /**
     * getDigitOn
     *
     * @param number 被找的数
     * @param d      第几位
     * @return 数的第d位的数
     */
    public static int getDigitOn(int number, int d) {
        int result = 0;
        for (int i = 0; i < d; i++) {
            result = number % 10;
            number /= 10;
        }
        return result;
    }
}
