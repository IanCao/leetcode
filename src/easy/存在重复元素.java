package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caoyixiong
 * @Date: 2018/10/22
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */

/**
 * 题目：给定一个整数数组，判断是否存在重复元素。
 *      如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 进阶：{@link easy.存在重复元素II}
 */
public class 存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], 0);
        }
        return false;
    }
}
