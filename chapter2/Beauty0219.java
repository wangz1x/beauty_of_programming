package com.wzx.beauty;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Beauty0219 {
    public static void main(String[] args) {
        int[] target = {1, 6};
        int[][] sources = {{2, 3}, {1, 2}, {3, 9}, {4, 5}, {6, 7}, {6,6}};
        Arrays.sort(sources, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return o1[0] < o2[0] ? -1 : 1;
        });
        for (int[] source : sources) {
            System.out.println(Arrays.toString(source));
        }

    }

    public static boolean overlap(int[] target, int[][] sources) {


        return false;
    }
}
