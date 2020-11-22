package com.jxz.sort;

public class BinarySearch {
    /**
     * 查找v在有序数组array中的位置
     * @param array
     * @param v
     * @return
     */
    public static int indexOf (int[] array, int v) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (array[mid] > v) {
                begin = mid + 1;
            } else if (array[mid] < v){
                end = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 查找v在有序数组array中待插入的位置
     * @param array
     * @param v
     * @return
     */
    public static int search (int[] array, int v) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (v < array[mid]) {
                end = mid;
            }else if (v >= array[mid]) {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
