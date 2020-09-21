package com.wzx.beauty;

/**
 * calculate the number of "1" in the binary.
 */
public class Beauty0201 {

    public static void main(String[] args) {
        Beauty0201 beauty0201 = new Beauty0201();
        System.out.println(beauty0201.calculateOnes3(1234));
    }

    public int calculateOnes1(int number) {
        String s = Integer.toBinaryString(number);
        System.out.println(s);
        int count = 0;
        while (number != 0) {
            if ((number & 1) == 1) {
                count++;
            }
            number >>= 1;
        }
        return count;
    }

    public int calculateOnes2(int number) {
        String s = Integer.toBinaryString(number);
        System.out.println(s);
        int res = 0;
        while (number != 0) {
            number &= number-1;
            res ++;
        }
        return res;
    }

    public int calculateOnes3(int number) {
        String s = Integer.toBinaryString(number);
        System.out.println(s);
        int res = 0;
        number -= number>>1 & 0x55555555;
        // since two bit can't represent 4 "1"
        number = (number & 0x33333333) + ((number >>> 2) & 0x33333333);
        // four bit can represent 4 bit one
        number = (number  +  (number >>> 4)) & 0x0f0f0f0f;
        number = number + (number >>> 8);
        number = number + (number >>> 16);
        // a int, most 32 "1", only keep low 6 bit.
        return number & 0x3f;
    }

}
