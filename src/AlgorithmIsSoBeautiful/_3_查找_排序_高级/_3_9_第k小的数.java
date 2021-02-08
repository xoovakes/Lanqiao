package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import org.assertj.core.api.Assertions;

/**
 * 第k小的数
 * 第一种方法(正常的方法): 对先排序，然后找下标
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/07 下午 10:31
 */
public class _3_9_第k小的数 {
    public static void main(String[] args) {
//        int[] arr = Utils.AboutArray.intRandomArray(10, 1, 10);
        int[] arr = new int[]{5, 6, 10, 5, 8, 1, 2, 7, 4, 9};
        Utils.AboutArray.printIntArray(arr);
        int k =new _3_9_第k小的数().selectK(arr, 0, arr.length - 1, 6);
        Assertions.assertThat(k).isEqualTo(6);
        Utils.AboutArray.printIntArray(arr);
    }

    /**
     * 期望O(n),最差O(n^2)
     *
     * @return1
     */
    public int selectK(int[] arr, int low, int high, int k) {
        int q = new QuickSort().partition(arr, low, high);
        int qK = q - low + 1;
        if (qK == k) {
            return arr[q];
        } else if (qK > k) {
            return selectK(arr, low, q - 1, k);
        } else {
            return selectK(arr, q + 1, high, k - qK);
        }
    }
}
