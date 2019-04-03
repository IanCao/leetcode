package easy;

/**
 * @author caoyixiong
 * @Date: 2018/10/24
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */

/**
 * 题目：请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
        现有一个链表 -- head = [4,5,1,9]，它可以表示为:
        4 -> 5 -> 1 -> 9

    示例 1:

    输入: head = [4,5,1,9], node = 5
    输出: [4,1,9]
    解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

    思路：只给了需要删除的节点，所以操作是将此节点的下一个节点的值复制给此节点，然后将此节点的下一个节点给删除掉
 */
public class 删除链表中的节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
