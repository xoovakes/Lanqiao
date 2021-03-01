package AlgorithmIsSoBeautiful._6_数学问题;

import java.util.HashMap;
import java.util.Map;

/**
 * _6_12_质因数分解
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/01 下午 9:26
 */
public class _6_12_质因数分解 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = primeFactor(100);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int k = entry.getKey();
            int v = entry.getValue();
            for (int i = 0; i < v; i++) {
                sb.append("*"+k);
            }
        }
        System.out.println(sb.substring(1));
    }

    public static Map<Integer, Integer> primeFactor(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                Integer v = map.get(i);
                if (v == null) {
                    map.put(i, 1);
                } else {
                    map.put(i, v + 1);
                }
                num /= i;
            }
        }
        return map;
    }
}
