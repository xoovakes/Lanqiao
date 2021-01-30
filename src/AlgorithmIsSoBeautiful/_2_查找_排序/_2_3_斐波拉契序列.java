package AlgorithmIsSoBeautiful._2_查找_排序;

/**
 * 斐波拉契序列
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/26 下午 6:04
 */
public class _2_3_斐波拉契序列 {
    public static void main(String[] args) {
        _2_3_斐波拉契序列 c = new _2_3_斐波拉契序列();
        System.out.println(c.fib(5));
    }

    public int fib(int n){
        if (n==1||n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
}
