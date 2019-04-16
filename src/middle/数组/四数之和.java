package middle.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author caoyixiong
 * @Date: 2019/4/16
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为
 * [-1,  0, 0, 1]
 * [-2, -1, 1, 2]
 * [-2,  0, 0, 2
 * ]
 */
public class 四数之和 {
    public List<List<Integer>> fourSum(final int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        result.add(list);
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return result;
    }

}

