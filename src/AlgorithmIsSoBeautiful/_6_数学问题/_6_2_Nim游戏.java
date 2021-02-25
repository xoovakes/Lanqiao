package AlgorithmIsSoBeautiful._6_数学问题;

/**
 * _6_2_Nim游戏
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/25 下午 8:41
 */
public class _6_2_Nim游戏 {
    public static void main(String[] args) {
        int[] A = {5,10,15};
        boolean res = solve(A);
        System.out.println(res);
    }

    private static boolean solve(int[] a) {
        int res = 0;
        for (int i : a) {
            res ^= i;
        }
        //res 不等于0 就赢了
        return res != 0;
    }
}
