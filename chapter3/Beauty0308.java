package com.wzx.beauty;

/**
 * left subtree height + right subtree height
 */
public class Beauty0308 {

    static int max = -1;

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(4, new Node(8, null, null), null), new Node(5, null, null)), new Node(3, new Node(6, null, null), new Node(7, null, null)));
        System.out.println(maxDistance(head, 0));
        System.out.println(max);
    }

    public static int maxDistance(Node head, int deep) {
        if (head == null) {
            return deep-1;
        }
        int leftDeep = maxDistance(head.left, deep+1);
        int rightDeep = maxDistance(head.right, deep+1);
        if (max < leftDeep- deep +rightDeep- deep) {
            max = leftDeep- deep +rightDeep- deep;
        }
        return Math.max(leftDeep, rightDeep);
    }

    static class Node {
        int val;         // save element in array
        Node left;
        Node right;
        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
