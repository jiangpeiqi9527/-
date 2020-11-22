package com.jxz.sort;

public class InsertionSort1<E extends Comparable<E>> extends Sort<E>  {

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            while (cur > 0 && cmp(begin - 1,begin) > 0) {
                swap(begin - 1,begin);
                cur--;
            }
        }
    }

}
