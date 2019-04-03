package easy;


/**
 * @author caoyixiong
 * @Date: 2018/10/24
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 反转字符串 {
    public static String reverseString(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static String reverseString1(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().toString();
    }

    public static String reverseString2(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (chars[i] != chars[j]) {
                char temp = chars[j];
                chars[j] = chars[i];
                chars[i] = temp;
            }
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.print(reverseString1("hello"));
    }


}
