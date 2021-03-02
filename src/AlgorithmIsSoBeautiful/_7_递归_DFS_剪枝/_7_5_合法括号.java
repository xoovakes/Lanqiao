package AlgorithmIsSoBeautiful._7_递归_DFS_剪枝;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * _7_5_合法括号
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/02 下午 7:20
 */
public class _7_5_合法括号 {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            System.out.println(generateParenthesis(i));
        }
    }

    private static List<String> generateParenthesis(int n) {
        Set<String> res = Parenthesis(n);
        List<String> list = new LinkedList<String>();
        for (String s : res) {
            list.add(s);
        }
        return list;
    }

    //迭代
    private static Set<String> Parenthesis1(int n) {
        Set<String> res = new HashSet<>();
        res.add("()");
        if (n == 1) {
            return res;
        }
        for (int i = 2; i <= n; i++) {
            Set<String> res_new = new HashSet<>();
            for (String e : res) {
                res_new.add(e + "()");
                res_new.add("()" + e);
                res_new.add("(" + e + ")");
            }
            res = res_new;
        }
        return res;
    }

    //逐步生成递归
    private static Set<String> Parenthesis(int n) {
        Set<String> s_n = new HashSet<String>();
        if (n == 1) {
            s_n.add("()");
            return s_n;
        }
        Set<String> s_n_1 = Parenthesis(n - 1);
        for (String eOfN_1 : s_n_1) {
            s_n.add("()" + eOfN_1);
            s_n.add(eOfN_1 + "()");
            s_n.add("(" + eOfN_1 + ")");
        }
        return s_n;
    }
}
