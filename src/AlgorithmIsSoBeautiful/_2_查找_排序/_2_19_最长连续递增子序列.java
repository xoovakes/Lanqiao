package AlgorithmIsSoBeautiful._2_查找_排序;

import java.util.Arrays;

/**
 * 最长连续递增子序列
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/29 下午 11:46
 */
public class _2_19_最长连续递增子序列 {
    public static void main(String[] args) {
        ComputingTime computingTime = new ComputingTime();
        _2_19_最长连续递增子序列 c = new _2_19_最长连续递增子序列();
        int[] arr = new int[]{1, 9, 2, 5, 7, 3, 4, 6, 8, 0};
        computingTime.begin();
        System.out.println(Arrays.toString(c.longSequ(arr)));
        computingTime.end();
    }

    public int[] longSequ(int[] arr) {
        int[] m = new int[arr.length];
        //j放在i的后一位，max是最长长度，肯定有1位
        int max = 1;
        int i = 0;
        //最长长度先找出来，位置再在m[]里面找
        while (i + 1 < arr.length) {
            int j = i + 1;
            while (arr[j - 1] < arr[j]) {
                m[j] = 0;
                j++;
            }
            int count = j - i;
            max = Math.max(count, max);
            m[i] = count;
            i = j;
        }
        for (int j = 0; j < m.length; j++) {
            if(m[j]==max){
                i = j;
            }
        }
        //System.out.println(i+" "+max);
        return java.util.Arrays.copyOfRange(arr,i,i+max);
    }
}
