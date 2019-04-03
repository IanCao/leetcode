package middle;

/**
 * @author caoyixiong
 * @Date: 2018/12/19
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例
 * 输入: "the sky is blue"
 * 输出: "blue is sky the".
 */
public class 翻转字符串里的单词 {
    public String reverseWords(String s) {
        if (s == null || "".equalsIgnoreCase(s)) {
            return "";
        }
        String[] string = s.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = string.length - 1; i >= 0; i--) {
            String s1 = string[i];
            if (s1.trim().equalsIgnoreCase("")) {
                continue;
            }
            stringBuilder.append(string[i]);
            if(i > 0){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }
}
