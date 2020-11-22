package com.jxz.皇后;

public class Main {
    public static void main(String[] args) {
        new Main().placeQueens(10);
    }

    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] cols;
    // 一共多少种摆法
    int ways;
    void placeQueens (int n) {
        if (n < 1) return;
        cols = new int[n];
        place(0);
        System.out.println("一共有" + ways + "种摆法");
    }

    /**
     * 从第row行开始摆放皇后
     * @param
     */
    private void place(int row) {
        if (row == cols.length) {
            ways++;
            show();
            System.out.println("-------第" + ways + "种--------");
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (isValid(row,col)) {
                // 在第row行第col列摆放皇后
                cols[row] = col;
                place(row + 1);
            }
        }
    }

    /**
     * 判断第row行，第col列是否可以摆放
     * @param row
     * @param col
     * @return
     */
    boolean isValid (int row, int col) {
        for (int i = 0; i < row; i++) {
            // 列上有没有皇后
            if (cols[i] == col) return false;
            // 斜线上有没有皇后
            if (row - i == Math.abs(col - cols[i])) return false;
        }
        return true;
    }

    /**
     * 展示
     */
    void show () {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    System.out.print(1 + " ");
                    continue;
                }
                System.out.print(0 + " ");
            }
            System.out.println();
        }
    }
}
