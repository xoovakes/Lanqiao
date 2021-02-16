package AlgorithmIsSoBeautiful._4_矩阵;

import java.util.Arrays;

/**
 * _4_8_子矩阵最大累加和
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/16 下午 3:30
 */
public class _4_8_子矩阵最大累加和 {
    public static void main(String[] args) {
        //{1, -2, 3, 5, -2, 6, -1} / {{}}
        int[][] matrix = new int[][]{{}};
        int k = new _4_8_子矩阵最大累加和().maxSum(matrix);
        System.out.println(k);
    }

    /**
     * 递推法 O(n三次方)
     */
    public int maxSum(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        if (N == 0) {
            return 0;
        }
        int beginRow = 0;
        int max = 0;
        int[] sums = new int[N];
        while (beginRow < M) {
            for (int i = beginRow; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    sums[j] += matrix[i][j];
                }
                int t = new _4_7_子数组最大累加和().findByDp(sums);
                max = Math.max(max, t);
            }
            Arrays.fill(sums, 0);
            beginRow++;
        }
        return max;
    }
}
