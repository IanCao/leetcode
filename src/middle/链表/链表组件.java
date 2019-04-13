package middle.链表;

/**
 * @author caoyixiong
 * @Date: 2019/4/13
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 给定一个链表（链表结点包含一个整型值）的头结点 head。
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 * <p>
 * 输入:head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 */
public class 链表组件 {
    public static int numComponents(ListNode head, int[] G) {
        int max = G[0];
        for (int i = 0; i < G.length; i++) {
            max = Math.max(max, G[i]);
        }
        int[] hash = new int[max + 1];
        for (int i = 0; i < G.length; i++) {
            hash[G[i]] = 1;
        }
        int sum = 0;
        int size = 0;
        while (head != null) {
            int val = head.val;
            if (val <= max && hash[val] == 1) { //说明存在
                size++;
                head = head.next;
                continue;
            }
            if (size != 0) {
                sum++;
                size = 0;
            }
            head = head.next;
        }
        if (size != 0) {
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(6);
//        ListNode listNode6 = new ListNode(7);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        System.out.println(numComponents(listNode, new int[]{0, 1, 3}));
    }
}
