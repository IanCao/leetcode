package easy;

/**
 * @author caoyixiong
 * @Date: 2018/10/21
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */

/**
 * 结题思路：根据两个链表的差值来决定长链表先行的步数，然后短链表后行，两个链表最终会是同一个链表
 */
public class 相交链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode last = headB;
        while (last.next != null) {
            last = last.next;
        }
        last.next = headB;

        ListNode fast = headA;
        ListNode slow = headA;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = headA;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                last.next = null;
                return fast;
            }
        }
        last.next = null;
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode1 = new ListNode(1);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(8);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(4);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(5);
        listNode3.next = listNode4;

        ListNode listNode11 = new ListNode(5);
        ListNode listNode21 = new ListNode(0);
        listNode11.next = listNode21;
        ListNode listNode31 = new ListNode(1);
        listNode21.next = listNode31;
        ListNode listNode41 = new ListNode(8);
        listNode31.next = listNode41;
        ListNode listNode51 = new ListNode(4);
        listNode41.next = listNode51;
        ListNode listNode61 = new ListNode(5);
        listNode51.next = listNode61;

        ListNode listNode311 = getIntersectionNode(listNode, listNode11);
        System.out.print(listNode311.val);
    }
}
