package com.jxz.sort;

public class CountSort extends Sort<Integer> {
    @Override
    protected void sort() {
        // 找到数组中最大的元素
        Integer max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        // 开辟内存空间，存储每个整数出现的次数
        int[] counts = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }

        // 根据整数出现的次数，对整数进行排序
        int arrayIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                array[arrayIndex] = i;
                arrayIndex++;
                counts[i]--;
            }
        }
    }
}
