package Utils;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/31 下午 9:31
 */
public class AboutArray {
    /**
     * 生成整型的随机数组
     *
     * @param len 数组长度
     * @param min 最小值
     * @param max 最大值
     * @return 返回生成好的数组
     */
    public static int[] intRandomArray(int len, int min, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max + min);
        }
        return arr;
    }
    /**
     * 打印整型数组
     * @param arr 要打印的整型数组
     */
    public static void printIntArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     *  交换数组中的元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swapInArray(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
