package middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caoyixiong
 * @Date: 2018/7/15
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int temp = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                temp++;
            } else {
                if (map.get(s.charAt(i)) + temp < i) {
                    temp++;
                } else {
                   max = Math.max(temp, max);
                   temp = i - map.get(s.charAt(i));
                }
            }
            map.put(s.charAt(i),i);
        }
        return Math.max(temp, max);
    }

    public static void main(String[] args) {

    }
}
