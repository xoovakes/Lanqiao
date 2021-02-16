package AlgorithmIsSoBeautiful._4_矩阵;

/**
 * _4_3_Z字型打印
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/16 上午 11:52
 */
public class _4_3_Z字型打印 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 6, 7, 15},
                {3, 5, 8, 14, 16},
                {4, 9, 13, 17, 22},
                {10, 12, 18, 21, 23},
                {11, 19, 20, 24, 25}
        };
        new _4_3_Z字型打印().printMatrixZ(matrix);
    }

    private void printMatrixZ(int[][] matrix) {
        int row = 0, m = matrix.length;
        int col = 0, n = matrix[0].length;
        boolean l2r = true;
        while (row < m && col < n) {
            System.out.print(matrix[row][col] + " ");
            //从左下到右上
            if (l2r) {
                //到上边界
                if (row == 0 && col < n - 1) {
                    l2r = false;
                    col++;
                }
                //到右边界
                else if (col == n - 1) {
                    l2r = false;
                    row++;
                }
                //正常从左下到右上
                else {
                    row--;
                    col++;
                }
            }
            //从右上往左下
            else {
                //到左边界
                if (col == 0 && row < m - 1) {
                    l2r = true;
                    row++;
                }
                //到下边界
                else if (row == m - 1) {
                    l2r = true;
                    col++;
                }
                //正常从右上到左下
                else {
                    row++;
                    col--;
                }
            }
        }
    }
}
