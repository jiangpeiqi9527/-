package com.jxz.sort;

public class InsertSort {
    public static void sort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1;i < arr.length;i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }
}
