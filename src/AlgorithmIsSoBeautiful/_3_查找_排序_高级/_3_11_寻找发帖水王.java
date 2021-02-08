package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import org.assertj.core.api.Assertions;

/**
 * 水王
 * 解法1：排序后返回arr[N/2],O(nlgn)
 * 解法2：hash统计
 * 解法3：顺序统计,限制：需要改动数组
 * 解法4：不同的数，进行消除
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/08 下午 4:16
 */
public class _3_11_寻找发帖水王 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 5, 5, 5, 5, 2, 9, 7, 2};
        int[] arr2 = new int[]{5, 5, 5, 5, 5, 2, 9, 7, 2, 0};
        Utils.AboutArray.printIntArray(arr1);
        int k = new _3_11_寻找发帖水王().solve4(arr1);
        Assertions.assertThat(k).isEqualTo(5);
        Utils.AboutArray.printIntArray(arr2);
        k = new _3_11_寻找发帖水王().solve5(arr2);
        Assertions.assertThat(k).isEqualTo(5);
    }

    /**
     * 不同的数进行消除，O(N)
     *
     * @param arr 待排序数组
     * @return 返回水王
     */
    public int solve4(int[] arr) {
        //候选数，先定位第一个元素
        int candidate = arr[0];
        //出现的次数
        int nTimes = 1;
        //扫描数组，第一个被定位了不用扫了
        for (int i = 1; i < arr.length; i++) {
            //两两消除为0，把现在的元素作为候选值
            if (nTimes == 0) {
                candidate = arr[i];
                nTimes = 1;
                continue;
            }
            //遇到和候选值相同的，次数加1
            if (arr[i] == candidate) {
                nTimes++;
            } else {
                //不同的数，进行消减
                nTimes--;
            }
        }
        return candidate;
    }

    /**
     * 变式，加强版水王，出现次数恰好为个数的一半，求出这个数
     * --
     * 网上大佬，我还是可以扫描一遍数组来解决问题
     * 水王战总数一半，总数必为偶数
     * 不失一般性，假设隔一个数就是水王，两两不同最后一定会消减为0
     * 水王可能是最后一个元素，如果不是那么取代最后一个元素，水王就是留下的那个candidate
     */
    public int solve5(int[] arr) {
        int candidate = arr[0];
        int nTimes = 0;
        //统计最后这个元素出现的次数
        int count0fLast = 0;
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            if (arr[i] == arr[N - 1]) {
                count0fLast++;
            }
            if (nTimes == 0) {
                candidate = arr[i];
                nTimes = 1;
                continue;
            }
            if (arr[i] == candidate) {
                nTimes++;
            } else {
                nTimes--;
            }
        }
        if (count0fLast == N >> 1) {
            return arr[N - 1];
        } else {
            return candidate;
        }
    }
}
