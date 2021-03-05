package AlgorithmIsSoBeautiful._7_递归_DFS_剪枝;

import java.util.*;

/**
 * _7_6_非空子集
 * 请编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * 给定一个int数组A和数组的大小int n，请返回A的所有非空子集。
 * 保证A的元素个数小于等于20，且元素互异。
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/03 上午 12:00
 */
public class _7_6_非空子集 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        Set<Set<Integer>> subsets = getSubsets2(A, A.length);
        System.out.println(subsets);
        subsets = getSubsets3(A, A.length);
        System.out.println(subsets);
        List<List<Integer>> subsets1 = getSubsets4(A);
        System.out.println(subsets1);
    }

    //二进制的方法
    private static List<List<Integer>> getSubsets4(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = (int) Math.pow(2, nums.length) - 1; i >= 0; i--) {
            List<Integer> n = new ArrayList<Integer>();
            for(int j= nums.length-1;j>=0;j--){
                if(((i>>j)&1)==1){
                    n.add(nums[j]);
                }
            }
            res.add(n);
        }
        return res;
    }


    //迭代
    private static Set<Set<Integer>> getSubsets2(int[] A, int n) {
        Set<Set<Integer>> res = new HashSet<>();
        res.add(new HashSet<>());
        for (int i = 0; i < n; i++) {
            Set<Set<Integer>> res_new = new HashSet<>();
            res_new.addAll(res);
            for (Set e : res) {
                Set a = (Set) ((HashSet) e).clone();
                a.add(A[i]);
                res_new.add(a);
            }
            res = res_new;
        }
        return res;
    }

    // 增量构造法
    private static Set<Set<Integer>> getSubsets3(int[] A, int n) {
        Arrays.sort(A);
        return getSubsets3Core(A, n, n - 1);
    }

    //递归增量构造法
    private static Set<Set<Integer>> getSubsets3Core(int[] A, int n, int cur) {
        Set<Set<Integer>> newSet = new HashSet<>();
        //处理第一个元素
        if (cur == 0) {
            Set<Integer> nil = new HashSet<>();
            Set<Integer> first = new HashSet<>();
            first.add(A[0]);
            newSet.add(nil);
            newSet.add(first);
            return newSet;
        }
        Set<Set<Integer>> oldSet = getSubsets3Core(A, n, cur - 1);
        for (Set<Integer> set : oldSet) {
            newSet.add(set);
            Set<Integer> clone = (Set<Integer>) ((HashSet) set).clone();
            clone.add(A[cur]);
            newSet.add(clone);
        }
        return newSet;
    }
}
