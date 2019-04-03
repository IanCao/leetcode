package middle;

/**
 * @author caoyixiong
 * @Date: 2018/12/19
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
 * 而不是第 k 个不同的元素。
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class 数组中的第K个最大元素_堆排序 {
    public static int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            heap(nums, i);
        }
        return nums[nums.length - k];
    }

    private static void heap(int[] nums, int index) {
        int len = nums.length - index;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            if (i * 2 + 1 < len) {
                if (nums[i] < nums[i * 2 + 1]) {
                    int j = nums[i];
                    nums[i] = nums[i * 2 + 1];
                    nums[i * 2 + 1] = j;
                }
            }

            if (i * 2 + 2 < len) {
                if (nums[i] < nums[i * 2 + 2]) {
                    int j = nums[i];
                    nums[i] = nums[i * 2 + 2];
                    nums[i * 2 + 2] = j;
                }
            }
            if (i * 2 + 2 < len && i * 2 + 1 < len) {
                if (nums[i * 2 + 1] > nums[i * 2 + 2]) {
                    int j = nums[i * 2 + 1];
                    nums[i * 2 + 1] = nums[i * 2 + 2];
                    nums[i * 2 + 2] = j;
                }
            }
        }
        int res = nums[0];
        nums[0] = nums[nums.length - 1 - index];
        nums[nums.length - 1 - index] = res;
    }

    //构建大顶堆


    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
