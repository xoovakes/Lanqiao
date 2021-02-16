package AlgorithmIsSoBeautiful._4_矩阵;

/**
 * _4_7_子数组最大累加和
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/16 下午 3:30
 */
public class _4_7_子数组最大累加和 {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, -2, 6, -1};
        int k = new _4_7_子数组最大累加和().findByForce(arr);
        System.out.println(k);
        k = new _4_7_子数组最大累加和().findByDp(arr);
        System.out.println(k);
    }

    /**
     * 暴力破解-0(n²)
     */
    public int findByForce(int[] arr) {
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int sum = arr[i];
            int maxOfI = sum;
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                maxOfI = Math.max(maxOfI, sum);
            }
            maxSum = Math.max(maxOfI, maxSum);
        }
        return maxSum;
    }

    /**
     * 递推法 O(n)
     * 把负数丢弃
     */
    public int findByDp(int[] arr) {
        int sumI = arr[0];
        int max = sumI;
        for (int i = 1; i < arr.length; i++) {
            if(sumI>=0){
                sumI+=arr[i];
            }else{
                sumI=arr[i];
            }
            max=Math.max(max,sumI);
        }
        return max;
    }
}
