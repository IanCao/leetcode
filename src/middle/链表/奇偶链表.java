package middle.链表;

import java.util.List;

/**
 * @author caoyixiong
 * @Date: 2019/4/11
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class 奇偶链表 {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddNode = head, oddStart = head;
        ListNode evenNode = head.next, evenStart = head.next;
        ListNode start = head.next.next;
        oddNode.next = null;
        evenNode.next = null;
        int i = 1;
        while (start != null) {
            if (i % 2 == 1) {
                oddStart.next = start;
                oddStart = oddStart.next;
            } else {
                evenStart.next = start;
                evenStart = evenStart.next;
            }
            ListNode temp = start.next;
            start.next = null;
            start = temp;
            i++;
        }
        oddStart.next = evenNode;
        return oddNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(7);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        oddEvenList(listNode);
    }
}
