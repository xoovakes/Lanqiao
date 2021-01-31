package AlgorithmIsSoBeautiful._2_查找_排序_初级;

/**
 * 旋转数组的最小数字_改造二分法
 * 没有考虑有相同元素，如果遇到很多相同头尾相同的情况应该放弃这个算法
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/29 下午 8:26
 */
public class _2_17_旋转数组的最小数字_改造二分法 {
    public static void main(String[] args) {
        ComputingTime computingTime = new ComputingTime();
        _2_17_旋转数组的最小数字_改造二分法 c = new _2_17_旋转数组的最小数字_改造二分法();
//        int[] arr = new int[]{1, 1, 1, 1, 0, 1, 1};
        int[] arr = new int[]{4, 5, 1, 2, 3};
        computingTime.begin();
        System.out.println(c.min(arr));
        computingTime.end();
    }

    public int min(int[] arr) {
        int begin = 0;
        int end = arr.length - 1;
        //特殊情况，数组没有旋转
        if (arr[begin] < arr[end]) {
            return arr[begin];
        }
        //
        while (begin + 1 < end) {
            int mid = begin + ((begin + end) >> 1);
            if (arr[mid] >= arr[begin]) {
                begin = mid;
            } else if (arr[mid] <= arr[end]) {
                end = mid;
            }
        }
        return arr[end];
    }
}
