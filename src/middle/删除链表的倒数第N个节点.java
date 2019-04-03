package middle;

/**
 * @author caoyixiong
 * @Date: 2018/10/31
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 删除链表的倒数第N个节点 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode root = new ListNode(0);
        root.next = head;

        ListNode pre = root;
        ListNode after = root;

        while (n >= 0) {
            pre = pre.next;
            n--;
        }

        while (pre != null) {
            pre = pre.next;
            after = after.next;
        }

        after.next = after.next.next;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        ListNode listNode4 = new ListNode(5);

//        listNode.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;

        println(removeNthFromEnd(listNode, 1));

    }

    private static void println(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
