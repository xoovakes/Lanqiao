package AlgorithmIsSoBeautiful._2_递归_排序;

/**
 * 方便查看算法的运算时间
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/29 上午 11:59
 */
public class ComputingTime {

    private long beginTime;
    private long endTime;

    public long begin(){
        beginTime = System.currentTimeMillis();
        return beginTime;
    }

    public long end(){
        endTime = System.currentTimeMillis() - beginTime;
        System.out.print(endTime + "ms");
        return endTime;

    }
}
