package com.wzx.beauty;

public class Beauty0214 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, -7, 8, 10, 2, 1, -54, 100};
        System.out.println(maxSum(arr));
    }

    public static int maxSum(int[] numbers) {
        int sum = 0;
        int begin = -1;
        int end = -1;
        int max = 0x80000000;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (sum > max) {
                max = sum;
                if (begin == -1) {
                    begin = i;
                }
                end = i;
            } else if (sum < 0) {
                System.out.println("begin: " + begin + " end: " + end);
                sum = 0;
                begin = end = -1;
            }
        }
        System.out.println("begin: " + begin + " end: " + end);
        return max;
    }
}
