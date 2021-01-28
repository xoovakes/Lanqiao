package AlgorithmIsSoBeautiful._2_递归_排序;

/**
 * 希尔排序
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/28 下午 7:32
 */
public class _2_8_希尔排序 {
    public static void main(String[] args) {
        _2_8_希尔排序 c = new _2_8_希尔排序();
        int[] arr = new int[]{45, 65, 23, 46, 74, 27, 84, 68, 96};
        c.shellSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public void shellSort(int[] arr) {
        for (int interval = arr.length >> 1; interval > 0; interval>>=1) {
            for (int i = interval; i < arr.length; i++) {
                int x = arr[i];
                int j = i - interval;
                while (j>-1&&x<arr[j]){
                    arr[j+interval] = arr[j];
                    j -= interval;
                }
                arr[j+interval] = x;
            }
        }
    }
}
