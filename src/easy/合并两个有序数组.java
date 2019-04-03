package easy;

/**
 * @author caoyixiong
 * @Date: 2018/10/21
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */

/**
 * 结题思路：从大往小排序
 */
public class 合并两个有序数组 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0 && len >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[len--] = nums1[m--];
            } else {
                nums1[len--] = nums2[n--];
            }
        }
        while (n >= 0 && len >= 0) {
            nums1[len--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 0, 0, 0};
        int[] data1 = new int[]{2, 5, 6};

        merge(data, 3, data1, 3);

        System.out.println(" ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
