package AlgorithmIsSoBeautiful._2_查找_排序_初级;

/**
 * 最大公约数
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/26 下午 6:24
 */
public class _2_4_最大公约数 {
    public static void main(String[] args) {
        _2_4_最大公约数 c = new _2_4_最大公约数();
        System.out.println(c.gcd(100,2));
    }

    public int gcd(int m,int n){
        if(n==0) {
            return m;
        }
        return gcd(n,m%n);
    }
}
