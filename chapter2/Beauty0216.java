package com.wzx.beauty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Beauty0216 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, -10, -9, -8, 7, -6, -5, -4, -3, -2, -1 ,0};
//        int[] arr = {1, 2, 3, 4, 5, 6, -7, 8, 10, 2, 1, -54, 100};
//        findAscend(arr);
        findAscendQuickly(arr);
    }


    public static void findAscend(int[] numbers) {
        int[] list = new int[numbers.length];
        list[0] = 1;
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    list[i] = Math.max(list[i], list[j] + 1);
                }
            }
            list[i] = Math.max(1, list[i]);
        }
        System.out.println(Arrays.toString(list));
    }

    public static void findAscendQuickly(int[] numbers) {
        // save the length of sequence
        int[] list = new int[numbers.length];
        Arrays.fill(list, 1);
        // save the last element of each length sequence
        List<Integer> res = new ArrayList<>();
        res.add(0x80000000);
        res.add(numbers[0]);
        int maxLength = 1;

        for (int i = 1; i < numbers.length; i++) {

            int j;
            for (j = maxLength; j >= 0 ; j--) {
                if (numbers[i] > res.get(j)) {
                    list[i] = j+1;
                    break;
                }
            }

            if (list[i] > maxLength) {
                maxLength = list[i];
                res.add(numbers[i]);
            }
            // a, b, j, i, c, d, e ...
            else if (res.get(j) < numbers[i] && numbers[i] < res.get(j+1)){
                res.set(j+1, numbers[i]);
            }
        }
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.toString(res.toArray()));
    }
}
