package middle;

/**
 * @author caoyixiong
 * @Date: 2018/12/19
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 数组中的第K个最大元素_快排 {
    public static int findKthLargest(int[] nums, int k) {
        int val = qsort(nums, 0, nums.length - 1);
        k -= 1;
        if (val == k) {
            return nums[val];
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (val >= k) {
                right = val;
                val = qsort(nums, left, right);
            } else {
                left = val + 1;
                val = qsort(nums, left, right);
            }
        }
        return nums[k];
    }

    private static int qsort(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        int center = nums[(i + j) / 2];
        while (i <= j) {
            while (nums[i] > center) i++;
            while (nums[j] < center) j--;
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if (j < left) return left;//防止j越界，陷入无限循环
        return j;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
