package AlgorithmIsSoBeautiful._3_查找_排序_高级;

/**
 * _3_16to18_堆和堆排序
 * sort by minHeap and maxHeap
 * 建堆to排序,O(nlgn)
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/09 下午 11:40
 */
public class _3_16to18_堆和堆排序 {
    public static void main(String[] args) {
        _3_16to18_堆和堆排序 c = new _3_16to18_堆和堆排序();
        int[] arr1 = Utils.AboutArray.intRandomArray(16, 0, 20);
        int[] arr = {3, 2, 1};
        Utils.AboutArray.printIntArray(arr);
        System.out.println("------------");
        c.sortByMinHeap(arr);
        System.out.print("用最小堆的堆排序是倒序的：");
        Utils.AboutArray.printIntArray(arr);
        c.sortByMaxHeap(arr);
        System.out.print("用最大堆的堆排序是正序的：");
        Utils.AboutArray.printIntArray(arr);
    }

    public void minHeap(int[] arr) {
        // 太牛了，arr.length/2-1看起来好像是错的，其实就是(arr.length-1-1)/2
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapFixDown(arr, i, n);
        }
    }

    public void minHeapFixDown(int[] arr, int i, int n) {
        // 找到左右孩子
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        //a.先让min指向孩子中较小的那个。如果右孩子越界，最小直接是左孩子
        int min = left;
        if (left >= n) {
            //左孩子越界，i是子节点
            return;
        }
        if (right < n) {
            if (arr[right] < arr[left]) {
                min = right;
            }
        }
        //b.再让arr[min]和arr[i]来比，让小的在上面
        if (arr[i] <= arr[min]) {
            return;
        }
        Utils.AboutArray.swapInArray(arr, i, min);
        minHeapFixDown(arr, min, n);
    }

    public void sortByMinHeap(int[] arr) {
        minHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            Utils.AboutArray.swapInArray(arr, 0, i);
            minHeapFixDown(arr, 0, i);
        }
    }

    public void maxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapFixDown(arr, i, n);
        }
    }

    public void maxHeapFixDown(int[] arr, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = left;
        if (left >= n) {
            return;
        }
        if (right < n) {
            if (arr[right] > arr[left]) {
                max = right;
            }
        }
        if (arr[i] >= arr[max]) {
            return;
        }
        Utils.AboutArray.swapInArray(arr, i, max);
        maxHeapFixDown(arr, max, n);
    }

    public void sortByMaxHeap(int[] arr) {
        maxHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            Utils.AboutArray.swapInArray(arr, 0, i);
            maxHeapFixDown(arr, 0, i);
        }
    }
}
