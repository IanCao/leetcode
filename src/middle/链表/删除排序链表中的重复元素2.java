package middle.链表;

/**
 * @author caoyixiong
 * @Date: 2019/4/3
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 题目： 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 */
public class 删除排序链表中的重复元素2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode node = root;
        while (node.next != null) {
            ListNode temp = node.next;
            int val = temp.val;

            boolean flag = false;
            while (temp.next != null) {
                if (temp.next.val == val) {
                    flag = true;
                    temp = temp.next;
                    continue;
                }
                break;
            }
            if (flag) {
                node.next = temp.next;
            } else {
                node = node.next;
            }
        }
        return root.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new  ListNode(1);
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

        ListNode result = deleteDuplicates(listNode);
        println(result);
    }

    private static void println(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
