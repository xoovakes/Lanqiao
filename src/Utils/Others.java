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
     * @param number 被判断的数
     * @return 返回布尔值
     */
    public static boolean isOdd(int number) {
        return (number & 0x1) == 1;
    }
}
