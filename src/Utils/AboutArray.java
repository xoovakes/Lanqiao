package Utils;

import java.util.Arrays;

/**
 * 关于数组的操作
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
     *
     * @param arr 要打印的整型数组
     */
    public static void printIntArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换数组中的元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swapInArray(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 把arr1数组的元素移到arr2里
     *
     * @param arr1 旧的数组
     * @param arr2 新的数组
     */
    public static void copyIntArray(int[] arr1, int low1, int[] arr2, int low2, int length) {
        for (int i = 0; i < length; i++) {
            arr2[low2+i] = arr1[low1+i];
        }
    }
}
