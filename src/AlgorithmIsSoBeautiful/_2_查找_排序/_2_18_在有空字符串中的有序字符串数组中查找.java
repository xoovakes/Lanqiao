package AlgorithmIsSoBeautiful._2_查找_排序;

/**
 * 在有空字符串中的有序字符串数组中查找
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/29 下午 11:14
 */
public class _2_18_在有空字符串中的有序字符串数组中查找 {
    public static void main(String[] args) {
        ComputingTime computingTime = new ComputingTime();
        _2_18_在有空字符串中的有序字符串数组中查找 c = new _2_18_在有空字符串中的有序字符串数组中查找();
        String[] str = {"a", "", "ac", "", "ad", "b", "", "ba"};
        computingTime.begin();
        System.out.println(c.indexOf(str, "b"));
        computingTime.end();
    }

    public int indexOf(String[] str, String p) {
        int begin = 0;
        int end = str.length - 1;
        while (begin <= end) {
            int indexOfMid = begin + ((end - begin >> 1));
            while ("".equals(str[indexOfMid])) {
                indexOfMid++;
                if (indexOfMid > end) {
                    return -1;
                }//坑
            }
            if (str[indexOfMid].compareTo(p) > 0) {
                end = indexOfMid - 1;
            } else if (str[indexOfMid].compareTo(p) < 0) {
                begin = indexOfMid + 1;
            } else {
                return indexOfMid;
            }
        }
        return -1;
    }
}
