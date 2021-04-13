package _刷题.LanqiaoBei._2018;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * B04_测试次数
 * 看解析的, https://blog.csdn.net/qq_46340722/article/details/104342945
 * 动态规划好难
 *
 * 思路——动态规划
 * 动态规划方程：f[i][j] i表示手机个数，j表示楼层数。
 * 当i=1时 即每一个j层的楼房，我们都要摔j次，这其实就是最佳策略，那么我们就可以逐渐往上扩展。
 * 假设我们已经把i-1部手机对于所有的楼层的次数都已经找出来了，现在我们来求有i部手机时的测试次数。
 * 为此我们需要遍历 当前之前的楼层k（1~j-1）假设在k层摔坏 我们就选取i-1部手机对于k-1层楼房的最坏情况dp[i-1][k-1]+1
 * 假如在k层没有摔坏 那么我们就可以选取i部手机对于剩下j-k层的最坏情况 dp[i][j-k]+1
 * 由于是最坏运气 我们需要在两者之间取最大值，但我们又是采取的最佳策略， 所以我们需要取最小值，即：
 * d[i][j]=min(dp[i][j],max(dp[i-1][k-1],dp[i][j-k])+1);
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/13 下午 6:42
 */
public class B04_测试次数 {
    private static int max;

    public static void main(String[] args) {
        int[][] dp = new int[5][1005];
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 1000; j++) {
                dp[i][j] = j;
            }
        }
        for (int j = 1; j <= 1000; j++) { // 遍历每层
            for (int i = 2; i <= 3; i++) { // 摔坏了的手机
                for (int k = 2; k < j; k++) { //摔坏的层数
                    dp[i][j] = min(dp[i][j], max(dp[i - 1][k - 1] + 1, dp[i][j - k] + 1));
                }
            }
        }
        System.out.println(dp[3][1000]);
    }
}
