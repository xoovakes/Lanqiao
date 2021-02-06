package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import java.util.HashMap;
import java.util.Map;

/**
 * 快排之三指针分区法
 * 数组有很多相同元素的时候可以使用
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/31 下午 9:50
 */
public class _3_5_快排之三指针分区法 {
    public static void main(String[] args) {
        int[] arr = Utils.AboutArray.intRandomArray(30, 1, 10);
        Utils.AboutArray.printIntArray(arr);
        Utils.ComputingTime.beginCompute();
        new _3_5_快排之三指针分区法().quickSort(arr, 0, arr.length - 1);
        Utils.ComputingTime.endCompute();
        Utils.AboutArray.printIntArray(arr);
    }

    public void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            Map<String, Integer> result = partition(arr, p, r);
            quickSort(arr, p, result.get("q1"));
            quickSort(arr, result.get("q2"), r);
        }
    }

    public Map<String, Integer> partition(int[] arr, int p, int r) {
        Map<String, Integer> result = new HashMap<>();
        int left = p + 1;
        int equal = left;
        int right = r;
        while (left <= right) {
            while (left <= right && arr[left] < arr[p]) {
                Utils.AboutArray.swapInArray(arr, left, equal);
                left++;
                equal++;
            }
            while (left <= right && arr[left] == arr[p]) {
                left++;
            }
            while (left <= right && arr[right] > arr[p]) {
                right--;
            }
            if (left < right) {
                Utils.AboutArray.swapInArray(arr, left, right);
            }
        }
        Utils.AboutArray.swapInArray(arr, p, --equal);
        result.put("q1", equal-1);
        result.put("q2", right+1);
        return result;
    }
}
