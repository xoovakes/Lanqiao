package AlgorithmIsSoBeautiful._5_字符串._字符串匹配;

/**
 * _5_14_KMP
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/21 下午 11:07
 */
public class _5_14_KMP {
    /**
     * 暴力解法
     * O(mxn)
     *
     * @param s 主串
     * @param p 子串
     * @return 位置
     */
    private static int indexOf(String s, String p) {
        int i = 0, j = 0;
        int sc = i;
        while (sc < s.length()) {
            if (s.charAt(sc++) == p.charAt(j++)) {
                if (j == p.length()) {
                    return i;
                }
            } else {
                i++;
                sc = i;
                j = 0;
            }
        }
        return -1;
    }

    /**
     * KMP
     * O(m+n)
     *
     * @param s 主串
     * @param p 子串
     * @return 位置
     */
    private static int indexOf1(String s, String p) {
        if (s.length() == 0 || p.length() == 0 || p.length() > s.length()) {
            return -1;
        }
        int[] next = next(p);
        int i = 0, j = 0;
        int sLen = s.length(), pLen = p.length();
        while (i < sLen) {
            //满足 j == -1,因为next[0]=-1,说明p的第一位和i这个位置无法匹配
            //或者,字符匹配成功(s.charAt(i) == p.charAt(j)),i++;j++ 继续推进
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            //如果 j != -1,或者,字符匹配失败(s.charAt(i) != p.charAt(j))
            //去递推，j = next[j]
            else {
                j = next[j];
            }
            //匹配成功
            if (j == pLen) {
                return (i - j);
            }
        }
        return -1;
    }

    private static int[] next(String ps) {
        int pLength = ps.length();
        int[] next = new int[pLength];
        char[] p = ps.toCharArray();
        next[0] = -1;
        if (pLength == 1) return next;
        next[1] = 0;
        int j = 1;
        //看看位置j的最长匹配前缀在哪里
        int k = next[j];
        while (j < pLength - 1) {
            if (k < 0 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String src = "babcababcbbbabababdbaababb";
        Utils.ComputingTime.beginCompute();
        System.out.println(indexOf(src, "baba"));
        Utils.ComputingTime.endCompute();
        Utils.ComputingTime.beginCompute();
        System.out.println(indexOf1(src, "baba"));
        Utils.ComputingTime.endCompute();
    }
}
