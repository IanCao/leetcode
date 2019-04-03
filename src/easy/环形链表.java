package easy;

/**
 * @author caoyixiong
 * @Date: 2018/10/17
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 环形链表 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode pre = head;
        ListNode after = head;

        while (pre != null && pre.next != null && pre.next.next != null) {
            pre = pre.next.next;
            after = after.next;

            if (pre == after) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);

    }
}
