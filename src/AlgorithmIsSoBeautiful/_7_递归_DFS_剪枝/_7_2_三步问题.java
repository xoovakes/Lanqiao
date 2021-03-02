package AlgorithmIsSoBeautiful._7_递归_DFS_剪枝;

/**
 * _7_2_三步问题
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/02 下午 5:36
 */
public class _7_2_三步问题 {
    private static int mod = 1000000007;

    public static void main(String[] args) {
        System.out.println(wapToStep(1));
        System.out.println(wapToStep(5));
        System.out.println();
        System.out.println(wapToStep_1(1));
        System.out.println(wapToStep_1(5));
        System.out.println();
        System.out.println(wapToStep2(1));
        System.out.println(wapToStep2(5));
    }

    private static int wapToStep2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int x1 = 1, x2 = 2, x3 = 4;
        for (int i = 4; i <= n; i++) {
            int x_1 = x1;
            x1 = x2 % mod;
            x2 = x3 % mod;
            x3 = ((x1 + x2) % mod + x_1) % mod;
        }
        return x3;
    }

    private static int wapToStep_1(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        } else {
            return wapToStep_1(n - 1) + wapToStep_1(n - 2) + wapToStep_1(n - 3);
        }
    }

    private static int wapToStep(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0 || n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return wapToStep(n - 1) % mod + wapToStep(n - 2) % mod + wapToStep(n - 3) % mod;
        }
    }
}
