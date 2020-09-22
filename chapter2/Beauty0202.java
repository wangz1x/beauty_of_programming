package com.wzx.beauty;

/**
 * deal with n!
 */
public class Beauty0202 {

    public static void main(String[] args) {
        Beauty0202 beauty0202 = new Beauty0202();
        System.out.println(beauty0202.numberOfTrailingZeros(5));
        System.out.println(beauty0202.numberOfTrailingZeros1(5));
    }

    // this if for integer
    public int numberOfTrailingZeros(int n) {
        int res = 0;
        // calculate number of pairs of 2 and 5
        // usually count(5) > count(2)
        // then just return the number of 5 in range of n
        while (n != 0) {
            res += n/5;
            n /= 5;
        }
        return res+1;
    }

    // this is for binary
    public int numberOfTrailingZeros1(int n) {
        int res = 0;
        // for binary, "2" is the same as "10" in decimal
        // just return the number of 2 in range of n
        while (n != 0) {
            res += n/2;
            n /= 2;
        }
        return res;
    }


}
