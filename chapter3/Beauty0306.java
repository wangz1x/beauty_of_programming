package com.wzx.beauty;

public class Beauty0306 {
    public static void main(String[] args) {
        Node head1 = new Node();
        Node head2 = new Node();
        Node head11 = new Node();
        Node head12 = new Node();
        Node head13 = new Node();
        Node head14 = new Node();
        Node head21 = new Node();
        Node head22 = new Node();
        Node head3 = new Node();

        head1.next = head11;
        head11.next = head12;
        head12.next = head13;
        head13.next = head14;

        head2.next=head21;
        head21.next = head22;

        head22.next = head3;

        System.out.println(isCrossover(head1, head2));
    }

    // first node the crossover
    public static boolean isCrossover(Node list1, Node list2) {
        int len1 = 0;
        int len2 = 0;
        boolean res = false;
        Node head1 = list1;
        Node head2 = list2;
        while (head1 != null) {
            len1 ++;
            head1 = head1.next;
        }

        while (head2 != null) {
            len2 ++;
            head2 = head2.next;
        }

        head1 = list1;
        head2 = list2;
        int distance = 0;
        if (len1 > len2) {
            distance = len1 - len2;
            while (distance > 0) {
                head1 = head1.next;
                distance --;
            }
        }
        if (len2 > len1) {
            distance = len2 - len1;
            while (distance > 0) {
                head2 = head2.next;
                distance --;
            }
        }
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                res = true;
                break;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return res;
    }
    static class Node {
        Node next;
    }

}


