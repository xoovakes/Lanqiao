package AlgorithmIsSoBeautiful._3_查找_排序_高级;

/**
 * 快排之双向扫描分区法
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/30 下午 10:43
 */
public class _3_4_快排之双向扫描分区法 {
    public static void main(String[] args) {
        int[] arr = Utils.AboutArray.intRandomArray(10, 1, 10);
        Utils.AboutArray.printIntArray(arr);
        Utils.ComputingTime.beginCompute();
        new _3_4_快排之双向扫描分区法().quickSort(arr, 0, arr.length - 1);
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

    public int partition(int[] arr, int p, int r) {
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
