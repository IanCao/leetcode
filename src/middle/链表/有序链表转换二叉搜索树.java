package middle.链表;

/**
 * @author caoyixiong
 * @Date: 2019/4/10
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 *
 * 题目：给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *      0
 *     / \
 *   -3   9
 *   /   /
 * -10  5
 */
public class 有序链表转换二叉搜索树 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null || head.next == null) {
            return head == null ? null : new TreeNode(head.val);
        }
        ListNode pre = head, mid = head, mid_next = head;
        while (mid_next != null && mid_next.next != null) {// 快慢指针法找到中间节点
            pre = mid;
            mid = mid.next;
            mid_next = mid_next.next.next;
        }
        pre.next = null; // 断链
        TreeNode root = new TreeNode(mid.val); // 构造根节点，左右子节点DSF
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
}
