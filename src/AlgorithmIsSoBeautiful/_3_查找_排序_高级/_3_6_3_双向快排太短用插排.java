package AlgorithmIsSoBeautiful._3_查找_排序_高级;

/**
 * 双向快排太短用插排
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/05 下午 3:59
 */
public class _3_6_3_双向快排太短用插排 {
    public static void main(String[] args) {
        int[] arr = Utils.AboutArray.intRandomArray(12, 1, 10);
        Utils.AboutArray.printIntArray(arr);
        Utils.ComputingTime.beginCompute();
        new _3_6_3_双向快排太短用插排().quickSort(arr, 0, arr.length - 1);
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

    public int partition(int[] arr, int p, int r) {
        //优化，在p,r,mid之间，选一个中间值作为主元
        int middleIndex = p + ((r-p)>>1);
        int middleValueIndex = -1;
        if(arr[p]<=Math.max(arr[middleIndex],arr[r])&&arr[p]>=Math.min(arr[middleIndex],arr[r])){
            middleValueIndex = p;
        }else if(arr[r]<=Math.max(arr[middleIndex],arr[p])&&arr[r]>=Math.min(arr[middleIndex],arr[p])){
            middleValueIndex = r;
        }else {
            middleValueIndex = middleIndex;
        }
        Utils.AboutArray.swapInArray(arr,p,middleValueIndex);
        //end：三点中值法优化
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
