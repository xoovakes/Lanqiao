package _刷题.LanqiaoBei._2018;

import java.util.Random;

// test:
// 1, 4, 7, 8, 5, 2  x = 2
// 1, 4, 7, 8, 5, 2  i = 0
// 1, 4, 7, 8, 5, 4  i = 1  j = 4
//- 1, 4, 7, 8, 5, 4  i = 1  j = 3
//- 1, 4, 7, 8, 5, 4  i = 1  j = 2
//- 1, 2, 7, 8, 5, 4  i = 1  j = 1


public class B05_快速排序 {
    public static int quickSelect(int[] a, int l, int r, int k) {
        Random rand = new Random();
        int p = rand.nextInt(r - l + 1) + l;
        int x = a[p];
        int tmp = a[p];
        a[p] = a[r];
        a[r] = tmp;
        int i = l, j = r;
        while (i < j) {
            while (i < j && a[i] < x) i++;
            if (i < j) {
                a[j] = a[i];
                j--;
            }
            while (i < j && a[j] > x) j--;
            if (i < j) {
                a[i] = a[j];
                i++;
            }
        }
        a[i] = x;
        p = i;
        if (i - l + 1 == k) return a[i];
        if (i - l + 1 < k) return quickSelect(a, i + 1, r, k - (i - l + 1)); //填空
        else return quickSelect(a, l, i - 1, k);
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 2, 8, 5, 7};
        System.out.println(quickSelect(a, 0, 5, 4));
    }
}