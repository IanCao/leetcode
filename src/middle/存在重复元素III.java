package middle;

/**
 * @author caoyixiong
 * @Date: 2018/10/23
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */

import java.util.*;

/**
 * 题目：给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 */
public class 存在重复元素III {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2 || k < 1 || t < 0) {
            return false;
        }
        SortedSet<Long> sortedSet = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            SortedSet set = sortedSet.subSet((long) nums[i] - t, (long) nums[i] + t + 1);
            if (!set.isEmpty()) {
                return true;
            }
            if (i >= k) {
                sortedSet.remove((long) nums[i - k]);
            }
            sortedSet.add((long) nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.print(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }
}
