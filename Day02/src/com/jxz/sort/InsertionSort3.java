package com.jxz.sort;

public class InsertionSort3<E extends Comparable<E>> extends Sort<E>  {

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            E v = array[begin];
            int insertIndex = search(begin);
            // 从[insertIndex,begin) 这个范围开始挪动元素
//            for (int removeEnd = begin - 1; removeEnd >= insertIndex; removeEnd--) {
//                array[removeEnd + 1] = array[removeEnd];
//            }
            for (int removeEnd = begin; removeEnd > insertIndex; removeEnd--) {
                array[removeEnd] = array[removeEnd - 1];
            }

            array[insertIndex] = v;
        }
    }

    private int search (int index) {
        E v = array[index];
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (cmp(v,array[mid]) < 0) {
                end = mid;
            }else if (cmp(v,array[mid]) >= 0) {
                begin = mid + 1;
            }
        }
        return begin;
    }

}
