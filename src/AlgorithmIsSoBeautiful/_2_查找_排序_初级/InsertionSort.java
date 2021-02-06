package AlgorithmIsSoBeautiful._2_查找_排序_初级;

/**
 * 非递归版插入排序
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/05 下午 6:11
 */
public class InsertionSort {
    public static void sort(int[] arr, int low, int high) {
        for (int i = low + 1; i < high + 1; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    Utils.AboutArray.swapInArray(arr, j, j - 1);
                }
            }
        }
    }
}
