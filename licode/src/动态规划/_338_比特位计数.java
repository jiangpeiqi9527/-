package 动态规划;

public class _338_比特位计数 {
    public int[] countBits(int num) {
        if (num == 0) return new int[]{};
        int[] dp = new int[num + 1];
        dp[1] = 1;
        int help = 0;
        for (int i = 2; i < num + 1; i++) {
            if ((i & 1) == 0) { // 偶数
                help = i;
                while ((help & 1) != 1) {
                    help = help >> 1;
                }
                dp[i] = dp[help];
            } else { // 奇数
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}
