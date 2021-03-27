package _刷题.LanqiaoBei._2015;

public class B06_加法变乘法 {
	public static void main(String[] args) {
		for (int i = 1; i < 46; i++) {
			for (int j = i + 2; j < 48; j++) {
				if (i * (i + 1) - (i + i + 1) + j * (j + 1) - (j + j + 1) == 2015 - 1225)
					System.out.println(i + " " + j);
			}
		}
	}
}
