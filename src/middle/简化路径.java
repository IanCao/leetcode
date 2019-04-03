package middle;

import java.util.LinkedList;

/**
 * @author caoyixiong
 * @Date: 2018/12/19
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * 给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
 * 例如
 * path = "/home/", => "/home
 * path = "/a/./b/../../c/", => "/c"
 */
public class 简化路径 {
    public static String simplifyPath(String path) {
        String[] strings = path.split("/");
        LinkedList<String> linkedList = new LinkedList();
        for (String s : strings) {
            if (s.equalsIgnoreCase("..")) {
                if (linkedList.size() > 0) {
                    linkedList.removeLast();
                }
            } else if (!s.equals(".") && !s.isEmpty()) {
                linkedList.add(s);
            }
        }

        StringBuilder stringBuilder = new StringBuilder("/");
        for (String string : linkedList) {
            stringBuilder.append(string).append("/");
        }
        if(stringBuilder.length() > 1){
            stringBuilder.deleteCharAt(stringBuilder.length() -1);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/."));
    }
}
