package AlgorithmIsSoBeautiful._1_位运算;

/**
 * TODO
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/21 下午 6:20
 */
public class _1_8_出现k次与出现1次 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 9, 7, 7, 7, 3, 3, 3, 6, 6, 6, 0, 0, 0};
        int len = arr.length;
        char[][] kRadix = new char[len][];
        int k = 3;
        //k进制数最大长度
        int maxLen = 0;
        //转换成k进制数的翻转字符串
        for (int i = 0; i < len; i++) {
            //求每个数字的k进制字符串并翻转，然后转为字符数组
            kRadix[i] = new StringBuilder(Integer.toString(arr[i], k)).reverse().toString().toCharArray();
            if (kRadix[i].length > maxLen) {
                maxLen = kRadix[i].length;
            }
        }
        int[] resArr = new int[maxLen];
        //i个数的j位数全部加起来
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < maxLen; j++) {
                if (j >= kRadix[i].length) {
                    resArr[j] += 0;
                } else {
                    resArr[j] += (kRadix[i][j] - '0');
                }
            }
        }
        int res = 0;
        for(int i=0;i<maxLen;i++){
            //余k，不进位处理
            res += (resArr[i]%k)*(int)(Math.pow(k,i));
        }
        System.out.println(res);
    }
}
