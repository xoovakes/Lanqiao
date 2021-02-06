package AlgorithmIsSoBeautiful._2_查找_排序_初级.test;

import AlgorithmIsSoBeautiful._2_查找_排序_初级.InsertionSort;

/**
 * 测试非递归的插入排序
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/05 下午 6:23
 */
public class test_insertionSort {
    public static void main(String[] args) {
        int[] arr = Utils.AboutArray.intRandomArray(12, 1, 10);
        Utils.AboutArray.printIntArray(arr);
        Utils.ComputingTime.beginCompute();
        InsertionSort.sort(arr,0,arr.length-1);
        Utils.ComputingTime.endCompute();
        Utils.AboutArray.printIntArray(arr);
    }
}
