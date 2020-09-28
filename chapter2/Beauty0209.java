package com.wzx.beauty;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Fibonacci
 */
public class Beauty0209 {
    public static void main(String[] args) {
        int n = 4000000;
        long l1 = System.currentTimeMillis();
        System.out.println(fibonacci2(n));
        System.out.println("fibonacci2: " + (System.currentTimeMillis()-l1));
        long l2 = System.currentTimeMillis();
        System.out.println(fibonacci1(n));
        System.out.println("fibonacci1: " + (System.currentTimeMillis()-l2));


//        long l = System.currentTimeMillis();
//        System.out.println(fibonacci0(n));
//        System.out.println("fibonacci0: " + (System.currentTimeMillis()-l));


    }

    /**
     * O(2^n)
     */
    public static BigInteger fibonacci0(int n) {
        if (n == 1 || n == 2) {
            return BigInteger.valueOf(1);
        }
        return fibonacci0(n-1).add(fibonacci0(n-2));
    }

    /**
     * O(n)
     * return N-th number in Fibonacci
     *
     * @param N N-th
     * @return number
     */
    public static BigInteger fibonacci1(int N) {
        if (N == 1 || N == 2) {
            return BigInteger.valueOf(1);
        }

        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(0);

        for (int i = 2; i < N; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * O(log2(n))
     * @return (Fn, Fn - 1) = (F2, F1)*A^n-1
     */
    public static BigInteger fibonacci2(int n) {
        n=n-1;
        int times = (int) Math.ceil(Math.log(n) / Math.log(2));
        BigInteger[][] temp = {{BigInteger.valueOf(1), BigInteger.valueOf(1)}, {BigInteger.valueOf(1), BigInteger.valueOf(0)}};
        BigInteger[][] res = {{BigInteger.valueOf(1), BigInteger.valueOf(0)}, {BigInteger.valueOf(0), BigInteger.valueOf(1)}};
        for (int i = 0; i < times; i++) {
            if (((n>>i)&1) == 1) {
                // res *= temp
                BigInteger a = temp[0][0].multiply(res[0][0]).add(temp[0][1].multiply(res[1][0]));
                BigInteger b = temp[0][0].multiply(res[0][1]).add(temp[0][1].multiply(res[1][1]));
                BigInteger c = temp[1][0].multiply(res[0][0]).add(temp[1][1].multiply(res[1][0]));
                BigInteger d = temp[1][0].multiply(res[0][1]).add(temp[1][1].multiply(res[1][1]));
                res[0][0] = a;
                res[0][1] = b;
                res[1][0] = c;
                res[1][1] = d;
            }
            // double temp
            BigInteger a = temp[0][0].multiply(temp[0][0]).add(temp[0][1].multiply(temp[1][0]));
            BigInteger b = temp[0][0].multiply(temp[0][1]).add(temp[0][1].multiply(temp[1][1]));
            BigInteger c = temp[1][0].multiply(temp[0][0]).add(temp[1][1].multiply(temp[1][0]));
            BigInteger d = temp[1][0].multiply(temp[0][1]).add(temp[1][1].multiply(temp[1][1]));
            temp[0][0] = a;
            temp[0][1] = b;
            temp[1][0] = c;
            temp[1][1] = d;
        }
        return res[0][0];
    }
}
