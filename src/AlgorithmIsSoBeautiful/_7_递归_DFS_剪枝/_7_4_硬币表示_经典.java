package AlgorithmIsSoBeautiful._7_递归_DFS_剪枝;

/**
 * _7_4_硬币表示_经典
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/02 下午 6:03
 */
public class _7_4_硬币表示_经典 {
    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            int res1 = countWays(i);
            int res2 = countWays1(i);
            int res3 = countWays2(i);
            System.out.println(i + "--" + res1 + "--" + res2 + "--" + res3);
        }
    }

    //countWays1 和 countWays2 都是递推解法
    // TODO: 21/03/02 两个递推不是很懂,后面讲动态规划应该会动一点
    private static int countWays2(int n) {
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i <= 3; i++) {
            for (int j = coins[i]; j < n + 1; j++) {
                dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
            }
        }
        return dp[n];
    }

    private static int countWays1(int n) {
        int[] coins = {1, 5, 10, 25};
        int[][] dp = new int[4][n + 1];
        for (int i = 0; i < 4; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < 4; i++) {
            //i为可使用的最大面值
            for (int j = 1; j < n + 1; j++) {
                //j要凑的数
                for (int k = 0; k <= j / coins[i]; k++) {
                    //k为当前可使用的最大面值的数量
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                }
            }
        }
        Utils.AboutArray.printTwoDimensionalArray(dp);
        return dp[3][n];
    }

    //递归形式
    private static int countWays(int n) {
        if (n <= 0) {
            return 1;
        }
        return countWaysCore(n, new int[]{1, 5, 10, 25}, 3);
    }

    //老板思维
    private static int countWaysCore(int n, int[] coins, int cur) {
        if (cur == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i * coins[cur] <= n; i++) {
            int shengyu = n - i * coins[cur];
            res += countWaysCore(shengyu, coins, cur - 1);
        }
        return res;
    }
}
