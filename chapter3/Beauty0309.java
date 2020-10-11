package com.wzx.beauty;

/**
 * construct a binary tree according to pre-order and mid-order sequence
 */
public class Beauty0309 {
    public static void main(String[] args) {

        String preOrder = "abdc";
        String midOrder = "dbac";
        System.out.println(constructTree(preOrder, midOrder, 0, preOrder.length()-1, 0, midOrder.length()-1));
    }

    public static Node constructTree(String preOrder, String midOrder, int preBegin, int preEnd, int midBegin, int midEnd) {
        Node root = null;
        if (preEnd - preBegin >= 0) {
            char mid = preOrder.charAt(preBegin);
            root = new Node(mid);
            int index = midOrder.indexOf(mid);
            if (index - midBegin > 0) {
                root.left = constructTree(preOrder, midOrder, preBegin+1, preBegin+index-midBegin, midBegin, index-1);
            }
            else
                root.left = null;
            if (midEnd - index > 0) {
                root.right = constructTree(preOrder, midOrder, preBegin+index-midBegin+1, preEnd, index+1, midEnd);
            }
            else
                root.right = null;
        }
        return root;
    }

    static class Node {
        char val;         // save element in array
        Node left;
        Node right;

        public Node(char val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
