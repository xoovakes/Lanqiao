package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import java.util.Arrays;

/**
 * _3_14_1_合并有序数组
 * 参考归并排序的merge
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/08 下午 10:44
 */
public class _3_14_1_合并有序数组 {
    public static void main(String[] args) {
        // a.创建题目条件
        int[] arr1 = Utils.AboutArray.intRandomArray(20, 1, 20);
        Arrays.sort(arr1);
        for (int i = 10; i < arr1.length; i++) {
            arr1[i] = 0;
        }
        int[] arr2 = Utils.AboutArray.intRandomArray(10, 1, 20);
        Arrays.sort(arr2);
        Utils.AboutArray.printIntArray(arr1);
        Utils.AboutArray.printIntArray(arr2);
        // end a.
        System.out.println("结果：");
        arr1 = new _3_14_1_合并有序数组().merge(arr1,arr2);
        Utils.AboutArray.printIntArray(arr1);
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int current = arr1.length - 1;
        int p1 = arr1.length - arr2.length - 1;
        int p2 = arr2.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (arr1[p1] >= arr2[p2]) {
                arr1[current--] = arr1[p1--];
            } else {
                arr1[current--] = arr2[p2--];
            }
        }
        while (p2 >= 0) {
            arr1[current--] = arr2[p2--];
        }
        return arr1;
    }
}
