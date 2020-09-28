package com.wzx.beauty;

import java.util.Arrays;

public class Beauty0210 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,10,2,1,54,0};
        System.out.println(Arrays.toString(findMaxAndMin(arr)));
    }

    public static int[] findMaxAndMin(int[] numbers) {
        int min = 0x7fffffff;
        int max = 0x80000000;

        for (int i = 0; i < numbers.length-1; i+=2) {
            if (numbers[i] > numbers[i+1]) {
                max = Math.max(max, numbers[i]);
                min = Math.min(min, numbers[i+1]);
            }
            else {
                max = Math.max(max, numbers[i+1]);
                min = Math.min(min, numbers[i]);
            }
        }
        // odd
        if ((numbers.length & 1) == 1) {
            max = Math.max(max, numbers[numbers.length-1]);
            min = Math.min(min, numbers[numbers.length-1]);
        }

        return new int[] {max, min};
    }
}
