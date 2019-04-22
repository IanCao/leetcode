package middle.数组;

import java.util.Arrays;

/**
 * @author caoyixiong
 * @Date: 2019/4/17
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 其实就是从数组倒着查找
 * 找到nums[i] 比nums[i+1]小的时候
 * 就将nums[i]
 * 跟nums[i+1]到nums[nums.length - 1]
 * 当中找到一个最小的比nums[i]大的元素交换。
 * 交换后，再把nums[i+1]到nums[nums.length-1]排序，就ok了
 */
public class 下一个排列 {
    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int l = i - 1;
            for (;l>=0;l--) {
                if (nums[i] > nums[l]) {
                    int temp = nums[l];
                    nums[l] = nums[i];
                    nums[i] = temp;
                    Arrays.sort(nums, l + 1, nums.length);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        nextPermutation(nums);
        System.out.println(nums);
    }
}
