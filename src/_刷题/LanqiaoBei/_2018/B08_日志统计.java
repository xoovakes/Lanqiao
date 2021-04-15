package _刷题.LanqiaoBei._2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * B08_日志统计
 * 先写暴力法
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/15 下午 7:49
 */
public class B08_日志统计 {
    private static int N, D, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = sc.nextInt();
        K = sc.nextInt();
        Dates[] dates = new Dates[N];
        for (int i = 0; i < N; i++) {
            dates[i] = new Dates(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(dates);
//        for (int i = 0; i < dates.length; i++) {
//            System.out.println(dates[i].id + " " + dates[i].ts);
//        }//t

        //前缀和
        for (int i = 0; i < N; ) {
//            System.out.println(i);//t
            int id = dates[i].id;
            ArrayList<Integer> ts_end = new ArrayList<>();
            int j = i;
            for (; j < N; j++) {
//                System.out.println(j);//t
                if (dates[j].id != id) {
                    if (ts_end.size() >= K) {
                        System.out.println(id);
                        break;
                    }
                    break;
                }
                ts_end.add(dates[j].ts);
                for (int k = 0; k < ts_end.size(); k++) {
                    if (dates[j].ts - ts_end.get(k) >= D) {
                        ts_end.remove(k--);
                    }
                }
//                System.out.println(dates[i].id + " " + dates[i].ts + " " + ts_end.size());//t
            }
            i = j;
        }
    }

    private static class Dates implements Comparable<Dates> {
        int ts;
        int id;

        public Dates(int ts, int id) {
            this.ts = ts;
            this.id = id;
        }

        @Override
        public int compareTo(Dates o) {
            if (this.id < o.id) {
                return -1;
            } else if (this.id > o.id) {
                return 1;
            } else {
                return Integer.compare(this.ts, o.ts);
            }
        }
    }
}
