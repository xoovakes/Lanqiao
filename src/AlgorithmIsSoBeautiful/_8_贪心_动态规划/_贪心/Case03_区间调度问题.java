package AlgorithmIsSoBeautiful._8_贪心_动态规划._贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Case03_区间调度问题
 * 选择尽量多的不相交区间
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/11 下午 4:27
 */
public class Case03_区间调度问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //start
        int[] s = new int[n];
        //end
        int[] t = new int[n];
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(s[i], t[i]);
        }
        Arrays.sort(jobs);
        int res = f(jobs);
        System.out.println(res);
    }

    private static int f(Job[] jobs) {
        int cnt = 1;
        int y = jobs[0].t;
        for (int i = 0; i < jobs.length; i++) {
            if (jobs[i].s > y) {
                cnt++;
                y = jobs[i].t;
            }
        }
        return cnt;
    }

    private static class Job implements Comparable<Job> {
        int s;
        int t;

        public Job(int s, int t) {
            this.s = s;
            this.t = t;
        }

        @Override
        public int compareTo(Job o) {
            int x = this.t - o.t;
            if (x == 0) {
                return this.s - o.s;
            } else {
                return x;
            }
        }
    }
}
