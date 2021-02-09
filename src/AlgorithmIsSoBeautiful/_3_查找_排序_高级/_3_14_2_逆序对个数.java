package AlgorithmIsSoBeautiful._3_查找_排序_高级;

/**
 * _3_14_2_逆序对个数
 * 也是参考归并排序,还不用改很多
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/09 下午 11:12
 */
public class _3_14_2_逆序对个数 {
    int niXu = 0;

    public static void main(String[] args) {
        int[] arr = Utils.AboutArray.getRandomArrWithoutRepetition(4, 1, 10);
        Utils.AboutArray.printIntArray(arr);
        _3_14_2_逆序对个数 n = new _3_14_2_逆序对个数();
        n.howMuchNiXu(arr, 0, arr.length - 1);
        System.out.println("niXu = " + n.niXu);
    }

    public void howMuchNiXu(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + ((high - low) >> 1);
            howMuchNiXu(arr, low, mid);
            howMuchNiXu(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int[] helper = new int[arr.length];
        Utils.AboutArray.copyIntArray(arr, low, helper, low, high - low + 1);
        int left = low, right = mid + 1;
        int current = low;
        while (left <= mid && right <= high) {
            if (helper[left] <= helper[right]) {
                arr[current++] = helper[left++];
            } else {
                arr[current++] = helper[right++];
                niXu += mid - left + 1;
            }
        }
        while (left <= mid) {
            arr[current++] = helper[left++];
        }
    }
}
