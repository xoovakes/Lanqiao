package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import AlgorithmIsSoBeautiful._2_查找_排序_初级.InsertionSort;

/**
 * 绝对中值法优化过的双向快排
 * 绝对中值法有点复杂，工程里面多用三点中值法和插排来排太短的数组
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/05 下午 3:48
 */
public class _3_6_2_绝对中值法双向快排 {
    public static void main(String[] args) {
        int[] arr = Utils.AboutArray.intRandomArray(12, 1, 10);
        Utils.AboutArray.printIntArray(arr);
        Utils.ComputingTime.beginCompute();
        new _3_6_2_绝对中值法双向快排().quickSort(arr, 0, arr.length - 1);
        Utils.ComputingTime.endCompute();
        Utils.AboutArray.printIntArray(arr);
    }

    public void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    /**
     * 求数组的绝对中值
     *
     * @param arr 所求数组
     * @param p
     * @param r
     * @return 返回绝对中值
     */
    public int getMediam(int[] arr, int p, int r) {
        //数组长度
        int size = r - p + 1;
        //每五个元素一组
        int groupSize = (size % 5 == 0) ? (size / 5) : (size / 5 + 1);
        //存储各小组的中值
        int medians[] = new int[groupSize];
        int indexOfMedians = 0;
        //对每一组进行插入排序
        for (int i = 0; i <groupSize; i++) {
            //单独处理最后一组，因为最后一组可能不满5个元素
            if (i==groupSize-1){
                //排序最后一组
                InsertionSort.sort(arr,p+i*5,r);
                //最后一组的中间那个
                medians[indexOfMedians++] = arr[(p+i*5+r)/2];
            }else {
                //排序非最后一组的某个组
                InsertionSort.sort(arr,p+i*5,p+i*5+4);
                //当前组(排序后)的中间那个
                medians[indexOfMedians++] = arr[p+i*5+2];
            }
        }
        //对medians排序
        InsertionSort.sort(medians,0,medians.length-1);
        return medians[medians.length/2];
    }

    public int partition(int[] arr, int p, int r) {
        int middleValueIndex = getMediam(arr,p,r);
        Utils.AboutArray.swapInArray(arr, p, middleValueIndex);
        int left = p + 1;
        int right = r;
        while (left <= right) {
            while (left <= right && arr[left] <= arr[p]) {
                left++;
            }
            while (left <= right && arr[right] > arr[p]) {
                right--;
            }
            if (left < right) {
                Utils.AboutArray.swapInArray(arr, left, right);
            }
        }
        Utils.AboutArray.swapInArray(arr, p, right);
        return right;
    }
}
