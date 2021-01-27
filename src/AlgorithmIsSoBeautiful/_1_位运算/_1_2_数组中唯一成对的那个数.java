package AlgorithmIsSoBeautiful._1_位运算;

/**
 * 数组中唯一成对的那个数
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/18 下午 11:40
 */
public class _1_2_数组中唯一成对的那个数 {
    public static void main(String[] args) {
        //建立一个符合题目要求的数组
        int N = 1001;
        int[] arr = new int[N];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i + 1;
        }
        _1_3_找出落单的数.Swaprandomindex(N, arr);
        System.out.println();

        //不用辅助数组去找那个数
        //关键公式：（1^2^3^...^K^...^K^...^999^1000）^（1^2^3^...^998^999^1000）=  K
        int x1 = 0;
        for (int i = 1; i <= N - 1; i++) {
            x1 ^= i;
        }
        for (int i = 0; i < N; i++) {
            x1 ^= arr[i];
        }
        System.out.println(x1);
        //用辅助数组去找那个数
        System.out.println("---");
        int[] helper = new int[N];
        for (int i = 0; i < N; i++) {
            helper[arr[i]]++;
        }
        for (int i = 0; i < N; i++) {
            if (helper[i] == 2) {
                System.out.println(i);
                break;
            }
        }
    }
}
