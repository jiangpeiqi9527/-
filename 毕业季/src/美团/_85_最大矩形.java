package 美团;

public class _85_最大矩形 {
    public int maximalRectangle(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = matrix[i][0] == 1 ? dp[i - 1][0] + 1 : 0;
        }

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = matrix[0][i] == 1 ? dp[0][i - 1] + 1 : 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

            }
        }
        return 0;
    }
}
