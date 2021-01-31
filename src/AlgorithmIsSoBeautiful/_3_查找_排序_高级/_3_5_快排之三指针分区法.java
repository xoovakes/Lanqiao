package AlgorithmIsSoBeautiful._3_查找_排序_高级;

/**
 * 快排之三指针分区法
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/31 下午 9:50
 */
public class _3_5_快排之三指针分区法 {
    public static void main(String[] args) {
        int[] arr = Utils.AboutArray.intRandomArray(10, 1, 10);
        Utils.AboutArray.printIntArray(arr);
        Utils.ComputingTime.beginCompute();
        new _3_5_快排之三指针分区法().quickSort(arr, 0, arr.length - 1);
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
        return 1;
    }
}
