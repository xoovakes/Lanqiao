package AlgorithmIsSoBeautiful._8_贪心_动态规划;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

/**
 * Case05_区间覆盖问题
 * POJ2376
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/11 下午 6:27
 */
public class Case05_区间覆盖问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        Job[] jobs = new Job[N];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new Job(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(jobs);//按照区间起点排序
        //要覆盖的目标点，end覆盖该点的所有区间中右端最右
        int start = 1;
        int end = 1;
        int ans = 1;
        for (int i = 0; i < jobs.length; i++) {
            int s = jobs[i].s;
            int t = jobs[i].t;
            if (i == 0 && s > 1) {
                break;
            }
            if (s <= start) {
                end = max(t, end);
            } else {//开始下一个区间
                ans++;
                start = end + 1;
                if (s <= start) {
                    end = max(t, end);
                } else {
                    break;
                }
            }
            if (end >= T) {
                break;
            }
        }
        if (end < T) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    private static class Job implements Comparable<Job> {
        int s;
        int t;

        public Job(int s, int t) {
            this.s = s;
            this.t = t;
        }

        //按照区间起点排序
        @Override
        public int compareTo(Job o) {
            int x = this.s - o.s;
            if (x == 0) {
                return this.t - o.t;
            } else {
                return x;
            }
        }
    }
}
