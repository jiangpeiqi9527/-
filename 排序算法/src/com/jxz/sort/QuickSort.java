package com.jxz.sort;

import java.util.logging.Level;

public class QuickSort {
    private int[] array;
    public void sort (int[] array) {
        this.array = array;
        sort(0,array.length);
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) return;
        int mid = pivotIndex(begin,end);
        sort(begin,mid);
        sort(mid + 1,end);
    }

    private int pivotIndex(int begin, int end) {
        int pivotElement = array[begin];
        end--;
        while (begin < end) {
            // <-
            while (begin < end) {
                if (pivotElement < array[end]) {
                    end--;
                }else {
                    array[begin++] = array[end];
                    break;
                }
            }
            // ->
            while (begin < end) {
                if (pivotElement > array[begin]) {
                    begin++;
                } else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }
        array[begin] = pivotElement;
        return begin;
    }
}
