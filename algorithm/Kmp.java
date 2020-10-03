package com.wzx.algorithm;

import java.util.Arrays;

public class Kmp {

    public static void main(String[] args) {
        String p = "ababa";
        String s = "ababcababaca";
        System.out.println(match(s, p));
    }

    public static int[] calculateNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int tempIndex = 1;
        int compareIndex = next[0];
        while (tempIndex < pattern.length()) {
//            compareIndex = next[tempIndex-1];
            if (pattern.charAt(tempIndex) == pattern.charAt(compareIndex + 1)) {
                next[tempIndex] = compareIndex + 1;
                compareIndex = next[tempIndex];
                tempIndex++;
            } else if (compareIndex != -1) {
                compareIndex = next[compareIndex];
            } else {
                next[tempIndex] = -1;
                compareIndex = -1;
                tempIndex++;
            }
        }

        for (int i = 0; i < next.length; i++) {
            if (next[i] >= 0) {
                if (pattern.charAt(i) == pattern.charAt(next[i])) {
                    next[i] = next[next[i]];
                }
            }
        }
        return next;
    }

    public static boolean match(String source, String pattern) {
        // not decrease
        int s_point = 0;
        // up and down
        int p_point = 0;
        int[] next = calculateNext(pattern);
        System.out.println("next: " + Arrays.toString(next));
        int compareTime = 0;

        while (s_point < source.length() && p_point < next.length) {
            compareTime ++;
            if (source.charAt(s_point) == pattern.charAt(p_point)) {
                s_point++;
                p_point++;
            } else if (p_point == 0) {
                s_point++;
            } else {
                p_point = next[p_point - 1] + 1;
            }
        }
        System.out.println("compare time: " + compareTime);
        if (p_point >= next.length) {
            System.out.println("match from: " + (s_point - next.length));
            return true;
        } else {
            System.out.println("not match!");
            return false;
        }
    }
}
