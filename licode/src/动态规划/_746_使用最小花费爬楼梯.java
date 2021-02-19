package 动态规划;

public class _746_使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1],dp[i - 2]) +cost[i];
        }
        return Math.min(dp[dp.length - 1],dp[dp.length - 2]);
    }
}
