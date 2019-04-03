package middle;

/**
 * @author caoyixiong
 * @Date: 2018/11/20
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 *
 * 题目：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *  输入: "babad"
 *  输出: "bab"
 *  注意: "aba" 也是一个有效答案。
 *
 *  解题思路：从字符串首位往后进行遍历，每次根据对应位以中心，往两边扩散寻找最大回文数。
 */
public class 最长回文子串 {
    private static int maxLen = 0;
    private static String sub = "";

    public static String longestPalindrome(String s) {
        maxLen = 0;
        sub = "";
        if (s.length() <= 1)
            return s;

        for (int i = 0; i < s.length() - 1; i++) {

            findLongestPalindrome(s, i, i);//单核回文

            findLongestPalindrome(s, i, i + 1);//双核回文
        }
        return sub;
    }

    public static void findLongestPalindrome(String s, int low, int high) {
        while (low >= 0 && high <= s.length() - 1) {
            if (s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > maxLen) {
                    maxLen = high - low + 1;
                    sub = s.substring(low, high + 1);
                }
                low--;//向两边扩散找当前字符为中心的最大回文子串
                high++;
            } else
                break;
        }
    }
}
