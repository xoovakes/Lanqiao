package AlgorithmIsSoBeautiful._7_递归_DFS_剪枝.Dfs;

/**
 * Dfs4_n皇后问题
 * 请设计一种算法，解决著名的N皇后问题。这里的n皇后问题指在一个n*n的棋盘上放置n个旗子，
 * 使得每行每列和每条对角线上都只有一个旗子，求其摆放的方法数。
 * 输入：给定一个n, 请返回方法数，保证n小于等于15
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/09 下午 1:42
 */
public class Dfs4_n皇后问题 {
    static int n;
    static int cnt;
    static int[] rec;

    public static void main(String[] args) {
        n = 4;
        rec = new int[n];
        dfs(0);
        System.out.println(cnt);
    }

    // row 是当前正在处理的行
    private static void dfs(int row) {
        if (row == n) {
            cnt++;
            return;
        }
        // check: 依次尝试在某列上放一个皇后
        for (int col = 0; col < n; col++) {
            boolean ok = true;
            // 检查皇后有没有冲突
            for (int i = 0; i < row; i++) {
                if (rec[i] == col || rec[i] + i == row + col || rec[i] - i == col - row) {
                    ok = false;
                    break;
                }
            }
            //剪枝
            if (ok) {
                // 标记，这一行的这一列可以放
                rec[row] = col;
                // 继续找下一行
                dfs(row + 1);
                //恢复原状，写不写都可以
                //rec[row] = 0;
            }
        }
    }
}
