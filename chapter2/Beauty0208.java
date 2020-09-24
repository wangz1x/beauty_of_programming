package com.wzx.beauty;

import java.util.Arrays;

/**
 * given N
 * find M
 * then M * N only consist of '0' and '1'
 */
public class Beauty0208 {
    public static void main(String[] args) {
//        int i = 0;
//        i = i++;
//        System.out.println(i);
//        int a = 0;
//        while (a < 5) {
//            switch (a) {
//                case 0:
//                case 3:a=a+2;
//                case 1:
//                case 2:a=a+3;
//                default:a=a+5;
//            }
//        }
//        System.out.println(a);
        System.out.println(findM(9));
    }

    public static int findM(int N) {
        // keep the minimum of each remainder (1~N-1)
        int[] remainders = new int[N];
        boolean isChange = false;
        remainders[1] = 1;
        int start = 1;
        for (int i = 1; ; i++) {
            // binary form
//            start = Integer.parseInt(Integer.toBinaryString(1<<i));
            System.out.println("i=" + i);
            System.out.println(Arrays.toString(remainders));
            start *= 10;
            int remainder1 = start % N;
            int remainder2 = 0;

            if (remainders[remainder1] == 0 || start < remainders[remainder1]) {
                remainders[remainder1] = start;
                isChange = true;
            }

            // loop remainder
            for (int j = 1; j < N; j++) {
                if (remainders[j] != 0 && remainders[j] < start) {
                    remainder2 = (remainder1 + remainders[j]) % N;
                    if (remainders[remainder2] == 0 || start + remainders[j] < remainders[remainder2]) {
                        remainders[remainder2] = start + remainders[j];
                        isChange = true;
                    }
                }
            }

//            for (int j = start; j <= end; j ++) {
//                int decimal = Integer.parseInt(Integer.toBinaryString(j));
//                int remainder = decimal % N;
//                if (remainders[remainder] == 0 || decimal < remainders[remainder]) {
//                    remainders[remainder] = decimal;
//                    // if no change during the loop, then there is no M
//                    isChange = true;
//                }
//            }
            if (remainders[0] != 0) {
                break;
            }

            if (isChange) {
                isChange = false;
            } else {
                break;
            }
        }
        return remainders[0];
    }
}
