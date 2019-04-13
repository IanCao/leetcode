package middle.链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author caoyixiong
 * @Date: 2019/4/13
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 *
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，
 * 那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 *
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 *
 */
public class 链表中的下一个更大节点 {

    public static int[] nextLargerNodes(ListNode head) {
        List<ListNode> listNodeList = new ArrayList<>();
        while (head != null){
            listNodeList.add(head);
            head = head.next;
        }
        int[] res = new int[listNodeList.size()];
        Stack<ListNode> stack = new Stack<>();
        for (int i = listNodeList.size() - 1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek().val <= listNodeList.get(i).val){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek().val;
            stack.push(listNodeList.get(i));
        }
        return res;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(7);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(6);
//        ListNode listNode6 = new ListNode(7);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;

       nextLargerNodes(listNode);

    }
}
