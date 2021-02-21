package AlgorithmIsSoBeautiful._5_字符串;

import java.util.Arrays;

/**
 * _5_11_最短摘要
 * 尺取法的应用
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/18 下午 11:13
 */
public class _5_11_最短摘要 {
    public static void main(String[] args) {
        Utils.ComputingTime.beginCompute();
        solve1(new String[]{"a", "b", "c", "d", "h", "e", "f", "c", "c", "d", "e", "f", "d", "c"}, new String[]{"c", "e"});
        Utils.ComputingTime.endCompute();
        Utils.ComputingTime.beginCompute();
        solve2(new String[]{"a", "b", "c", "d", "h", "e", "f", "c", "c", "d", "e", "f", "d", "c"}, new String[]{"c", "e"});
        Utils.ComputingTime.endCompute();
    }

    private static void solve2(String[] w, String[] keys) {
        int begin = -1, end = -1;
        //p2保存j的值
        int p2 = -1;
        int minLen = Integer.MAX_VALUE;
        int[] keyFound = new int[keys.length];
        for (int i = 0; i < w.length; i++) {
            Arrays.fill(keyFound, 0);
            String word1 = w[i];
            int index = indexOf(keys, word1);
            if (index == -1) {
                continue;
            }else{
                keyFound[index] = 1;
            }
            int j;
            if (p2 != -1) {
                j = p2;
            } else {
                //第一次时
                j = i + 1;
            }
            for (; j < w.length; j++) {
                String word2 = w[j];
                int index1 = indexOf(keys, word2);
                if (index1 == -1 || keyFound[index1] == 1) {
                    continue;
                }else{
                    keyFound[index1] = 1;
                }
                //全部到齐了吗
                if (sum(keyFound) == keys.length) {
                    p2 = j;
                    if (j - i + 1 < minLen) {
                        begin = i;
                        end = j;
                        minLen = end - begin + 1;
                    }
                    break;
                }
            }
        }
        print(w, begin, end);
    }

    /**
     * 暴力破解
     */
    private static void solve1(String[] w, String[] q) {
        int length = Integer.MAX_VALUE;
        int begin = -1, end = -1;
        for (int i = 0; i < w.length; i++) {
            for (int j = i + 1; j < w.length; j++) {
                if (containsAll(q, w, i, j)) {
                    if (j - i + 1 < length) {
                        length = j - i + 1;
                        begin = i;
                        end = j;
                    }
                    break;
                }
            }
        }
        print(w, begin, end);
    }

    private static boolean containsAll(String[] a, String[] b, int i, int j) {
        for (String a1 : a) {
            boolean flag = false;
            for (int l = i; l <= j; l++) {
                if (a1.equals(b[l])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    private static void print(String[] w, int begin, int end) {
        System.out.println(begin + " " + end);
        for (int i = begin; i <= end; i++) {
            System.out.print(w[i] + " ");
        }
        System.out.println();
    }

    private static int sum(int[] keyFound) {
        int sum = 0;
        for (int i : keyFound) {
            sum += i;
        }
        return sum;
    }

    /**
     * word在q的第几位
     *
     * @param q    字符串
     * @param word 判断的字符
     * @return 返回位置
     */
    private static int indexOf(String[] q, String word) {
        for (int i = 0; i < q.length; i++) {
            if (q[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }
}
