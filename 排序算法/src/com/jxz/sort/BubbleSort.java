package com.jxz.sort;

public class BubbleSort {
    public static void sort (int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1;i++) {
            for (int j = 0;j < arr.length - 1 - i;j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
            flag = false;
        }
    }
}
