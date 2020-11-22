package com.jxz.稀疏数组sparsearray;

import org.junit.Test;

public class Test01 {
    @Test
    public void method1 () {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        int[][] res = SparseArrayUtils.toSparseArray(arr);
        for (int i = 0;i < res.length;i++) {
            for (int j = 0; j < 3;j++) {
                System.out.print(res[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("-----------");
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",res[i][0],res[i][1],res[i][2]);
        }
    }

    @Test
    public void method2 () {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        SparseArrayUtils.printTowDimensionArr(arr);
        int[][] res = SparseArrayUtils.toSparseArray(arr);
        SparseArrayUtils.printTowDimensionArr(res);
        int[][] towDimensionArr = SparseArrayUtils.toGeneralArr(res);
        SparseArrayUtils.printTowDimensionArr(towDimensionArr);
    }
}
