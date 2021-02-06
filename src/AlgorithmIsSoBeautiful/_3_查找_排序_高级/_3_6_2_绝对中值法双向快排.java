package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import AlgorithmIsSoBeautiful._2_查找_排序_初级.InsertionSort;

/**
 * 绝对中值法优化过的双向快排
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/05 下午 3:48
 */
public class _3_6_2_绝对中值法双向快排 {
    public static void main(String[] args) {
        int[] arr = Utils.AboutArray.intRandomArray(12, 1, 10);
        Utils.AboutArray.printIntArray(arr);
        Utils.ComputingTime.beginCompute();
        new _3_6_2_绝对中值法双向快排().quickSort(arr, 0, arr.length - 1);
        Utils.ComputingTime.endCompute();
        Utils.AboutArray.printIntArray(arr);
    }

    public void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    /**
     * 求数组的绝对中值
     * @param arr 所求数组
     * @param p
     * @param r
     * @return 返回绝对中值
     */
    public int getMediam(int[] arr, int p, int r) {
        return 1;
    }

    public int partition(int[] arr, int p, int r) {
        Utils.AboutArray.swapInArray(arr, p, p);
        int left = p + 1;
        int right = r;
        while (left <= right) {
            while (left <= right && arr[left] <= arr[p]) {
                left++;
            }
            while (left <= right && arr[right] > arr[p]) {
                right--;
            }
            if (left < right) {
                Utils.AboutArray.swapInArray(arr, left, right);
            }
        }
        Utils.AboutArray.swapInArray(arr, p, right);
        return right;
    }
}
