package easy;

/**
 * @author caoyixiong
 * @Date: 2018/10/24
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 移除链表元素 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(0);
        root.next = head;

        ListNode pre = root;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
                continue;
            }
            pre = pre.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(6);

        listNode.next = listNode1;
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        ListNode node = removeElements(listNode, 1);
        System.out.print(node.val);

    }


}
