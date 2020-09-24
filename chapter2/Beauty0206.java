package com.wzx.beauty;

import java.util.Arrays;

/**
 * represent a float by fraction
 */
public class Beauty0206 {
    public static void main(String[] args) {
        System.out.println(representByFraction("0.2854(2854)"));
    }

    /**
     * @param number less than one, like 0.12(3) which means 0.123333333333333...
     *               0.12(3) = (12+0.(3))/10^2
     *               Y = 0.(3)
     *               10*Y = 3+Y
     *               Y=3/(10-1)
     * @return a fraction string like "13453/23092"
     */
    public static String representByFraction(String number) {
        String res = "";
        // contains a circulation
        if (number.contains("(")) {
            String[] parts = number.split("\\(");
            System.out.println(Arrays.toString(parts));
            // deal with first part
            String first = parts[0].split("\\.")[1];
            System.out.println(first);
            // deal with second part
            String second = parts[1].replaceAll("\\)", "");
            System.out.println(second);
            int a = (int) (Integer.parseInt(first)*(Math.pow(10, second.length())-1)+Integer.parseInt(second));
            int b = (int) (Math.pow(10, first.length())*(Math.pow(10, second.length())-1));
            int common = 0;
            while ((common=Beauty0207.gcd(a,b)) != 1) {
                a/=common;
                b/=common;
            }
            res = a+"/"+b;
        }
        return res;
    }
}
