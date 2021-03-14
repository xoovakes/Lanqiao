package AlgorithmIsSoBeautiful._2_查找_排序_初级;

/**
 * 二分查找
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/28 下午 7:10
 */
public class _2_7_二分查找 {
    public static void main(String[] args) {
        //统计时间初始化
        ComputingTime computingTime = new ComputingTime();
        //排序
        _2_5_递归形式进行插入排序 d = new _2_5_递归形式进行插入排序();
        int[] arr = new int[]{45, 65, 23, 46, 74, 27, 84, 68, 96};
        int len = arr.length - 1;
        computingTime.begin();
        d.insertSort(arr, len);
        computingTime.end();
        //查找
        _2_7_二分查找 c = new _2_7_二分查找();
        int e = c.binarySearch1(arr, 0, len, 22);
        if (e != -1) {
            System.out.println("找到了");
        } else {
            System.out.println("没找到");
        }
    }

    public int binarySearch1(int[] arr, int low, int high, int key) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((low + high) >> 1);
        int midVal = arr[mid];
        if (midVal < key) {
            return binarySearch1(arr, mid + 1, high, key);
        } else if (midVal > key) {
            return binarySearch1(arr, low, mid - 1, key);
        } else {
            return mid;
        }
    }
}
