package AlgorithmIsSoBeautiful._3_查找_排序_高级.test;

/**
 * test
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/31 上午 11:48
 */
public class _3_3_test {
    public static void main(String[] args) {
        a();
    }
    private static void a(){
        int a = 34634;
        int b = 12313;
        a^=b;
        b^=a;
        a^=b;
        System.out.println(a+" "+b);
    }
}
