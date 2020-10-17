package com.wzx.beauty;

import java.util.Arrays;

public class Beauty0407 {
    public static void main(String[] args) {
        int length = 27;
        int[] antPos = {3,7,11,17,23};
        System.out.println("min-max:" + Arrays.toString(calTime(length, antPos)));
    }

    public static int[] calTime(int length, int[] antPos) {
        // min time, max time
        int[] times = {0, 0};

        int currentMin;
        int currentMax;

        for (int antPo : antPos) {
            if (antPo < (length >> 1)) {         // left part
                currentMax = length - antPo;
            } else {
                currentMax = antPo;               // right part
            }

            currentMin = length - currentMax;         // reverse

            if (times[1] < currentMax) {
                times[1] = currentMax;
            }
            if (times[0] < currentMin) {
                times[0] = currentMin;
            }
        }
        return times;
    }
}
