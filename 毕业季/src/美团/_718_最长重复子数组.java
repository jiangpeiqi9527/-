package 美团;

public class _718_最长重复子数组 {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (A[i - 1] == B[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i - 1][j], dp[i][j - 1]));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[A.length][B.length];
    }
}
