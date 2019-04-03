package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caoyixiong
 * @Date: 2018/12/19
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)
 * 示例
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出:
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class 最长连续序列 {
    public static int longestConsecutive(int[] nums) {
        int longest = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {

                map.put(nums[i], 1);
                if (map.containsKey(nums[i] - 1)) {
                    longest = Math.max(longest, merge(map, nums[i] - 1, nums[i]));
                }

                if (map.containsKey(nums[i] + 1)) {
                    longest = Math.max(longest, merge(map, nums[i], nums[i] + 1));
                }
            }
        }
        if (longest == 0 && !map.isEmpty()) {
            return 1;
        }
        return longest;
    }

    public static int merge(Map<Integer, Integer> map, int less, int more) {
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left, len); //最小
        map.put(right, len); //最大
        return len;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{-1, -4, 0, 8, -2, 6, -4, -8, 9, -2, -6, -6}));
    }
}
