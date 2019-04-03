package middle;

/**
 * @author caoyixiong
 * @Date: 2018/10/31
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 题目：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class 两两交换链表中的节点 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;

        ListNode node = root;
        while (node.next != null && node.next.next != null) {
            ListNode pre = node.next;
            ListNode after = node.next.next;

            pre.next = after.next;
            after.next = pre;
            node.next = after;

            node = node.next.next;

        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        println(swapPairs(listNode));

    }

    private static void println(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
