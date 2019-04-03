package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author caoyixiong
 * @Date: 2018/10/16
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 有效的括号 {
    public static boolean isValid(String s) {
        if (s != null && s.trim().equalsIgnoreCase("")) {
            return true;
        }
        Map<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            if (map.get(stack.peek()) != null && map.get(stack.peek()) == s.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("){"));
    }
}
