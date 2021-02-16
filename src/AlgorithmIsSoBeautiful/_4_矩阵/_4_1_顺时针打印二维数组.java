package AlgorithmIsSoBeautiful._4_矩阵;

/**
 * _4_1_顺时针打印二维数组
 * row-行,col-列
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/14 下午 11:52
 */
public class _4_1_顺时针打印二维数组 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 21},
                {5, 6, 7, 8, 22},
                {9, 10, 11, 12, 23},
                {13, 14, 15, 16, 24},
                {0, 0, 0, 0, 0}
        };
        new _4_1_顺时针打印二维数组().printByClockWise(matrix);
    }

    private void printByClockWise(int[][] matrix) {
        //左上角坐标
        int leftUpRow = 0, leftUpCol = 0;
        //右下角坐标
        int rightDownRow = matrix.length - 1, rightDownCol = matrix[0].length - 1;
        while (leftUpCol <= rightDownCol && leftUpRow <= rightDownRow) {
            //游标
            int row = leftUpRow, col = leftUpCol;
            //打印上边
            while (col <= rightDownCol) {
                System.out.print(matrix[row][col++] + " ");
            }
            col--;
            row++;
            //打印右边
            while (row <= rightDownRow) {
                System.out.print(matrix[row++][col] + " ");
            }
            row--;
            col--;
            //打印下边
            while (col >= leftUpCol) {
                System.out.print(matrix[row][col--] + " ");
            }
            col++;
            row--;
            //打印左边
            while (row > leftUpRow) {
                System.out.print(matrix[row--][col] + " ");
            }
            leftUpRow++;
            leftUpCol++;
            rightDownRow--;
            rightDownCol--;
        }
    }
}
