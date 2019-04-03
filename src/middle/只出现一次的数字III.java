package middle;

/**
 * @author caoyixiong
 * @Date: 2018/10/21
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */

/**
 * 题目：给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * 解题思路: 首先将所有数字都进行异或，这样最终得到的数字就是那两个元素异或之后的结果，然后用n&-n能够获取到n最右边的一个1，因为这个结果是异或出来的结果
 *         所以，这两个数字在这个位置上一定是一个是1，一个是0，这样就可以根据这个特征将所有数字分成两部分，每一部分都跟{@link easy.只出现一次的数字} 一样
 */
public class 只出现一次的数字III {
    public static int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        int[] res = new int[2];
        sum &= -sum;
        for (int i = 0; i < nums.length; i++) {
            if ((sum & nums[i]) == 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 1, 3, 2, 5}));
    }
}
