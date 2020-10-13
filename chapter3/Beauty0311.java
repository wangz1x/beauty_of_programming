package com.wzx.beauty;

public class Beauty0311 {

    public static void main(String[] args) {
        String[] ss = {"a", "abc", "ad", "bc", "bc", "bc"};
        System.out.println(binarySearchString(ss, "bc"));
    }

    public static int binarySearchString(String[] strings, String target) {
        int start = 0;
        int end = strings.length-1;
        int mid = 0;
        while (start < end-1) {
            // priority of ">>" is very low, must use "()", or it calculates start+end-start >> 1  ====> end >> 1
            mid = start + ((end-start)>>1);
            if (strings[mid].compareTo(target) <= 0) {
                start = mid;
            }
            else
                end = mid;
        }
        if (strings[end].equals(target))
            return end;
        else if (strings[start].equals(target))
            return start;
        return -1;
    }
}
