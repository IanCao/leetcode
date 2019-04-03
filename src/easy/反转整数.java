package easy;

/**
 * @author caoyixiong
 * @Date: 2018/10/15
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 反转整数 {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.print(Integer.MIN_VALUE);
    }
}
