package 动态规划;

public class _1025_除数博弈 {
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 5];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                if ((i % j) == 0 && !dp[i - j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[N];
    }
}
