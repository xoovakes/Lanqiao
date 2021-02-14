package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import java.util.Arrays;

/**
 * _3_23_排序数组中找和的因子
 * 解法：双指针扫描
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/14 下午 3:08
 */
public class _3_23_排序数组中找和的因子 {
    public static void main(String[] args) {
        int[] arr = Utils.AboutArray.intRandomArray(10, 1, 15);
        Arrays.sort(arr);
        Utils.AboutArray.printIntArray(arr);
        new _3_23_排序数组中找和的因子().findFactor(arr, 0, arr.length - 1, 13);
    }

    public void findFactor(int[] arr, int begin, int end, int k) {
        int left = begin;
        int right = end;
        while (left < right) {
            if (arr[left] + arr[right] == k) {
                System.out.printf("(%d,%d)", arr[left], arr[right]);
                if (arr[right] == arr[right - 1]) {
                    right--;
                    continue;
                }
                left++;
            } else if (arr[left] + arr[right] < k) {
                left++;
            } else if (arr[left] + arr[right] > k) {
                right--;
            }
        }
    }
}
