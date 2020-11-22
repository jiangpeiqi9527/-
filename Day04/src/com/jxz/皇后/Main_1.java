package com.jxz.皇后;

public class Main_1 {
    public static void main(String[] args) {
        new Main_1().placeQueens(8);
    }

    /**
     * 用于标记某一列是否有皇后
     */
    boolean[] cols;

    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] queens;

    /**
     * 标记着某一斜线上是否有皇后（左上角 -> 右下角）
     */
    boolean[] leftTop;
    /**
     * 标记着某一斜线上是否有皇后（右上角 -> 左下角）
     */
    boolean[] rightTop;
    // 一共多少种摆法
    int ways;

    void placeQueens(int n) {
        if (n < 1) return;
        queens = new int[n];
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
        place(0);
        System.out.println("一共有" + ways + "种摆法");
    }

    /**
     * 从第row行开始摆放皇后
     *
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
            if (cols[col] == true) continue;
            int ltIndex = row - col + cols.length - 1;
            if (leftTop[ltIndex]) continue;
            int rtIndex = row + col;
            if (rightTop[rtIndex]) continue;
            // 在第row行第col列摆放皇后
            queens[row] = col;
            cols[col] = true;
            leftTop[ltIndex] = true;
            rightTop[rtIndex] = true;
            place(row + 1);
            cols[col] = false;
            leftTop[ltIndex] = false;
            rightTop[rtIndex] = false;

        }
    }


    /**
     * 展示
     */
    void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (queens[row] == col) {
                    System.out.print(1 + " ");
                    continue;
                }
                System.out.print(0 + " ");
            }
            System.out.println();
        }
    }
}
