package AlgorithmIsSoBeautiful._5_字符串;

import org.assertj.core.api.Assertions;

/**
 * _5_10_回文串
 * 和回文数
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/18 下午 10:49
 */
public class _5_10_回文串 {
    public static void main(String[] args) {
        String src = "abcba";
        _5_10_回文串 c = new _5_10_回文串();
        Assertions.assertThat(c.isPalindrome(src)).isTrue();
        c.palindromeNumber();
    }

    public void palindromeNumber(){
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i*1000+j*100+j*10+i);
            }

        }
    }

    public boolean isPalindrome(String src) {
        if (src.isEmpty()) {
            return true;
        }
        return src.equals(new StringBuilder(src).reverse().toString());
    }
}
