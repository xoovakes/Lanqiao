package AlgorithmIsSoBeautiful._3_查找_排序_高级;

/**
 * 归并排序的学习
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/06 下午 7:25
 */
public class _3_7_归并排序 {
    public static void main(String[] args) {
        int[] arr = Utils.AboutArray.intRandomArray(8, 1, 10);
        Utils.AboutArray.printIntArray(arr);
        Utils.ComputingTime.beginCompute();
        new _3_7_归并排序().mergeSort(arr, 0, arr.length - 1);
        Utils.ComputingTime.endCompute();
        Utils.AboutArray.printIntArray(arr);
    }

    public void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + ((high - low) >> 1);
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high) {
        //先把A中的数据拷贝到helper中
        int[] helper = new int[arr.length];
        Utils.AboutArray.copyIntArray(arr, low, helper, low, high - low + 1);
        //辅助数组指针，指向待比较元素
        int left = low, right = mid + 1;
        //原数组的指针，指向待填入数据的位置
        int current = low;
        //开始排序
        while (left <= mid && right <= high) {
            if (helper[left] <= helper[right]) {
                arr[current++] = helper[left++];
            } else {
                arr[current++] = helper[right++];
            }
        }
        while (left <= mid) {
            arr[current++] = helper[left++];
        }
    }
}
