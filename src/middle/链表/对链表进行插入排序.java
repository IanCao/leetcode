package middle.链表;

/**
 * @author caoyixiong
 * @Date: 2019/4/2
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 对链表进行插入排序 {

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(-1); //此节点为新链表的头结点
        while (head != null) {
            ListNode next = head.next;
            ListNode p = dummyHead;
            while (p.next != null && p.next.val < head.val) {
               p = p.next;
            }
            head.next = p.next;
            p.next = head;
            head = next;
        }
        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        insertionSortList(listNode);
    }
}
