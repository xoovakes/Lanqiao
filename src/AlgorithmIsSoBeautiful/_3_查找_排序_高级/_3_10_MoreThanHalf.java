package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import org.assertj.core.api.Assertions;

import java.util.Arrays;

/**
 * 数组中出现超过半数的元素，这里只写了解法1和解法3，解法4在水王那里
 * 解法1：排序后返回arr[N/2],O(nlgn)
 * 解法2：hash统计
 * 解法3：顺序统计,限制：需要改动数组
 * 解法4：不同的数，进行消除
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/08 下午 4:16
 */
public class _3_10_MoreThanHalf {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 5, 5, 5, 5, 2, 9, 7, 2};
        Utils.AboutArray.printIntArray(arr);
        int k = new _3_10_MoreThanHalf().solve1(arr);
        Assertions.assertThat(k).isEqualTo(5);
        k = new _3_10_MoreThanHalf().solve3(arr);
        Assertions.assertThat(k).isEqualTo(5);
    }

    public int solve1(int[] arr) {
        Arrays.sort(arr);
//        Utils.AboutArray.printIntArray(arr);
        return arr[arr.length / 2];
    }

    public int solve3(int[] arr) {
        return new _3_9_第k小的数().selectK(arr, 0, arr.length - 1, arr.length >> 1);
    }
}
