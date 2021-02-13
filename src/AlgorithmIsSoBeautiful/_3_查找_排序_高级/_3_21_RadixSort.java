package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import java.util.ArrayList;

/**
 * _3_21_RadixSort
 * 时间复杂度：kN，k为最大数的10进制位数
 * 空间复杂度：桶是10个，10个桶里面存n个元素，这些空间都是额外开辟的，所以额外的空间是N+k，k是进制。
 * 稳定性：假设有相等的元素，它们会依次入桶，依次回数组，不会交叉，所以是稳定的。
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/10 下午 10:49
 */
public class _3_21_RadixSort {
    private ArrayList[] bucket;

    public static void main(String[] args) {
        int[] arr = Utils.AboutArray.intRandomArray(10, 1, 20);
        Utils.AboutArray.printIntArray(arr);
        new _3_21_RadixSort().sort(arr);
        Utils.AboutArray.printIntArray(arr);
    }

    public _3_21_RadixSort() {
        //10个桶，每个桶装的数个数不定，适合用数组加ArrayList
        bucket = new ArrayList[10];
        //初始化桶
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList();
        }
    }

    public void sort(int[] arr) {
        //最大值
        int max = Utils.AboutArray.maxOf(arr);
        //最大数据的位数
        int dNum = Utils.Others.findDigitsOfNumber(max);
        //入桶，依据的位，初始化为1
        int d = 1;
        while (d <= dNum) {
            //依据第二个参数入桶和出桶
            sort(arr, d++);
        }
    }

    /**
     * 将数组arr，按d这个位来分配和收集
     *
     * @param arr 数组
     * @param d   位数
     */
    public void sort(int[] arr, int d) {
        //全部入桶
        for (int j : arr) {
            putInBucket(j, Utils.Others.getDigitOn(j, d));
        }
        //出桶，回到原数组
        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (Object m : bucket[i]) {
                arr[k++] = (Integer) m;
            }
        }
        //桶清空
        clearAll();
    }

    public void putInBucket(int data, int digitOn) {
        switch (digitOn) {
            case 0:
                bucket[0].add(data);
                break;
            case 1:
                bucket[1].add(data);
                break;
            case 2:
                bucket[2].add(data);
                break;
            case 3:
                bucket[3].add(data);
                break;
            case 4:
                bucket[4].add(data);
                break;
            case 5:
                bucket[5].add(data);
                break;
            case 6:
                bucket[6].add(data);
                break;
            case 7:
                bucket[7].add(data);
                break;
            case 8:
                bucket[8].add(data);
                break;
            default:
                bucket[9].add(data);
                break;
        }
    }

    private void clearAll() {
        for (ArrayList b : bucket) {
            b.clear();
        }
    }
}
