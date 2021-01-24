package 动态规划;

public class _63_不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) return (obstacleGrid[0][0] + 1) >> 1;
        if (obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = -1;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = (dp[i][0] != -1 && dp[i - 1][0] != -1) ? 1 : -1;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = (dp[0][i] != -1 && dp[0][i - 1] != -1) ? 1 : -1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (dp[i][j] == -1) continue;
                dp[i][j] = dp[i - 1][j] != -1 ? dp[i - 1][j] +
                        (dp[i][j - 1] != -1 ? dp[i][j - 1] : 0) :
                        (dp[i][j - 1] != -1 ? dp[i][j - 1] : 0);
            }
        }
        return (dp[dp.length - 1][dp[0].length - 1] == 0 ||
                dp[dp.length - 1][dp[0].length - 1] == -1) ? 0 :
                dp[dp.length - 1][dp[0].length - 1];
    }
}
