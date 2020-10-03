package com.wzx.beauty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Beauty0221 {
    public static void main(String[] args) {
        System.out.println(calculateNQuickly(694575).size());
    }

    public static List<List<Integer>> calculateNQuickly(int N) {
        List<List<Integer>> res = new ArrayList<>();
        int maxLoop = (int) Math.sqrt(2 * N);
        for (int i = 2; i < maxLoop; i++) {
            // even
            if ((i & 1) == 0) {
                // N = (2*m+1)*(i>>2)
                if ((N / (i >> 1) & 1) == 1 && (N / (i >> 1)) * (i >> 1) == N) {
                    int m = (N / (i >> 1) - 1) >> 2;
                    int start = m - (i >> 1) + 1;
                    int end = m + (i >> 1);
                    res.add(Arrays.asList(start, end));
                }
            }
            // odd
            else {
                // N = i*m
                if ((N / i) * i == N) {
                    int m = N / i;
                    int start = m - (i >> 1);
                    int end = m + (i >> 1);
                    res.add(Arrays.asList(start, end));
                }
            }
        }
        return res;
    }
}
