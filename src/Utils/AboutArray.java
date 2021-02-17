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
     * 随机生成不重复数组
     *
     * @param len 数组长度
     * @param min 最小数字
     * @param max 最大数字
     */
    public static int[] getRandomArrWithoutRepetition(int len, int min, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (max - min + 1) + min);
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * 判断一个元素在不在数组中
     *
     * @param arr 被找的数组
     * @param a   那个元素
     * @return 返回真假
     */
    public static boolean indexOf(int[] arr, int a) {
        boolean inArr = false;
        for (int k : arr) {
            if (a == k) {
                inArr = true;
                break;
            }
        }
        return inArr;
    }

    /**
     * 找出数组中的最大值
     *
     * @param arr 数组
     * @return 最大值
     */
    public static int maxOf(int[] arr) {
        int max = arr[0];
        for (int item : arr) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    /**
     * 找出数组中的最小值
     *
     * @param arr 数组
     * @return 最小值
     */
    public static int minOf(int[] arr) {
        int min = arr[0];
        for (int item : arr) {
            if (item < min) {
                min = item;
            }
        }
        return min;
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
     * printTwoDimensionalArray
     * 打印二维整数数组
     *
     * @param matrix 要打印的二维整数数组
     */
    public static void printTwoDimensionalArray(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void printTwoDimensionalArray(long[][] matrix) {
        for (long[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 交换数组中的元素
     *
     * @param arr 数组
     * @param a   交换的元素1
     * @param b   交换的元素2
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
            arr2[low2 + i] = arr1[low1 + i];
        }
    }
}
