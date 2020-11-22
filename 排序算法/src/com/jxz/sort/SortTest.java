package com.jxz.sort;

import org.junit.Test;

import java.util.Arrays;

public class SortTest {
    @Test
    public void test01 ( ) {
        int[] arr = {5,4,9,2,7,11,35,1};
        new QuickSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
