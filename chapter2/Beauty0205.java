package com.wzx.beauty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Beauty0205 {
    public static int COUNT=0;

    public static void main(String[] args) {
        int[] array = {5,6,7,8,9,4,4,4,10,11,12,13,14};
        System.out.println(Arrays.toString(array));
        System.out.println(findKthBigChooseMid(array, 0, array.length - 1, 5));
//        System.out.println(findKthBig(array, 0, array.length - 1, 5));
        System.out.println(Arrays.toString(array));
        scanOnce(array, 5);
    }

    public static int findKthBig(int[] array, int start, int end, int k) {
        System.out.println("COUNT: " + (COUNT++));
        int pivot = array[start];
        int i = start + 1;
        int j = end;

        while (i <= j) {
            // find a number less than pivot
            while (i <= end && array[i] >= pivot)
                i++;
            while (j >= start+1 && array[j] <= pivot)
                j--;
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            } else {
                int temp = array[j];
                array[j] = pivot;
                array[start] = temp;
                // the index of boundary
                pivot = j;
            }
        }
        if (pivot - start + 1 == k) {
            return pivot;
        }
        // former part contains more than k element
        else if (pivot - start + 1 > k) {
            return findKthBig(array, start, pivot, k);
        }
        // need find k-pivot th big in latter part
        else {
            return findKthBig(array, pivot + 1, end, k - (pivot - start + 1));
        }
    }

    public static int findKthBigChooseMid(int[] array, int start, int end, int k) {
        int mid = array[(start+end)/2];
        int i = start;
        int j = end;

        while (i <= j) {
            // find a number less than pivot
            while (array[i] > mid)
                i++;
            while (array[j] < mid)
                j--;
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (j - start + 1 == k) {
            return j;
        }
        // former part contains more than k element
        else if (j - start + 1 > k) {
            return findKthBigChooseMid(array, start, j, k);
        }
        // need find k-pivot th big in latter part
        else {
            return findKthBigChooseMid(array, j + 1, end, k - (j - start + 1));
        }
    }

    public static void scanOnce(int[] array, int k) {
        int min = array[0];
        int minIndex = 0;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (res.size() < k) {
                res.add(array[i]);
            }
            else {
                // find min
                if (array[i] > min) {
//                    Integer integer = res.stream().min(Comparator.comparingInt(o -> o)).get();
                    for (int j = 0; j < res.size(); j++) {
                        if (min > res.get(i)) {
                            min = res.get(i);
                            minIndex = i;
                        }
                    }
                    res.set(minIndex, array[i]);
                }
            }
        }
        System.out.println(Arrays.toString(res.toArray()));
    }
}
