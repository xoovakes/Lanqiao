package AlgorithmIsSoBeautiful._5_字符串;

/**
 * _5_7_旋转词
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/18 下午 10:14
 */
public class _5_7_旋转词 {
    public static void main(String[] args) {
        System.out.println(new _5_7_旋转词().isRotate("abc","cab"));
    }
    public boolean isRotate(String a,String b){
        StringBuilder sb = new StringBuilder(b).append(b);
        return sb.toString().contains(a);
    }
}
