package AlgorithmIsSoBeautiful._2_查找_排序_初级;

/**
 * 高效求a的n次幂
 * 没考虑负数幂的情况
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/30 下午 4:17
 */
public class _2_20_高效求a的n次幂 {
    public static void main(String[] args) {
        ComputingTime computingTime = new ComputingTime();
        _2_20_高效求a的n次幂 c = new _2_20_高效求a的n次幂();
        int n = 15;
        computingTime.begin();
        System.out.println(c.pow0(2, n));
        computingTime.end();
        System.out.println();
        computingTime.begin();
        System.out.println(c.pow(2, n));
        computingTime.end();
    }

    public int pow0(int a, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= a;
        }
        return result;
    }

    public int pow(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int result = a;
        int ex = 1;
        while ((ex << 1) <= n) {
            result = result * result;
            ex <<= 1;
        }
        return result * pow(a, n - ex);
    }
}
