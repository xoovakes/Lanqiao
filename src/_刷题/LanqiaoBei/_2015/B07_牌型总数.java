package _刷题.LanqiaoBei._2015;

// 我没玩过扑克牌差点不知道怎么做[哭笑不得].
// 递归，排列组合. 答案: 3598180

public class B07_牌型总数 {
	private static int ans;

	public static void main(String[] args) {
		ans = 0;
		f(0, 0);
		System.out.println(ans);
	}

	/*
	 * k:13种牌型. cnt:已选牌的数量.
	 */
	private static void f(int k, int cnt) {
		if (k > 13 || cnt > 13)
			return;
		if (k == 13 && cnt == 13) {
			ans++;
			return;
		}
		for (int i = 0; i < 5; i++) {
			f(k + 1, cnt + i);
		}
	}
}
