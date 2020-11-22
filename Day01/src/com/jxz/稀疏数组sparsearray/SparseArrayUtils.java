package com.jxz.稀疏数组sparsearray;

public class SparseArrayUtils {
    public static int[][] toSparseArray(int[][] arr){
        int row = arr.length;
        int column = arr[0].length;
        int[][] newArr = null;
        int count = 0;
        for (int i = 0; i < arr.length;i++) {
            for (int j = 0;j < arr[i].length;j++) {
                if (arr[i][j] != 0) {
                    count++;
                }
            }
        }
        newArr = new int[count + 1][3];
        newArr[0][0] = row;
        newArr[0][1] = column;
        newArr[0][2] = count;
        int num = 1;
        for (int i = 0; i < arr.length;i++) {
            for (int j = 0;j < arr[i].length;j++) {
                if (arr[i][j] != 0) {
                    newArr[num][0] = i;
                    newArr[num][1] = j;
                    newArr[num][2] = arr[i][j];
                    num++;
                }
            }
        }
        return newArr;
    }


    public static int[][] toGeneralArr (int[][] arr) {
        int[][] res = new int[arr[0][0]][arr[0][1]];
        for (int i = 1; i < arr.length ; i++) { res[arr[i][0]][arr[i][1]] = arr[i][2]; }
        return res;
    }

    public static void printTowDimensionArr (int[][] arr) {
        System.out.println("----------------------------------");
        for (int[] arr1: arr) {
            for (int num : arr1) {
                System.out.printf("%d\t",num);
            }
            System.out.println();
        }
    }
}
