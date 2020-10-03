package com.wzx.beauty;

import com.wzx.algorithm.Kmp;

public class Beauty0301 {
    public static void main(String[] args) {
        String s1 = "aabcd";
        String s2 = "cdaa";
        System.out.println(isMatch(s1, s2));
    }

    public static boolean isMatch(String s1, String s2) {
        return Kmp.match(s1+s1, s2);
    }
}
