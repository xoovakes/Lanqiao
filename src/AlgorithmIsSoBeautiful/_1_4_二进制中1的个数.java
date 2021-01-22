package AlgorithmIsSoBeautiful;

/**
 * TODO
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/21 下午 4:18
 */
public class _1_4_二进制中1的个数 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(Integer.toString(n, 2));
        int count = 0;
        //int 是32位的
        //方法一：挪动1，对比每一位的1
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) == (1 << i)) {
                count++;
            }
        }
        System.out.println(count);
        //方法二：挪动原数字
        count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                count++;
            }
        }
        System.out.println(count);
        //方法三：消除几个1
        count = 0;
        int m = n;
        while (m != 0) {
            m = ((m - 1) & m);
            count++;
        }
        System.out.println(count);
    }
}
