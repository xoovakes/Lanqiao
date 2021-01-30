package AlgorithmIsSoBeautiful._2_查找_排序;

/**
 * 高效求a的n次幂
 * TODO 没考虑负数幂的情况
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/30 下午 4:17
 */
public class _2_20_高效求a的n次幂 {
    public static void main(String[] args) {
        ComputingTime computingTime = new ComputingTime();
        _2_20_高效求a的n次幂 c = new _2_20_高效求a的n次幂();
        computingTime.begin();
        System.out.println(c.pow0(2,16));
        computingTime.end();
        System.out.println();
        computingTime.begin();
        System.out.println(c.pow(2,16));
        computingTime.end();
    }

    public int pow0(int a,int n){
        int result= 1;
        for (int i = 0; i < n; i++) {
            result*=a;
        }
        return result;
    }

    public int pow(int a,int n){

    }
}
