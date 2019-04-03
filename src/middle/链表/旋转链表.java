package middle.链表;

/**
 * @author caoyixiong
 * @Date: 2019/4/3
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 题目：给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例：
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 */
public class 旋转链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        ListNode node = head;
        int length = 1;
        while (node.next != null) {
            length++;
            node = node.next;
        }
        node.next = head;
        k = k % length;
        int size = length - k - 1;
        ListNode node1 = head;
        while (size > 0) {
            node1 = node1.next;
            size--;
        }
        ListNode result = node1.next;
        node1.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(4);
//        ListNode listNode4 = new ListNode(5);

        listNode.next = listNode1;
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;

        ListNode result = rotateRight(listNode, 4);
        println(result);
    }

    private static void println(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
