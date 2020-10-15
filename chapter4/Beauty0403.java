package com.wzx.beauty;

import java.util.ArrayList;
import java.util.List;

public class Beauty0403 {

    static int n = 2;
    static ArrayList<String>[] caches = new ArrayList[2*n];
    public static void main(String[] args) {
        caches[0] = new ArrayList<>();
        caches[0].add("");
        List<String> generate = generate(n);
        System.out.println(generate);
    }

    public static List<String> generate(int n) {
        if (caches[n] != null) {
            return caches[n];
        }
        caches[n] = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= n-1; i ++) {
            for (String sf : generate(i)) {
                for (String ss : generate(n-i-1)) {
                    ans.add("(" + sf + ")" + ss);
                }
            }
        }
        caches[n] = ans;
        return ans;
    }
}
