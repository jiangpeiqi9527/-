package 动态规划;

public class _面试题_17_16_按摩师 {
    public int massage(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int max = Math.max(dp[0],dp[1]);
        for (int i = 2; i < dp.length; i++) {
            int maxPrev = 0;
            for (int j = i - 2; j >= 0; j--) {
                maxPrev = Math.max(maxPrev,dp[j]);
            }
            dp[i] = nums[i] + maxPrev;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
