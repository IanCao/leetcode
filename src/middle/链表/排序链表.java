package middle.链表;

/**
 * @author caoyixiong
 * @Date: 2018/10/25
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */

/**
 * 题目：在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 参考：Sort List——经典（链表中的归并排序） https://www.cnblogs.com/qiaozhoulin/p/4585401.html
 * <p>
 * 归并排序法：在动手之前一直觉得空间复杂度为常量不太可能，因为原来使用归并时，都是 O(N)的，
 * 需要复制出相等的空间来进行赋值归并。对于链表，实际上是可以实现常数空间占用的（链表的归并
 * 排序不需要额外的空间）。利用归并的思想，递归地将当前链表分为两段，然后merge，分两段的方
 * 法是使用 fast-slow 法，用两个指针，一个每次走两步，一个走一步，知道快的走到了末尾，然后
 * 慢的所在位置就是中间位置，这样就分成了两段。merge时，把两段头部节点值比较，用一个 p 指向
 * 较小的，且记录第一个节点，然后 两段的头一步一步向后走，p也一直向后走，总是指向较小节点，
 * 直至其中一个头为NULL，处理剩下的元素。最后返回记录的头即可。
 */
public class 排序链表 {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head, after = head, cur = null;
        while (pre != null && pre.next != null) {
            cur = after;
            after = after.next;
            pre = pre.next.next;
        }
        cur.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(after);
        return merge(l, r);
    }

    private static ListNode merge(ListNode l, ListNode r) {
        ListNode root = new ListNode(0);
        ListNode node = root;
        while (l != null && r != null) {
            if (l.val > r.val) {
                node.next = r;
                r = r.next;
                node = node.next;
            } else {
                node.next = l;
                l = l.next;
                node = node.next;
            }
        }

        if (l != null) {
            node.next = l;
        }

        if (r != null) {
            node.next = r;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode result = sortList(listNode);

        System.out.println();

    }
}
