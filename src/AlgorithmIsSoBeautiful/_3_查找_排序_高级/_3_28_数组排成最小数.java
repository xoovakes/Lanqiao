package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import java.util.Arrays;
import java.util.Comparator;

/**
 * _3_28_数组排成最小数
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/14 下午 9:19
 */
public class _3_28_数组排成最小数 {
    public static void main(String[] args) {
        int res = new _3_28_数组排成最小数().f(new Integer[]{1,2,321});
        System.out.println(res);
    }
    private int f(Integer[] arr){
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1+""+o2;
                String s2 = o2+""+o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer integer : arr) {
            sb.append(integer);
        }
        return Integer.parseInt(sb.toString());
    }
}
