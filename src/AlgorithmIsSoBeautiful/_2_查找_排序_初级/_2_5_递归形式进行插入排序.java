package AlgorithmIsSoBeautiful._2_查找_排序_初级;

/**
 * 递归形式进行插入排序
 * 1.对前k-1个元素排序
 * 2.把位置k的元素插入到前面的部分
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/27 下午 10:16
 */
public class _2_5_递归形式进行插入排序 {
    public static void main(String[] args) {
        _2_5_递归形式进行插入排序 c = new _2_5_递归形式进行插入排序();
        int[] arr = new int[]{45, 65, 23, 46, 74, 27, 84, 68, 96};
        int len = arr.length - 1;
        c.insertSort(arr, len);
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public void insertSort(int[] arr, int k) {
        if (k == 0) {
            return;
        }
        insertSort(arr, k - 1);
        int saved = arr[k];
        int index = k - 1;
        while (index > -1 && saved < arr[index]) {
            arr[index + 1] = arr[index];
            index--;
        }
        arr[index + 1] = saved;
    }
}
