package AlgorithmIsSoBeautiful._7_递归_DFS_剪枝.Dfs;

/**
 * Dfs6_困难的串
 * 问题：如果一个字符串包含两个相邻的重复子串，则称它为容易的串，其他串称为困难的串，
 * 如：容易，BB,ABCDABCD。困难，D,DC,ABDAB。
 * ---
 * 输入正整数n,L.
 * 输出由前L个字符（大写英文字母组成），
 * 输出字典序第n小的困难的串。
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/09 下午 7:12
 */
public class Dfs6_困难的串 {
    public static void main(String[] args) {
        int n = 10;
        int l = 4;
        dfs(l, n, "");
    }

    static int count;

    private static void dfs(int l, int n, String prefix) {
        //尝试在prefix后追加一个字符
        for (char i = 'A'; i < 'A' + l; i++) {
            if (isHard(prefix, i)) {
                String x = prefix + i;
                count++;
                if (count == n) {
                    System.out.println(x);
                    System.exit(0);
                }
                dfs(l, n, x);
            }
        }
    }

    /**
     * 判断 prefix+i 是否为一个困难的串
     * 1. 遍历所有的长度为偶数的子串，看是否对称
     * 2. prefix 是一个困难的串 ABA i
     *
     * @param prefix
     * @param i
     * @return
     */
    private static boolean isHard(String prefix, char i) {
        // 截取的宽度
        int count = 0;
        for (int j = prefix.length() - 1; j >= 0; j -= 2) {
            final String s1 = prefix.substring(j, j + count + 1);
            final String s2 = prefix.substring(j + count + 1) + i;
            if (s1.equals(s2)) {
                return false;
            }
            count++;
        }
        return true;
    }
}
