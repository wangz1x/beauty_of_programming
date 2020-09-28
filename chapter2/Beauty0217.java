package com.wzx.beauty;

import java.util.Arrays;

public class Beauty0217 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,2,7,0,9,8,6,3};
        shiftArray(arr, 4);
        System.out.println(Arrays.toString(arr));
    }

    public static void shiftArray(int[] array, int K) {
        K %= array.length;

        reverse(array, 0, array.length-1-K);
        reverse(array, array.length-K, array.length-1);
        reverse(array, 0, array.length-1);
    }

    public static void reverse(int[] array, int start, int end) {
        for (int i = start; i <= (start+end)/2; i++) {
            int temp = array[i];
            array[i] = array[start+end-i];
            array[start+end-i] = temp;
        }
    }
}
