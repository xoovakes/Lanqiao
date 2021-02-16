package AlgorithmIsSoBeautiful._4_矩阵;

/**
 * _4_4_边界为1的最大子矩阵
 * TODO findLargestSubMatrix2-预处理
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/16 下午 3:07
 */
public class _4_4_边界为1的最大子矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 0, 1, 1}
        };
        int k = new _4_4_边界为1的最大子矩阵().findLargestSubMatrix1(matrix, matrix.length);
        System.out.println(k);
        k = new _4_4_边界为1的最大子矩阵().findLargestSubMatrix2(matrix, matrix.length);
        System.out.println(k);
    }

    public int findLargestSubMatrix2(int[][] matrix, int N) {
        return 0;
    }

    public int findLargestSubMatrix1(int[][] matrix, int N) {
        int n = N;
        while (n > 0) {
            for (int i = 0; i < N && i + n <= N; i++) {
                l3:
                for (int j = 0; j < N && j + n <= N; j++) {
                    //检查四条边
                    int r = i, c = j;
                    while (c < j + n) {
                        if (matrix[r][c++] == 0) {
                            continue l3;
                        }
                    }
                    c--;
                    while (r < i + n) {
                        if (matrix[r++][c] == 0) {
                            continue l3;
                        }
                    }
                    r--;
                    while (c >= j) {
                        if (matrix[r][c--] == 0) {
                            continue l3;
                        }
                    }
                    c++;
                    while (r >= i) {
                        if (matrix[r--][c] == 0) {
                            continue l3;
                        }
                    }
                    return n;
                }
            }
            n--;
        }
        return 0;
    }
}
