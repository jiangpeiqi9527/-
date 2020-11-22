package com.jxz.sort;

import java.util.List;

public class ShellSort {
    // 交换式
    public static void sort1(int[] arr) {
        // gap 表示步长，当gap等于1时，1/2 = 0，退出循环
        for (int gap = arr.length/2;gap > 0;gap /= 2) {
            // 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
            for (int i = gap ; i < arr.length;i++) {
                for (int j = i - gap;j >= 0;j -= gap) {
                    if (arr[j] > arr[j + 5]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 5];
                        arr[j + 5] = temp;

                    }
                }
            }
        }
    }

    private List<Integer> shellStepSequence () {
        return null;
    }


    // 移动式
    public static void sort2(int[] arr) {

    }
}
