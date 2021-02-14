package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import java.util.Arrays;

/**
 * _3_24_需要排序的子数组
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/14 下午 3:19
 */
public class _3_24_需要排序的子数组 {
    public static void main(String[] args) {
        int[] arr = Utils.AboutArray.getRandomArrWithoutRepetition(10, 1, 20);
        new QuickSort().quickSort(arr,0,5);
        Utils.AboutArray.printIntArray(arr);
        arr = new _3_24_需要排序的子数组().findSegment(arr);
        Utils.AboutArray.printIntArray(arr);
    }

    public int[] findSegment(int[] arr) {
        int begin = -1;
        int end = -1;
        int max = arr[0];
        int min = arr[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < max) {
                end = i;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > min) {
                begin = i;
            }
        }
        if(begin==-1){
            return arr;
        }
        return Arrays.copyOfRange(arr,begin,end);
    }
}
