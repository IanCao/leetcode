package easy;

/**
 * @author caoyixiong
 * @Date: 2018/10/21
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 反转链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        return reverse_1(head);
    }

    private static ListNode reverse_1(ListNode node) { //递归
        if (node.next == null) {
            return node;
        }
        ListNode listNode = reverse_1(node.next);
        node.next.next = node;
        node.next = null;
        return listNode;
    }

    private static ListNode reverse_2(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode current = node;
        ListNode next = current.next;
        node.next = null;

        while (next != null) {
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        return current;
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
        listNode3.next = listNode4;

        ListNode listNode5 = reverseList(listNode);
        System.out.print(listNode5);
    }

}
