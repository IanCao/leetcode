package middle;

/**
 * @author caoyixiong
 * @Date: 2018/11/1
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */

/**
 * 题目： 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 */
public class 两数相除 {
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return -1;
        }

        boolean flag = (dividend < 0 || divisor < 0) && !(dividend < 0 && divisor < 0);
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        System.out.println(dvd + " " + dvs + " " + flag);

        long result = 0;
        while (dvd >= dvs) {
            long temp = dvs;
            long ll = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                ll <<= 1;
            }
            dvd -= temp;
            result += ll;
        }
        if (flag) {
            return -result < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) -result;
        }

        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }
}
