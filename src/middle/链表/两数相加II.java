package middle.链表;

/**
 * @author caoyixiong
 * @Date: 2019/4/12
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class 两数相加II {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0;
        ListNode node1 = l1;
        while (node1 != null) {
            len1++;
            node1 = node1.next;
        }
        ListNode node2 = l2;
        int len2 = 0;
        while (node2 != null) {
            len2++;
            node2 = node2.next;
        }

        ListNode longNode = len1 > len2 ? l1 : l2;
        ListNode shortNode = len1 <= len2 ? l1 : l2;

        ListNode longNode1 = longNode;
        int gap = Math.abs(len1 - len2);
        while (gap > 0 && longNode1 != null) {
            gap--;
            longNode1 = longNode1.next;
        }

        ListNode node3 = longNode1;
        ListNode node4 = shortNode;

        while (node3 != null && node4 != null) {
            node3.val = node3.val + node4.val;
            node3 = node3.next;
            node4 = node4.next;
        }

        int val = format(longNode);

        if (val != 0) {
            ListNode node = new ListNode(val);
            node.next = longNode;
            return node;
        }
        return longNode;
    }

    private static int format(ListNode node) {
        if (node.next == null) {
            int val = node.val;
            node.val = val % 10;
            return val / 10;
        }

        int value = format(node.next);
        int nodeVal = node.val + value;
        node.val = nodeVal % 10;
        return nodeVal / 10;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(9);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);

        ListNode listNode4 = new ListNode(8);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

//        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode7 = addTwoNumbers(listNode, listNode4);
        ListNode.println(listNode7);
    }
}
