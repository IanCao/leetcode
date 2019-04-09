package middle.链表;

/**
 * @author caoyixiong
 * @Date: 2019/4/3
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class 反转链表II {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode after = null;
        if (m > 1) {
            pre = head;
        }
        ListNode mid = null;
        ListNode node = head;
        while (m > 1 && node != null) {
            m--;
            node = node.next;
            ListNode listNode = node;
            ListNode temp = node.next;
            if (m == 1) {
                listNode.next = null;
                mid = temp;
            }
        }
        ListNode midNode = mid;
        int len = n - m;
        while (midNode != null && len > 1) {
            len--;
        }


    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        reverseBetween(listNode, 2, 4);
    }
}
