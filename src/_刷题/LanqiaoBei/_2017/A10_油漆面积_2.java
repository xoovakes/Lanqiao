package _刷题.LanqiaoBei._2017;

/**
 * TODO A10_油漆面积_2
 * https://www.bilibili.com/video/BV1GE411F7Pj?p=473
 * 线段树+扫描线+离散化
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/12 下午 10:37
 */
public class A10_油漆面积_2 {
    // 扫描线
    private static class Line implements Comparable<Line> {
        int x1, x2, h, f;// 左右坐标，高度，f=1为入边，f=-1为出边

        Line() {
        }

        public Line(int x1, int x2, int h, int f) {
            this.x1 = x1;
            this.x2 = x2;
            this.h = h;
            this.f = f;
        }

        @Override
        public int compareTo(Line o) {
            if (h < o.h) return -1;
            else if (h > o.h) return 1;
            else return 0;
        }
    }

    // 线段树
    private static class SegTree {
        int pl, pr, cnt, len;

        SegTree() {
        }

        SegTree lson, rson;
    }

    static final int N = 10000;
    static int n;
    static int[] X = new int[N << 1];
    static Line[] lines = new Line[N];


}
