package _刷题.LanqiaoBei._2017;

import java.util.Scanner;

/**
 * B09_分巧克力
 * https://blog.csdn.net/weixin_44558280/article/details/114085911
 * https://www.bilibili.com/video/BV1GE411F7Pj?p=490
 * 二分法
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/07 下午 1:30
 */
public class B09_分巧克力 {
    public static void main(String[] args) {
        int n, k;
        int[] h = new int[100000];
        int[] w = new int[100000];
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int r = 100001;
        int l = 1;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;// l + (r-l)/2
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += (h[i] / mid) * (w[i] / mid);
            }
            if (cnt >= k) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
