package _刷题.LanqiaoBei._2014;

/**
 * B03_猜字母
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/30 下午 6:53
 */
public class B03_猜字母 {
    public static void main(String[] args) {
        char[] chars = new char[19];
        for (char i = 0; i < chars.length; i++) {
            char c = (char) ('a' + i);
            chars[i] = c;
        }
        String str = new String(chars);

        while (true){
            if(str.length()==1){
                System.out.println(str);
                break;
            }
            StringBuilder new_str = new StringBuilder();
            for (int i = 1; i < str.length(); i+=2) {
                new_str.append(str.charAt(i));
            }
            str = new_str.toString();
        }
    }
}
