package DataStructre;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author caoyixiong
 * @Date: 2019/1/9
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 二叉树的前中后序遍历 {
    public static void main(String[] args) {
        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        root.leftChild = node1;
        root.rightChild = node2;

        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.leftChild = node3;
        node1.rightChild = node4;
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node3.leftChild = node5;
        node4.rightChild = node6;

        System.out.println("----前序遍历---");
        preTraversal(root);
        System.out.println();
        System.out.println("----中序遍历---");
        midTraversal(root);
        System.out.println();
        System.out.println("----后序遍历---");
        afterTraversal(root);
        System.out.println();
        System.out.println("----层序遍历---");
        breadthFirstTraversal(root);
        System.out.println();
    }

    //前序遍历
    private static void preTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.value + " ");
                stack.push(node);
                node = node.leftChild;
            }
            node = stack.pop();
            node = node.rightChild;
        }
    }

    //中序遍历
    private static void midTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            node = stack.pop();
            System.out.print(node.value+" ");
            node = node.rightChild;
        }
    }

    //后序遍历
    private static void afterTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        Node lastVisit = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            node = stack.peek();
            if (node.rightChild == null || node.rightChild == lastVisit) {
                System.out.print(node.value + " ");
                lastVisit = stack.pop();
                node = null;
            } else {
                node = node.rightChild;
            }
        }
    }

    //层级遍历
    private static void breadthFirstTraversal(Node node) {
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(node);
        while (!linkedList.isEmpty()) {
            node = linkedList.poll();
            System.out.print(node.value+" ");
            if (node.leftChild != null) {
                linkedList.add(node.leftChild);
            }
            if (node.rightChild != null) {
                linkedList.add(node.rightChild);
            }
        }
    }


    static class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }
}
