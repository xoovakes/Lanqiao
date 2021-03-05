package AlgorithmIsSoBeautiful._7_递归_DFS_剪枝;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * _7_8_全排列
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/05 下午 2:57
 */
public class _7_8_全排列 {
    static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) {
        String str = "abcd";
        ArrayList<String> k = getPermutation0(str);
        System.out.println(k.size());
        System.out.println(k);
        System.out.println("--------");
        k = getPermutation1(str);
        System.out.println(k.size());
        System.out.println(k);
    }

    //递归
    public static ArrayList<String> getPermutation1(String A) {
        char[] arr = A.toCharArray();
        Arrays.sort(arr);
        getPermutationCore(arr, 0);
        return res;
    }

    public static void getPermutationCore(char[] arr, int k) {
        if (k == arr.length) {
            res.add(new String(arr));
        }
        for (int i = k; i < arr.length; i++) {
            swap(arr, k, i);
            getPermutationCore(arr, k + 1);
            swap(arr, k, i);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //迭代
    public static ArrayList<String> getPermutation0(String A) {
        int n = A.length();
        ArrayList<String> res = new ArrayList<>();
        //第一个字符
        res.add(A.charAt(0) + "");
        //后面元素依次加入
        for (int i = 1; i < n; i++) {
            ArrayList<String> res_new = new ArrayList<>();
            char c = A.charAt(i);
            for (String str : res) {
                //加到前面
                String newStr = c + str;
                res_new.add(newStr);
                //加到后面
                newStr = str + c;
                res_new.add(newStr);
                //加到中间
                for (int j = 1; j < str.length(); j++) {
                    newStr = str.substring(0, j) + c + str.substring(j);
                    res_new.add(newStr);
                }
            }
            res = res_new;
        }
        return res;
    }

}
