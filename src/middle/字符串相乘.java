package middle;

/**
 * @author caoyixiong
 * @Date: 2018/12/18
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 字符串相乘 {
    public static String multiply(String num1, String num2) {
        char[] ch1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] ch2 = new StringBuilder(num2).reverse().toString().toCharArray();
        int[] result = new int[ch1.length + ch2.length];

        for (int i = 0; i < ch1.length; i++) {
            int a = ch1[i] - '0';
            for (int j = 0; j < ch2.length; j++) {
                int b = ch2[j] - '0';
                result[i + j] += a * b;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int q = 0; q < result.length; q++) {
            int remain = result[q] % 10;
            int up = result[q] / 10;
            if (q + 1 < result.length) {
                result[q + 1] += up;
                stringBuilder.insert(0, remain);
            } else {
                stringBuilder.insert(0, result[q]);
            }
        }
        while (stringBuilder.length() > 0 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }

        return stringBuilder.length() > 0 ? stringBuilder.toString() : "0";
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
}
