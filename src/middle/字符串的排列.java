package middle;

import java.util.*;

/**
 * @author caoyixiong
 * @Date: 2018/12/18
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo
 * 输出: Tru
 * 解释: s2 包含 s1 的排列之一 ("ba").
 */
public class 字符串的排列 {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) {
            return true;
        }
        for (int j = s1.length(); j < s2.length(); j++) {
            count[s2.charAt(j) - 'a']--;
            count[s2.charAt(j - s1.length()) - 'a']++;
            if (allZero(count)) {
                return true;
            }
        }
        return false;
    }

    private static boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        checkInclusion("ab", "eidbaooo");
    }
}
