package middle;

import java.util.*;

/**
 * @author caoyixiong
 * @Date: 2018/12/20
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 二叉树的最近公共祖先 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, Integer> map = new HashMap<>();
        Map<Integer, TreeNode> map1 = new HashMap<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root != null) {
            int i = 0;
            list.add(root);
            while (!list.isEmpty()) {
                TreeNode node = list.poll();
                map.put(node, i++);
                map1.put(i - 1, node);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
        }
        int pIndex = map.get(p);
        int qIndex = map.get(q);

        int big = pIndex > qIndex ? pIndex : qIndex;
        int small = pIndex > qIndex ? qIndex : pIndex;

        while (big >= 0) {
            big = (big - 1) / 2;
            while (small >= 0) {
                if (small == big) {
                    return map1.get(small);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        root.left = p;
        TreeNode q = new TreeNode(1);
        root.right = q;
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode treeNode = lowestCommonAncestor(root, p, q);
        System.out.println(treeNode.val);
    }
}
