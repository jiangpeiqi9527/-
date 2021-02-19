package 动态规划;

public class _1641_统计字典序元音字符串的数目 {
    public int countVowelStrings(int n) {
        if (n == 0) return 0;
        int[][] dp = new int[n + 1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            //长度i的以u结尾的字符串可以由任意一个长度i-1的字符串结尾加个u得到
            dp[i][4] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]
                    + dp[i - 1][4];
            dp[i][3] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][0] = dp[i - 1][0];
        }
        return dp[n][0] + dp[n][1] +dp[n][2] +dp[n][3] + dp[n][4];
    }
}
