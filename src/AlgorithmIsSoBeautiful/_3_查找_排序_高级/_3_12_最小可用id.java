package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import org.assertj.core.api.Assertions;

import java.util.Arrays;

/**
 * _3_12_最小可用id
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/08 下午 5:59
 */
public class _3_12_最小可用id {
    public static void main(String[] args) {
        //随机生成不重复数组测试
        int[] arr1 = Utils.AboutArray.getRandomArrWithoutRepetition(10, 1, 10);
        System.out.println("随机生成不重复数组测试:");
        Utils.AboutArray.printIntArray(arr1);
        System.out.println("-------------------");
        //
        int[] arr = new int[]{1, 2, 3, 4, 6, 7, 8, 9};
        Utils.AboutArray.printIntArray(arr);
        int k = new _3_12_最小可用id().find1(arr);
        Assertions.assertThat(k).isEqualTo(5);
        k = new _3_12_最小可用id().find2(arr);
        Assertions.assertThat(k).isEqualTo(5);
        k = new _3_12_最小可用id().find3(arr);
        Assertions.assertThat(k).isEqualTo(5);
        k = new _3_12_最小可用id().find4(arr, 0, arr.length - 1);
        Assertions.assertThat(k).isEqualTo(5);
    }

    /**
     * 暴力解法,O(N^2)
     */
    public int find1(int[] arr) {
        int i = 1;
        while (true) {
            if (!Utils.AboutArray.indexOf(arr, i)) {
                return i;
            }
            i++;
        }
    }

    /**
     * 先排序,O(NlogN)
     */
    public int find2(int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length) {
            if (i + 1 != arr[i]) {
                break;
            }
            i++;
        }
        return i + 1;
    }

    /**
     * 改进1：
     * 利用辅助数组，辅助数组的下标是有意义的
     * 注：有点类似于计数排序O(n)但是浪费空间
     */
    public int find3(int[] arr) {
        int n = arr.length;
        int[] helper = new int[n + 1];
        for (int j : arr) {
            if (j <= n) {
                helper[j] = 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (helper[i] == 0) {
                return i;
            }
        }
        return n + 1;
    }

    /**
     * 改进2, 分区，递归
     * 问题可转化为：n个正数的数组A，如果存在小于n的数不在数组中，
     * 必然存在大于n的数在数组中，否则 数组排列恰好为1到n
     */
    public int find4(int[] arr, int l, int r) {
        if (l > r) {
            return l + 1;
        }
        //中间下标
        int midIndex = l + ((r - l) >> 1);
        //实际排序后中间位置的值
        int q = new _3_9_第k小的数().selectK(arr, l, r, midIndex - l + 1);
        //期望值
        int t = midIndex + 1;
        if (q == t) {
            //左侧紧密
            return find4(arr, midIndex + 1, r);
        } else {
            //左侧稀疏
            return find4(arr, l, midIndex - 1);
        }
    }
}
