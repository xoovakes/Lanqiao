package Utils;

import java.util.Arrays;

/**
 * 工具类
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/30 下午 10:49
 */
public class myUtils {
    /**
     * 生成整型的随机数组
     *
     * @param len 数组长度
     * @param min 最小值
     * @param max 最大值
     * @return 返回生成好的数组
     */
    public int[] intRandomArray(int len, int min, int max) {
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
    public void printIntArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    long beginTime;
    long endTime;

    /**
     * 算法开始计时
     *
     * @return
     */
    public long beginCompute() {
        beginTime = System.currentTimeMillis();
        return beginTime;
    }

    /**
     * 算法结束计时
     *
     * @return
     */
    public long endCompute() {
        endTime = System.currentTimeMillis() - beginTime;
        System.out.print(endTime + "ms");
        return endTime;
    }
}