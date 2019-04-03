package middle;

/**
 * @author caoyixiong
 * @Date: 2018/10/17
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 寻找重复数 { //在排序过程中就能找到重复数
    public static int findDuplicate(int[] nums) {
        HeadSort(nums); //排序

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    private static void HeadSort(int[] values) {

        //创建大顶堆，即最上面的节点是里面最大的，然后在将最上面的跟最后一位元素交换，然后排除最后一位元素再进行下一轮排序，依次递推
        for (int i = values.length / 2; i >= 0; i--) {
            HeadAdjust(values, values.length, i);
        }

        for (int j = values.length - 1; j > 0; j--) {
            swap(values, 0, j);
            HeadAdjust(values, j, 0);
        }
    }

    private static void HeadAdjust(int[] values, int size, int index) {
        int rightChild = index * 2 + 2;
        int leftChild = index * 2 + 1;
        int maxIndex = index;

        if (rightChild < size && values[maxIndex] < values[rightChild]) {
            maxIndex = rightChild;
        }

        if (leftChild < size && values[maxIndex] < values[leftChild]) {
            maxIndex = leftChild;
        }

        if (maxIndex != index) {
            swap(values, index, maxIndex);
            HeadAdjust(values, size, maxIndex);
        }
    }

    private static void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
