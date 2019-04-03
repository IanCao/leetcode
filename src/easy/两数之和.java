package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caoyixiong
 * @Date: 2018/7/15
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
