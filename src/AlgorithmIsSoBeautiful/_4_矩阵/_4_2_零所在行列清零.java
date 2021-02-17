package AlgorithmIsSoBeautiful._4_矩阵;

/**
 * _4_2_零所在行列清零
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/16 上午 11:52
 */
public class _4_2_零所在行列清零 {
    public static void main(String[] args) {
        int[][] matrix = {
                {31, 32, 33, 34, 21},
                {35, 36, 37, 38, 22},
                {39, 0, 11, 12, 23},
                {13, 14, 15, 0, 24},
                {25, 26, 27, 28, 29}
        };
        Utils.AboutArray.printTwoDimensionalArray(matrix);
        System.out.println("-----------------");
        new _4_2_零所在行列清零().clearZeros(matrix);
        Utils.AboutArray.printTwoDimensionalArray(matrix);
    }

    private void clearZeros(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[] rowRecord = new int[M];
        int[] colRecord = new int[N];
        for (int i = 0; i < rowRecord.length; i++) {
            for (int j = 0; j < colRecord.length; j++) {
                if (matrix[i][j] == 0) {
                    rowRecord[i] = 1;
                    colRecord[j] = 1;
                }
            }
        }
        for (int i = 0; i < rowRecord.length; i++) {
            for (int j = 0; j < colRecord.length; j++) {
                if (rowRecord[i] == 1 || colRecord[j]== 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
