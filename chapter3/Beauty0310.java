package com.wzx.beauty;

import java.util.ArrayList;
import java.util.List;

public class Beauty0310 {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(4, new Node(8, null, null), null), new Node(5, null, null)), new Node(3, new Node(6, null, new Node(9, null, null)), new Node(7, null, null)));
        visitTree(head);
    }

    public static void visitTree(Node root) {
        List<Node> visited = new ArrayList<>();
        int cursor = 0;
        visited.add(root);
        int end = 0;
        while (cursor <= end) {
            Node temp = visited.get(cursor);
            System.out.print(temp.val + " ");
            if (temp.left != null)
                visited.add(temp.left);
            if (temp.right != null)
                visited.add(temp.right);

            if (cursor == end) {
                System.out.println();
                if (visited.size()-1>=end) {
                    end = visited.size()-1;
                }
                else
                    break;
            }
            cursor ++;
        }
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
