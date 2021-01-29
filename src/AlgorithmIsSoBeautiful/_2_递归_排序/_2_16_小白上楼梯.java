package AlgorithmIsSoBeautiful._2_递归_排序;

/**
 * 小白上楼梯
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/29 下午 8:18
 */
public class _2_16_小白上楼梯 {
    public static void main(String[] args) {
        ComputingTime computingTime = new ComputingTime();
        _2_16_小白上楼梯 c = new _2_16_小白上楼梯();
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        computingTime.begin();
        for (int i : arr
        ) {
            System.out.print(c.f(arr[i]) + " ");
        }
        System.out.println();
        computingTime.end();
    }

    public int f(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return f(n - 1) + f(n - 2) + f(n - 3);
    }
}
