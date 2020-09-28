package com.wzx.beauty;

import java.util.Arrays;

public class Beauty0213 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, -7, 8, 10, 2, 1, -54, 0};
        System.out.println(maxMultiply(arr));
        System.out.println(scanNumbers(arr));
    }

    /**
     * remove one number, and the product of remains max
     *
     * @param numbers numbers
     * @return index of the removed number
     */
    public static int maxMultiply(int[] numbers) {
        int index = -1;
        int[] pre = new int[numbers.length];
        int[] suf = new int[numbers.length];
        pre[0] = 1;
        suf[numbers.length - 1] = 1;
        for (int i = 1, j = numbers.length - 2; i < numbers.length; i++, j--) {
            pre[i] = numbers[i - 1] * pre[i - 1];
            suf[j] = numbers[j + 1] * suf[j + 1];
        }
        System.out.println("pre: " + Arrays.toString(pre));
        System.out.println("suf: " + Arrays.toString(suf));
        int max = 0x80000000;
        for (int i = 0; i < numbers.length; i++) {
            if (pre[i] * suf[i] > max) {
                max = pre[i] * suf[i];
                index = i;
            }
        }
//        System.out.println("max: " + max);
        return index;
    }

    public static int scanNumbers(int[] numbers) {
        int res = 0;
        int count_0 = 0;
        int count_neg = 0;
        int index_0 = -1;
        int min = 0x7fffffff;
        int index_min_pos = -1;
        int max = 0x80000000;
        int index_max_neg = -1;
        int product = 1;

        for (int i = 0; i < numbers.length; i++) {
            product *= numbers[i];
            if (numbers[i] == 0) {
                count_0++;
                index_0 = i;
            } else if (numbers[i] > 0) {
                if (numbers[i] < min) {
                    min = numbers[i];
                    index_min_pos = i;
                }
            } else {
                count_neg++;
                if (numbers[i] > max) {
                    max = numbers[i];
                    index_max_neg = i;
                }
            }
        }
        if (product == 0 && count_0 == 1) {
            if ((count_neg & 1) == 1) {
                res = (index_0 + 1) % numbers.length;
            } else {
                res = index_0;
            }
        } else if (product > 0) {
            if ((count_neg & 1) == 1) {
                res = index_max_neg;
            } else {
                res = index_min_pos;
            }
        } else {
            res = index_max_neg;
        }
        return res;
    }
}
