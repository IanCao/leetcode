package middle.链表;

/**
 * @author caoyixiong
 * @Date: 2019/4/3
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void println(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}