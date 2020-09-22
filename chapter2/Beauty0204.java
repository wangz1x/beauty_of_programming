package com.wzx.beauty;

/**
 * calculate the number of "1" during 1~n
 */
public class Beauty0204 {
    public static void main(String[] args) {
        Beauty0204 beauty0204 = new Beauty0204();
        System.out.println(beauty0204.numberOfOnes(93));
    }

    public int numberOfOnes(int number) {
        int res = 0;
        // for position, we have to get the previous and later position
        int unit = 1;
        int later = 0;
        int previous = -1;
        int middle = 0;

        // "1" in units
        while (previous != 0) {
            later = number % unit;
            System.out.println("later: " + later);

            previous = number / (unit*10);
            System.out.println("previous: " + previous);

            middle = number/unit%10;
            System.out.println("middle: " + middle);

            res += previous*unit + (middle == 0? 0 : middle == 1 ? (later+1) : unit);
            unit *= 10;
        }
        return res;
    }
}
