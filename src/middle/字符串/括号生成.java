package middle.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoyixiong
 * @Date: 2019/4/13
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class 括号生成 {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", n, n, result);
        return result;
    }

    public static void generate(String string, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(string);
            return;
        }

        if (left > 0) {
            generate(string + "(", left - 1, right, result);
        }
        if (right > left) {
            generate(string + ")", left, right - 1, result);
        }
    }

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
