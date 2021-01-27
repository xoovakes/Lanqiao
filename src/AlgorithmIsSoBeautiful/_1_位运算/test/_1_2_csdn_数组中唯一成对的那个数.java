package AlgorithmIsSoBeautiful._1_位运算.test;

import java.util.Random;

/**
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/21 下午 12:14
 */
public class _1_2_csdn_数组中唯一成对的那个数 {
    public static void main(String[] args) {
        int N = 11;
        //生成一个含有从1~1000的数组
        int[] arr = new int[N];
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = i+1;
        }
        //将最后一个数设置为随机数
        arr[arr.length-1] = new Random().nextInt(N-1)+1;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        //进行连续的异或运算
        int x1 = 0;
        for (int i = 1; i < N; i++) {
            x1 ^= i;
        }
        //输出连续位运算的结果
        System.out.print(x1+" ");
        System.out.println();
        for (int i = 0; i < N; i++) {
            x1 = x1^arr[i];
            System.out.print(x1+" ");
        }
        //输出重复的数
        System.out.println();
        System.out.println(x1);
    }
}
