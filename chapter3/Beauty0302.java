package com.wzx.beauty;

import java.util.ArrayList;
import java.util.List;

public class Beauty0302 {

    public static String[] dict = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXZY"};

    public static void main(String[] args) {
        int[] numbers = {7, 4, 8};  // "PQRS",  "GHI",  "TUV"
        List<Character> res = new ArrayList<>();
        new Beauty0302().printChar(0, numbers, res);
    }

    public void printChar(int deep, int[] numbers, List<Character> res) {
        if (deep < numbers.length) {
            for (int i = 0; i < dict[numbers[deep] - 2].length(); i++) {
                res.add(dict[numbers[deep]-2].charAt(i));
                printChar(deep + 1, numbers, res);
                res.remove(deep);
            }
        } else {
            System.out.println(res);
        }
    }
}
