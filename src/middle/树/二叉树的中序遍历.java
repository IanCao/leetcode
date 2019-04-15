package middle.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author caoyixiong
 * @Date: 2019/4/15
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 */
public class 二叉树的中序遍历 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode treeNode = stack.pop();
            result.add(treeNode.val);
            node = treeNode.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        node.right = node1;
        node1.left = node2;

        inorderTraversal(node);
    }
}
