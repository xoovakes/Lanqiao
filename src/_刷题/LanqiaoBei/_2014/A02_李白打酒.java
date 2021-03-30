package _刷题.LanqiaoBei._2014;

/**
 * A02_李白打酒
 * dfs
 * 答案：12
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/30 下午 5:42
 */
public class A02_李白打酒 {
    private static int ans;
    public static void main(String[] args) {
        ans = 0;
        f(5,9,2);
        System.out.println(ans);
    }

    private static void f(int dian, int hua, int jiu) {
        if(jiu==1){
            ans++;
            return;
        }
        if(dian>0) f(dian-1,hua,jiu*2);
        if(hua>0) f(dian,hua-1,jiu-1);
    }
}
