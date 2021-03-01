package AlgorithmIsSoBeautiful._6_数学问题;

/**
 * _6_13_埃氏筛法
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/01 下午 9:44
 */
public class _6_13_埃氏筛法 {
    public static void main(String[] args) {
        // TODO: 21/03/01 数据跟老师的不一样
        m1(100000);
        System.out.println(Integer.MAX_VALUE);
    }

    /**
     * 求第N个素数
     * ---
     * 已知在整数X内大概有X/log(X)个素数
     * 现在我们要逆推：要想求第N个素数，我们的整数范围是什么
     * n是整数范围
     *
     * @param N 第N个素数
     */
    private static void m1(int N) {
        int n = 2;
        while (n / Math.log(n) < N) {
            n++;
        }
        //筛选法
        int[] arr = new int[n];
        int x = 2;
        while (x < n) {
            //标记过了就下一个
            if (arr[x++] != 0) {
                continue;
            }
            int k = 2;
            //对每个x,我们从2倍开始，对x的k倍，全部标记为-1
            while (x * k < n) {
                arr[x * k++] = -1;
            }
            x++;
        }
        //筛完之后，这个很长的数组里面非素数下标对应的值为-1
        int sum = 0;
        for (int i = 2; i < arr.length; i++) {
            //是素数，计数+1
            if (arr[i] == 0) {
                sum++;
            }
            if (sum == N) {
                System.out.println(i);
                return;
            }
        }
    }
}
