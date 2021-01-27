package AlgorithmIsSoBeautiful._1_位运算;

import java.util.Random;

/**
 * 找出落单的数
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/21 下午 12:29
 */
public class _1_3_找出落单的数 {
    public static void main(String[] args) {
        int N = 11;
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            if ((i & 1) == 1) {
                arr[i] = arr[i - 1];
                continue;
            }
            arr[i] = i + 1;
        }
        Swaprandomindex(N, arr);
        //用异或运算去找
        int x2 = 0;
        for (int i = 0; i < arr.length; i++) {
            x2 ^= arr[i];
        }
        System.out.print("\n" + x2);
    }

    static void Swaprandomindex(int n, int[] arr) {
        arr[arr.length - 1] = new Random().nextInt(n - 1) + 1;
        int index = new Random().nextInt(n);
        arr[index] ^= arr[arr.length - 1];
        arr[arr.length - 1] ^= arr[index];
        arr[index] ^= arr[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
