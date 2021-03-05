package AlgorithmIsSoBeautiful._7_递归_DFS_剪枝;

/**
 * _7_10_全排列的第k个排列
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/05 下午 5:22
 */
public class _7_10_全排列的第k个排列 {
    static int k = 0;
    static int count = 0;

    public static void main(String[] args) {
        String s = "123";
        k = 1;
        permutation("", s.toCharArray());
    }

    //前缀法
    private static void permutation(String prefix, char[] arr) {
        if (prefix.length() == arr.length) {
            //当前缀的长度等于字符集的长度，一个排列就完成了
            count++;
            if (count == k) {
                System.out.println("--------:" + prefix);
                System.exit(0);
            }
        }
        //每次都从头扫描，只要该字符可用，我们就附加到前缀后面，前缀变长了
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            //这个字符可用：在pre 中出现次数<在字符集中出现的次数
            if (count(prefix, ch) < count(arr, ch)) {
                permutation(prefix + ch, arr);
            }
        }
    }

    private static int count(String A, char ch) {
        char[] arr = A.toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (ch == arr[i]) {
                res++;
            }
        }
        return res;
    }

    private static int count(char[] arr, char ch) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (ch == arr[i]) {
                res++;
            }
        }
        return res;
    }

}
