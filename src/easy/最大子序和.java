package easy;

/**
 * @author caoyixiong
 * @Date: 2018/10/21
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */

/**
 * 题目：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class 最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int current = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (current < 0) {
                current = nums[i];
            } else {
                current += nums[i];
            }

            if (current > sum) {
                sum = current;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
