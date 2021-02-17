package AlgorithmIsSoBeautiful._5_字符串;

/**
 * _5_1_Different
 * CC150的第一个题
 * 关键：时间换空间；看是ascii还是utf，这里假设是ascii
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/17 下午 2:55
 */
public class _5_1_Different {
    public static void main(String[] args) {
        String str = "abcdefghljka";
        System.out.println(new _5_1_Different().checkDiff(str));
    }

    public boolean checkDiff(String str) {
        if (str.isEmpty()) {
            return true;
        }
        int[] flag = new int[128];
        for (int i = 0; i < str.length(); i++) {
            int c = (int) (str.charAt(i));
            if (flag[c] > 0) {
                return false;
            } else {
                flag[c]++;
            }
        }
        return true;
    }
}
