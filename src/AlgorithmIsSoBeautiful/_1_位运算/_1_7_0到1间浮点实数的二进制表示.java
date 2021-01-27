package AlgorithmIsSoBeautiful._1_位运算;

/**
 * 0到1间浮点实数的二进制表示
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/21 下午 6:08
 */
public class _1_7_0到1间浮点实数的二进制表示 {
    public static void main(String[] args) {
        double num = 0.625;
        StringBuilder sb = new StringBuilder("0.");
        while (num>0){
            double r = num*2;
            if(r>=1){
                sb.append("1");
                num=r-1;
            }else {
                sb.append("0");
                num=r;
            }
            if(sb.length()>34){
                System.out.println("ERROR");
                return;
            }
        }
        System.out.println(sb.toString());
    }
}
