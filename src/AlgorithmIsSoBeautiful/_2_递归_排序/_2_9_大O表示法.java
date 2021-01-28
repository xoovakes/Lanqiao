package AlgorithmIsSoBeautiful._2_递归_排序;

/**
 * 大O表示法
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/28 下午 11:33
 */
public class _2_9_大O表示法 {
    public static void main(String[] args) {
        int n = 100;
        int k = 0;

        //nt,即 O(n),线性复杂度
        for (int i = 1; i <= n; i++) {
            //t
            k = k + 5;
        }//n

        k=0;
        //nxnxt,即 O(nxn),平方复杂度
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //t
                k = k + i + j;
            }//n
        }//n

        k=0;
        //1+2+3+4+...+n,求和公式得,即 O(nxn),平方复杂度
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //t
                k = k + i + j;
            }//i
        }//n

        int count = 1;
        //对数复杂度
        while (count < n){
            count *= 2;
        }

        //O(1), 常数阶, 例子：高斯算数
    }
}
