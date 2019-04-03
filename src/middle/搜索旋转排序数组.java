package middle;

/**
 * @author caoyixiong
 * @Date: 2018/10/30
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 搜索旋转排序数组 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (right == 0) {
            return nums[right] == target ? 0 : -1;
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) { //右半段递增
                if (nums[mid] < target && nums[right] >= right) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { //左半段递增
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(data, target));
    }
}
