package com.jxz.sort;

public class SelectSort {
    public static void sort(int[] arr) {
        int minIndex = 0;
        int minVal = 0;
        for (int i = 0;i < arr.length - 1;i++) {
            minIndex = i;
            minVal = arr[i];
            for (int j = i + 1;j < arr.length;j++) {
                if (minVal > arr[j]) {
                    minVal = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = minVal;
        }
    }
}
