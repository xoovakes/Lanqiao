package AlgorithmIsSoBeautiful._6_数学问题;

/**
 * _6_7_拓展欧几里得
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/28 上午 1:31
 */
public class _6_7_拓展欧几里得 {
    public static long x;
    public static long y;

    public static void main(String[] args) {
    }

    /**
     * 拓展欧几里得
     * 调用完成后xy是ax+by=gcd(a,b)的解
     * ---
     * 加, 裴蜀(贝祖)等式
     * 证明，
     * a*x + b*y = gcd
     * 因为，a%b = a-(a/b)*b
     * a*y1 + b*(x1-a/b*y1) = gcd
     * 可得：
     * 递推关系(x,y是上一层，x1,y1是下一个状态)
     * x = y1
     * y = x1 - a/b*y1
     * 通解
     * x = x0 + (b/gcd) * t
     * y = y0 - (a/gcd) * t
     * x大于0的第一个解
     * b /= d; x = (x0 % b + b) % b
     */
    public static long ext_gcd(long a, long b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        long res = ext_gcd(b, a % b);
        //递推,反着递归
        long temp = x;
        x = y;
        y = temp - a / b * y;
        return res;
    }

    /**
     * 线性方程
     * ax+by=m, 当m=gcd(a,b)倍数时有解
     * 等价于ax=m mod b
     */
    public static long linearEquation(long a, long b, long m) throws Exception {
        long d = ext_gcd(a, b);
        //m不是gcd(a,b)的倍数,这个方程无解
        if (m % d != 0) {
            throw new Exception("无解");
        }
        long n = m / d;
        x *= n;
        y *= n;
        return d;
    }

    /* 最小公倍数(lowest common multiple) */
    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static long gcd(long m, long n) {
        System.out.println(m + " " + n);//test
        return n == 0 ? m : gcd(n, m % n);
    }
}
