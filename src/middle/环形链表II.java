package middle;

import easy.环形链表;

/**
 * @author caoyixiong
 * @Date: 2018/10/17
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 环形链表II {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode pre = head;
        ListNode after = head;

        while (pre != null && pre.next != null && pre.next.next != null) {
            pre = pre.next.next;
            after = after.next;

            if (pre == after) {
                break; //说明有环
            }
        }
        if (pre == null || pre.next == null || pre.next.next == null) {
            return null;
        }
        pre = head;
        while (pre != after) {
            pre = pre.next;
            after = after.next;
        }
        return pre;
    }

}
