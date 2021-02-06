package AlgorithmIsSoBeautiful._3_查找_排序_高级.test;

/**
 * test
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/06 下午 10:14
 */
public class _3_7_test {
    public static void main(String[] args) {
        int[] arr1 = new int[]{4,3,2,1};
        int[] arr2 = new int[10];
        Utils.AboutArray.printIntArray(arr2);
        Utils.AboutArray.copyIntArray(arr1,0,arr2,1,4);
        Utils.AboutArray.printIntArray(arr2);
    }
}
