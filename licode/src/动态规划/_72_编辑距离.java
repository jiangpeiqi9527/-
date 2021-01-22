package 动态规划;

public class _72_编辑距离 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        if (word1.length() == 1 && word2.length() == 1) return word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        int m = word1.length();
        int n = word2.length();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int letf_on = chars1[i - 1] == chars2[j - 1] ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.min(letf_on, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[m][n];
    }
}
