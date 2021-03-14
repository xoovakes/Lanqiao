package AlgorithmIsSoBeautiful._8_贪心_动态规划;

import java.util.Arrays;

/**
 * Case08_部分背包问题
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/14 下午 2:43
 */
public class Case08_部分背包问题 {
    public static void main(String[] args) {
        int[] w = {1, 2, 3, 4, 5};
        int[] v = {3, 4, 3, 1, 4};
        int n = w.length;
        double C = 10;
        Obj[] objs = new Obj[n];
        for (int i = 0; i < objs.length; i++) {
            objs[i] = new Obj(w[i], v[i]);
        }

        Arrays.sort(objs);
        double c = C;
        double maxValue = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (objs[i].w <= c) {
                maxValue += objs[i].v;
                c -= objs[i].w;
            } else {
                maxValue += objs[i].v * (c / objs[i].w);
                break;
            }
        }
        System.out.println(maxValue);
    }

    private static class Obj implements Comparable<Obj> {
        int w;
        int v;

        public Obj(int w, int v) {
            this.w = w;
            this.v = v;
        }

        public double getPrice() {
            return v / (double) w;
        }

        @Override
        public int compareTo(Obj o) {
            if (this.getPrice() == o.getPrice()) {
                return 0;
            } else if (this.getPrice() < o.getPrice()) {
                return -1;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "w=" + w +
                    ", v=" + v +
                    ", price=" + getPrice() +
                    '}';
        }
    }
}
