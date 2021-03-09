package AlgorithmIsSoBeautiful._7_递归_DFS_剪枝.Dfs;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Dfs2_部分和
 * 输入:
 * 4
 * 1 2 4 7
 * 13
 * 输出:
 * Yes (13 = 2 + 4 + 7)
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/05 下午 7:24
 */
public class Dfs2_部分和 {
    static int kk;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        kk = k;
        dfs(a, k, 0, new ArrayList<Integer>());
    }

    private static void dfs(int[] a, int k, int cur, ArrayList<Integer> ints) {
        // 出口
        if (k == 0) {
            System.out.print("Yes (" + kk + " = ");
            int size = ints.size();
            for (int i = 0; i < size; i++) {
                System.out.print(ints.get(i) + (i == size - 1 ? "" : " + "));
            }
            // 只需要输出一个解
            System.out.println(")");
            exit(0);
        }
        if (k < 0 || cur == a.length) {
            return;
        }
        // 分两种情况，生成一个二叉树，一边加cur，一边不加cur
        // 不要cur这个元素
        dfs(a, k, cur + 1, ints);
        // 要cur这个元素
        ints.add(a[cur]);
        dfs(a, k - a[cur], cur + 1, ints);
        // 回溯
        int index = ints.size() - 1;
        ints.remove(index);
    }

}
