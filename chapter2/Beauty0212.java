package com.wzx.beauty;

import java.util.*;

public class Beauty0212 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,54,0};
        System.out.println(sumOfTwoNumbers(arr, 9));
    }

    public static List<List<Integer>> sumOfTwoNumbers(int[] numbers, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int remainder = sum-numbers[i];
            if (map.containsKey(remainder)) {
                res.add(Arrays.asList(i, map.get(remainder)));
            }
            else {
                map.put(numbers[i], i);
            }
        }
        return res;
    }
}
