package _刷题.LanqiaoBei._2014;

/**
 * B02_切面条
 * 找规律
 * 折0  1     2     3
 * 2+0,2+2^0,3+2^1,5+2^2
 * 答案：1025
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/30 下午 6:40
 */
public class B02_切面条 {
    public static void main(String[] args) {
        int n = 1;
        int ans = 2;
        while (n<=10){
            ans += Math.pow(2,n-1);
            n++;
        }
        System.out.println(ans);
    }
}
