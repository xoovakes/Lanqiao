package _刷题.LanqiaoBei._2014;

/**
 * B04_大衍数列
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/30 下午 7:05
 */
public class B04_大衍数列 {
    public static void main(String[] args) {
        for(int i=1; i<100; i++)
        {
            if(i%2==0)  //填空
                System.out.println(i*i/2);
            else
                System.out.println((i*i-1)/2);
        }
    }
}
