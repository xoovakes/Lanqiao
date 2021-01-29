package AlgorithmIsSoBeautiful._2_递归_排序;

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
        System.out.println(c.longSequ(arr));
        computingTime.end();
    }

    public int longSequ(int[] arr) {
        int i = 0;
        int j = 0;
        int count = 0;

        return 1;
    }
}
