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
        int start = m, end = n;
        ListNode pre = null;
        ListNode after = null;
        if (start > 1) {
            pre = head;
        }
        ListNode node = head;
        while (start > 1 && node != null) {
            start--;
            ListNode listNode = node;
            node = node.next;
            if (start == 1) {
                listNode.next = null;
            }
        }
        //此时node是链表的头
        int len = n - m;
        ListNode mid = node;
        while (node != null && len >= 0) {
            ListNode listNode = node;
            node = node.next;
            if (len == 0) {
                listNode.next = null;
            }
            len--;
        }
        after = node;
        ListNode newNode = reverse(mid);
        if (pre != null) {
            ListNode listNode = pre;
            while (listNode.next != null) {
                listNode = listNode.next;
            }
            listNode.next = newNode;
        }

        if (after != null) {
            ListNode listNode = newNode;
            while (listNode.next != null) {
                listNode = listNode.next;
            }
            listNode.next = after;
        }
        return pre == null ? newNode : pre;
    }

    private static ListNode reverse(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode listNode = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return listNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(6);
//        ListNode listNode6 = new ListNode(7);

        listNode.next = listNode1;
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        reverseBetween(listNode, 3, 3);
    }
}
