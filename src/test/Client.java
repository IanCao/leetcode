package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoyixiong
 * @Date: 2018/11/28
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class Client {
    public static void main(String[] args) {
        Integer a = (Integer) null;
        System.out.println(a == 1);
        System.out.println(1 == a);
        System.out.println(new Integer(1).equals(a));
    }
}
