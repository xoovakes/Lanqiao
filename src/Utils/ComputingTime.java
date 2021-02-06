package Utils;

/**
 * 看看程序运算时间
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/31 下午 9:32
 */
public class ComputingTime {
    static long beginTime;
    static long endTime;

    /**
     * 算法开始计时
     *
     * @return
     */
    public static long beginCompute() {
        beginTime = System.currentTimeMillis();
        System.out.println("---- 开始计时 ----");
        return beginTime;
    }

    /**
     * 算法结束计时
     *
     * @return
     */
    public static long endCompute() {
        endTime = System.currentTimeMillis() - beginTime;
        System.out.println("-- 运算所用时间"+endTime + "ms"+" --");
        return endTime;
    }
}
