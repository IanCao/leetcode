package work;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caoyixiong
 * @Date: 2019/2/20
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class Test {
    public static void main(String[] args) {
        Method[] methods = Test.class.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Class<?>[] classes = methods[i].getParameterTypes();
            Class<?> clazz = methods[i].getReturnType();

            System.out.println(classes);
            System.out.println(clazz);
        }
    }

    public Map<String, String> aaa(List<Integer> aaa, String bbb) {
        return new HashMap<>();
    }
}
