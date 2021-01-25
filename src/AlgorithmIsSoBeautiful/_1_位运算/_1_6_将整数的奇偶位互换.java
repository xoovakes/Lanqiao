package AlgorithmIsSoBeautiful._1_位运算;

/**
 * TODO
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/21 下午 5:30
 */
public class _1_6_将整数的奇偶位互换 {
    public static void main(String[] args) {
        int a = 6;
        int b = m(a);
        System.out.println(a);
        System.out.println(Integer.toString(a,2));
        System.out.println(b);
        System.out.println(Integer.toString(b,2));
    }

    private static int m(int i){
        int ou = i&0xaaaaaaaa;
        int ji = i&0x55555555;
        return (ou>>1)^(ji<<1);
    }
}
