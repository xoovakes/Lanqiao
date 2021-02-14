package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * _3_20_BucketSort
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/10 下午 10:48
 */
public class _3_20_BucketSort {
    private ArrayList[] bucket;

    public static void main(String[] args) {
        int[] arr = Utils.AboutArray.intRandomArray(10,1,20);
        Utils.AboutArray.printIntArray(arr);
        new _3_20_BucketSort().sort(arr);
        Utils.AboutArray.printIntArray(arr);
    }

    public void sort(int[] arr) {
        int min = arr[0];
        int max = arr[1];
        for (int i : arr) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        //初始化
        int d = max - min;
        int nBucket = arr.length;
        ArrayList<LinkedList<Integer>> bucket = new ArrayList<>(nBucket);
        for (int i = 0; i < arr.length; i++) {
            bucket.add(new LinkedList<>());
        }
        //放入桶
        for (int j : arr) {
            int num = (int) ((j - min) * (nBucket - 1) / d);
            bucket.get(num).add(j);
        }
        //桶内排序
        for (LinkedList<Integer> integers : bucket) {
            Collections.sort(integers);
        }
        //出桶
        int i = 0;
        for (LinkedList<Integer> integers : bucket) {
            for (Integer item : integers) {
                arr[i] = item;
                i++;
            }
        }
    }
}
