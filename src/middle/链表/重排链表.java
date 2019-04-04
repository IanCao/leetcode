package middle.链表;

/**
 * @author caoyixiong
 * @Date: 2019/4/3
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 思路：先用快慢指针获取链表中心，然后反转后面的链表，进行整合
 */
public class 重排链表 {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode ss = slow.next;
        slow.next = null;
        ListNode l = head;
        ListNode r = revert(ss);
        while (l != null && r != null) {
            ListNode temp = r;
            r = r.next;
            temp.next = l.next;
            l.next = temp;
            l = l.next.next;
        }
    }

    private static ListNode revert(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode cur = node;
        ListNode next = node.next;
        cur.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;

        reorderList(listNode);
        ListNode.println(listNode);
    }
}
