package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import Utils.MyUtils;

/**
 * 快排之单向扫描分区法
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/30 下午 10:43
 */
public class _3_3_快排之单向扫描分区法 {
    public static void main(String[] args) {
        MyUtils u = new MyUtils();
        _3_3_快排之单向扫描分区法 c = new _3_3_快排之单向扫描分区法();
        //
        int[] arr = u.intRandomArray(16, 1, 10);
//        int[] arr = new int[]{43,54,234,672,32};
        u.printIntArray(arr);
        u.beginCompute();
        c.quickSort(arr, 0, arr.length - 1);
        u.printIntArray(arr);
        u.endCompute();
    }

    public void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    public int partition(int[] arr, int p, int r) {
        int sp = p + 1;
        int bigger = r;
        while (sp <= bigger) {
            if (arr[sp] <= arr[p]) {
                sp++;
            } else {
                arr[sp] ^= arr[bigger];
                arr[bigger] ^= arr[sp];
                arr[sp] ^= arr[bigger];
                bigger--;
            }
        }
        arr[p] ^= arr[bigger];
        arr[bigger] ^= arr[p];
        arr[p] ^= arr[bigger];
        return bigger;
    }
}
