package _刷题._临时放算法作业;

/**
 * 国王分财产
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/04 下午 4:21
 */
public class Exp1_国王分财产 {
    public static void main(String[] args) {
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            int[] property = new int[i + 1];
            int k = getProperty(i, property);
            if (k != -1) {
                System.out.println(i + " " + k);
                break;
            }
        }
    }

    private static int getProperty(int i, int[] property) {
        if (i == 0) {
            return property[0];
        }
        if (property[i] % 9 != 0) {
            return -1;
        } else {
            property[i - 1] = property[i] * 10 / 9 + i;
        }
        return getProperty(i - 1, property);
    }
}
