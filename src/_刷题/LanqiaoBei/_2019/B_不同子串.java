package _刷题.LanqiaoBei._2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * B_不同子串
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/16 下午 7:53
 */
public class B_不同子串 {
    public static void main(String[] args) {
        String str = "0100110001010001";
        Set<String> aSet = new HashSet<>();
        aSet.add("");

        for(int i = 0; i < str.length(); i++) {
            for(int j = i ; j < str.length(); j++) {
                aSet.add(str.substring(i, j + 1 ));
            }
        }

        {
            ArrayList<String> arr0 = new ArrayList<>(aSet);
            for (int i = 0; i < arr0.size(); i++) {
                System.out.println(arr0.get(i));
            }
            System.out.println();
        }//test
        System.out.println(aSet.size() - 1);
    }

}
