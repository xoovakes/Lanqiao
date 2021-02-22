package AlgorithmIsSoBeautiful._5_字符串._字符串匹配;

import Utils.ComputingTime;

import java.util.Arrays;

/**
 * _5_16_后缀数组
 * 我还怀疑是不是自己的能力问题，结果是真的难,难度很高，A组水平
 * TODO 就写了一半太难了
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/21 下午 11:07
 */
public class _5_16_后缀数组 {
    public static void main(String[] args) {
        String s = "babcababcbbbabababdbaababb";
        String p = "baba";
        ComputingTime.beginCompute();
        match(s, p);
        ComputingTime.endCompute();
        ComputingTime.beginCompute();
        match(s, p);
        ComputingTime.endCompute();
    }

    private static void match(String s, String p) {
        Suff[] sa = getSa(s);
        int l = 0;
        int r = s.length() - 1;
        //二分查找,nlog m
        while (r >= l) {
            int mid = l + ((r - l) >> 1);
            Suff midSuff = sa[mid];
            String suffStr = midSuff.str;
            int compareRes;
            //将后缀和模式串比较,O(n)
            if (suffStr.length() >= p.length()) {
                compareRes = suffStr.substring(0, p.length()).compareTo(p);
            } else {
                compareRes = suffStr.compareTo(p);
            }
            //相等了就输出后缀的起始位置
            if (compareRes == 0) {
                System.out.println(midSuff.index);
                break;
            } else if (compareRes < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }

    /**
     * 直接对所以后缀排序，因为字符串的比较消耗O(n)
     *
     * @param src
     * @return
     */
    public static Suff[] getSa(String src) {
        int strLength = src.length();
        Suff[] suffixArray = new Suff[strLength];
        for (int i = 0; i < strLength; i++) {
            //截取后缀
            String suffI = src.substring(i);
            suffixArray[i] = new Suff(suffI, i);
        }
        Arrays.sort(suffixArray);
        return suffixArray;
    }

    static class Suff implements Comparable<Suff> {
        //后缀内容
        String str;
        //后缀的起始下标
        int index;

        public Suff(String str, int index) {
            this.str = str;
            this.index = index;
        }

        @Override
        public int compareTo(Suff o) {
            return this.str.compareTo(o.str);
        }

        @Override
        public String toString() {
            return "Suff{" +
                    "str='" + str + '\'' +
                    ", index=" + index +
                    '}';
        }
    }
}
