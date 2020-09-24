package com.wzx.beauty;

/**
 * gcd
 */
public class Beauty0207 {
    public static void main(String[] args) {
        System.out.println(gcd(28540000 ,99990000));
    }

    public static int gcd(int a, int b) {
        System.out.println("a:" + a + " b:" + b);
        if (a == 0 || b == 0) {
            return a+b;
        }
        if (isEven(a)) {
            if (isEven(b)) {
                return 2 * gcd(a >> 1, b >> 1);
            } else {
                return gcd(a >> 1, b);
            }
        } else {
            if (isEven(b)) {
                return gcd(a, b >> 1);
            } else {
                return a > b ? gcd(a - b, b) : gcd(a, b - a);
            }
        }
    }

    // if the number is even
    public static boolean isEven(int a) {
        return !((a & 1) == 1);
    }
}
