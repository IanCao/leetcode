package easy;

/**
 * @author caoyixiong
 * @Date: 2018/10/21
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */

/**
 * 题目：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 解题思路：使用位运算，异或操作（异或：从高位开始比较，如果相同则为0，不同则为1）
 * 进阶：只出现一次的数字II {@link middle.只出现一次的数字II}
 */
public class 只出现一次的数字 {
    public static int singleNumber(int[] nums) {
        int result = 0;
        if (nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 2, 1};
        System.out.print(singleNumber(data));
    }
}
