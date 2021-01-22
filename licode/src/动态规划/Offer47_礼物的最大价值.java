package 动态规划;

public class Offer47_礼物的最大价值 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 < 0) {
                    grid[i][j] = j - 1 < 0 ? grid[i][j] : grid[i][j - 1] + grid[i][j];
                }else {
                    grid[i][j] = j - 1 < 0 ?
                            grid[i - 1][j] + grid[i][j]
                            : Math.max(grid[i - 1][j],grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
