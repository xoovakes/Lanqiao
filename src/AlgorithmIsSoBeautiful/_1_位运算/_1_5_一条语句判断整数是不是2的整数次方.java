package AlgorithmIsSoBeautiful._1_位运算;

/**
 * TODO
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/21 下午 4:45
 */
public class _1_5_一条语句判断整数是不是2的整数次方 {
    public static void main(String[] args) {
        int n = 32;
        System.out.println(Integer.toString(n, 2));
        if ((n & (n - 1)) == 0) {
            System.out.println("是");
        } else {
            System.out.println("不是");
        }
    }
}
