package com.wzx.beauty;

/**
 * Hamming distance
 */
public class Beauty0303 {
    public static void main(String[] args) {
        System.out.println(calculateShortestDistance("abcdefg",  "acbdd"));
    }

    public static int calculateShortestDistance(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        // the former i chars1, change to the former j chars2
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];

        for (int i = 1; i < chars1.length + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < chars2.length + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < chars1.length+1; i++) {

            for (int j = 1; j < chars2.length+1; j++) {
                if (chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }
}
