package easy;

import java.util.LinkedList;

/**
 * @author caoyixiong
 * @Date: 2018/7/15
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 回文数 {
    public static boolean isPalindrome(int x) {
        LinkedList linkedList = new LinkedList();
        String source = String.valueOf(x);
        for (int i = 0; i < source.length(); i++) {
            linkedList.add(source.charAt(i));
        }
        String result = "";
        for (int j = linkedList.size() - 1; j >= 0; j--) {
            result = result + linkedList.get(j);
        }
        System.out.println(result);
        return source.equalsIgnoreCase(result);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-12321));
    }
}
