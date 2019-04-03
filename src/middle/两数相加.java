package middle;

/**
 * @author caoyixiong
 * @Date: 2018/7/15
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 两数相加 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode current = result;

        while (l1 != null || l2 != null) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            int sum = value1 + value2 + current.val;

            current.val = sum % 10;
            current.next = new ListNode(sum / 10);

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

            if (l1 == null && l2 == null && current.next.val == 0) {
                current.next = null;
            }
            current = current.next;
        }


        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(8);
        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(5);
        ListNode node9 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;


        ListNode node11 = new ListNode(6);
        ListNode node22 = new ListNode(7);
        ListNode node33 = new ListNode(8);
        ListNode node44 = new ListNode(0);
        ListNode node55 = new ListNode(8);
        ListNode node66 = new ListNode(5);
        ListNode node77 = new ListNode(8);
        ListNode node88 = new ListNode(9);
        ListNode node99 = new ListNode(7);

        node11.next = node22;
        node22.next = node33;
        node33.next = node44;
        node44.next = node55;
        node55.next = node66;
        node66.next = node77;
        node77.next = node88;
        node88.next = node99;

        ListNode listNode = addTwoNumbers(node1, node11);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
