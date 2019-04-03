package easy;

/**
 * @author caoyixiong
 * @Date: 2018/10/17
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int flag = 0;
        while (flag < strs[0].length()) {
            char c = strs[0].charAt(flag);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= flag || strs[i].charAt(flag) != c) {
                    return result.toString();
                }
            }
            result.append(c);
            flag++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"aa", "a"}));
    }
}
