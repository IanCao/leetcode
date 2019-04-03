package middle;

/**
 * @author caoyixiong
 * @Date: 2018/10/21
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */

/**
 * 题目：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 解题思路：出现三次的数字的32位中每一个位的重复数量一定是3的倍数，所以其中如果某一位的重复数量%3是1，那就是那个单独的数字
 * 进阶：只出现一次的数字 III {@link middle.只出现一次的数字III}
 */
public class 只出现一次的数字II {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;

            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((mask & nums[j]) != 0) {
                    count++;
                }
            }

            if (count % 3 == 1) {
                result = mask | result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[]{0, 1, 0, 1, 0, 1, 99};
        int[] data1 = new int[]{2, 2, 3, 2};
        System.out.print(singleNumber(data));
        System.out.println();
        System.out.print(singleNumber(data1));
    }
}
