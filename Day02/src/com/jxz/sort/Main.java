package com.jxz.sort;

import com.jxz.sort.tools.Integers;
import com.jxz.sort.tools.Times;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        Integer[] array1 = Integers.random(10000,1,20000);
//        Integer[] array2 = Integers.copy(array1);
//        Integer[] array3 = Integers.copy(array1);
//        Times.test("HeapSort",() -> {
//            new HeapSort().sort(array1);
//        });
//        Times.test("SelectSort",() -> {
//            new SelectSort().sort(array2);
//        });
//        Times.test("BubbleSort",() -> {
//            new BubbleSort_3().sort(array3);
//        });
        Integer[] array = Integers.random(10000, 1, 20000);
        testSort(array,
                new SelectSort(),
                new BubbleSort_3(),
                new HeapSort(),
                new InsertionSort3(),
                new CountSort(),
                new QuickSort());
    }

    static void testSort(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            sort.sort(Integers.copy(array));
        }
        Arrays.sort(sorts, new Comparator<Sort>() {
            @Override
            public int compare(Sort o1, Sort o2) {
                return (int) (o1.getTime() - o2.getTime());
            }
        });
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }
}
