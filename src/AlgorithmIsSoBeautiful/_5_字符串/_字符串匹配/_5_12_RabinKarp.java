package AlgorithmIsSoBeautiful._5_字符串._字符串匹配;

/**
 * _5_12_RabinKarp
 * 滚动hash
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/21 下午 11:07
 */
public class _5_12_RabinKarp {
    final static long seed = 31;

    public static void main(String[] args) {
        String s = "ABABABA";
        String p = "ABA";
        Utils.ComputingTime.beginCompute();
        match1(p, s);
        Utils.ComputingTime.endCompute();
        Utils.ComputingTime.beginCompute();
        match2(p, s);
        Utils.ComputingTime.endCompute();
    }

    /**
     * 这种hash法跟朴素的方法没差
     */
    private static void match1(String p, String s) {
        long hash_p = hash(p);
        int p_len = p.length();
        for (int i = 0; i + p_len <= s.length(); i++) {
            long hash_i = hash(s.substring(i, i + p_len));
            if (hash_i == hash_p) {
                System.out.println("match:" + i);
            }
        }
    }

    /**
     * 使用100000个不同字符串产生的冲突数，大概在0-3波动，
     * 使用100百万不同的字符串，冲突数大概110+范围波动。
     */
    private static long hash(String str) {
        long hash = 0;
        for (int i = 0; i != str.length(); i++) {
            hash = seed * hash + str.charAt(i);
        }
        return hash % Long.MAX_VALUE;
    }

    /**
     * 运用了滚动hash
     *
     * @param p
     * @param s
     */
    private static void match2(String p, String s) {
        long hash_p = hash(p);
        long[] hash_s = hash(s, p.length());
        for (int i = 0; i < hash_s.length; i++) {
            if (hash_s[i] == hash_p) {
                System.out.println("match:" + i);
            }
        }
    }

    /**
     * 滚动hash
     *
     * @param s 主串
     * @param n 子串的长度
     * @return
     */
    private static long[] hash(String s, int n) {
        long[] res = new long[s.length() - n + 1];
        res[0] = hash(s.substring(0, n));
        for (int i = n; i < s.length(); i++) {
            char newChar = s.charAt(i);
            char ochar = s.charAt(i - n);
            res[i - n + 1] = (res[i - n] * seed + newChar - (long) Math.pow(seed, n) * ochar) % Long.MAX_VALUE;
        }
        return res;
    }
}
