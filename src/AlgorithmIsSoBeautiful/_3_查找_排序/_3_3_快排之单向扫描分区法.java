package AlgorithmIsSoBeautiful._3_查找_排序;

import AlgorithmIsSoBeautiful._2_查找_排序.ComputingTime;
import Utils.myUtils;

/**
 * 快排之单向扫描分区法
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/30 下午 10:43
 */
public class _3_3_快排之单向扫描分区法 {
    public static void main(String[] args) {
        myUtils u = new myUtils();
        _3_3_快排之单向扫描分区法 c = new _3_3_快排之单向扫描分区法();
        //
        int[] arr = u.intRandomArray(16,1,10);
        u.printIntArray(arr);
        u.beginCompute();
        //
        u.endCompute();
    }
    public void quickSort(int[] arr,int p,int r){
        return;
    }
    public int partition(int[] arr,int p,int r){
        return 1;
    }
}
