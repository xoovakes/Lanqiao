package AlgorithmIsSoBeautiful._8_贪心_动态规划._贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Case04_区间选点问题
 * POJ1201
 * 用贪心会超时
 * 用树状树状不超时
 * ---
 * input
 * 5
 * 3 7 3
 * 8 10 3
 * 6 8 1
 * 1 3 1
 * 10 11 1
 * output
 * 6
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/11 下午 5:39
 */
public class Case04_区间选点问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < intervals.length; i++) {
            intervals[i] = new Interval(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        //按区间右端点排序
        Arrays.sort(intervals);
        int max = intervals[n - 1].t;
        // 标记数轴上的点是否已经被选中
        int[] axis = new int[max + 1];
        for (int i = 0; i < intervals.length; i++) {
            //1.查阅区间中有多少个点
            int s = intervals[i].s;//起点
            int t = intervals[i].t;//终点
            int cnt = sum(axis, s, t);//找到这个区间已经选点的数量,可优化
            //2.如果不够，从区间右端开始标记，遇标记过的就跳过
            intervals[i].c -= cnt;//需要新增的点的数量
            while (intervals[i].c > 0) {//从区间终点开始选点
                if (axis[t] == 0) {
                    axis[t] = 1;
                    intervals[i].c--;
                }
                t--;
            }
        }
        System.out.println(sum(axis, 0, max));
    }

    /**
     * 统计数轴axis上s到t区间已经有多少个点被选中
     */
    private static int sum(int[] axis, int s, int t) {
        int sum = 0;
        for (int j = s; j <= t; j++) {
            sum += axis[j];
        }
        return sum;
    }

    private static class Interval implements Comparable<Interval> {
        int s;
        int t;
        int c;

        public Interval(int s, int t, int c) {
            this.s = s;
            this.t = t;
            this.c = c;
        }

        @Override
        public int compareTo(Interval o) {
            int x = this.t - o.t;
            if (x == 0) {
                return this.s - o.s;
            } else {
                return x;
            }
        }
    }
}
