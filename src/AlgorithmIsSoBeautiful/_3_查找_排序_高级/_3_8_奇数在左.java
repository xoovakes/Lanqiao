package AlgorithmIsSoBeautiful._3_查找_排序_高级;

/**
 * 奇数在左
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/07 下午 10:14
 */
public class _3_8_奇数在左 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 3, 6, 5, 8, 7, 0, 9};
        Utils.AboutArray.printIntArray(arr);
        Utils.ComputingTime.beginCompute();
        new _3_8_奇数在左().sort(arr, 0, arr.length - 1);
        Utils.ComputingTime.endCompute();
        Utils.AboutArray.printIntArray(arr);
    }

    public void sort(int[] arr, int begin, int end) {
        int left = begin;
        int right = end;
        while (left <= right) {
            while (left <= right && Utils.Others.isOdd(arr[left])) {
                left++;
            }
            while (left <= right && !Utils.Others.isOdd(arr[right])) {
                right--;
            }
            if (left < right) {
                Utils.AboutArray.swapInArray(arr, left, right);
            }
        }
    }
}
