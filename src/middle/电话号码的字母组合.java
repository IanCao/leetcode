package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author caoyixiong
 * @Date: 2018/12/18
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 电话号码的字母组合 {

    private static final String[][] data = new String[][]{
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"},
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || "".equalsIgnoreCase(digits)) {
            return result;
        }
        int first = digits.charAt(0) - 48 - 2;
        String[] current = data[first];
        if (digits.length() == 1) {
            result.addAll(Arrays.asList(current));
            return result;
        }

        List<String> leftList = letterCombinations(digits.substring(1));

        for (String aCurrent : current) {
            for (String str : leftList) {
                result.add(aCurrent + str);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char c = '2';
        System.out.println(Integer.valueOf(c));
        System.out.println(c - '0');
    }
}
