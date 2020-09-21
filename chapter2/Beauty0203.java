package com.wzx.beauty;

import java.util.Arrays;

/**
 * find the most numbers
 */
public class Beauty0203 {

    public static void main(String[] args) {
        int[] tem = {1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,1,4,5,6};
        Beauty0203 beauty0203 = new Beauty0203();
        System.out.println(Arrays.toString(beauty0203.findThreeMost(tem)));
    }

    public int findMost(int[] numbers) {
        int candidate = -1;
        int count = 0;
        for (int number : numbers
        ) {
            if (count == 0 || number == candidate) {
                candidate = number;
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    /**
     * three id more than 1/4
     *
     * @param numbers
     * @return
     */
    public int[] findThreeMost(int[] numbers) {
        int candidate1 = -1;
        int candidate2 = -1;
        int candidate3 = -1;

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (int number : numbers
        ) {
            if (count1 == 0 || candidate1 == number) {
                candidate1 = number;
                count1 ++;
            }
            else if (count2 == 0 || candidate2 == number) {
                candidate2 = number;
                count2 ++;
            }
            else if (count3 == 0 || candidate3 == number) {
                candidate3 = number;
                count3 ++;
            }
            else {
                count1 --;
                count2 --;
                count3 --;
            }
        }
        return new int[]{candidate1, candidate2, candidate3};
    }
}
