package 动态规划;

public class _1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        int maxLen = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = chars1[i - 1] == chars2[j - 1] ?
                        dp[i - 1][j - 1] + 1 :
                        Math.max(dp[i - 1][j], dp[i][j - 1]);
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }
}
