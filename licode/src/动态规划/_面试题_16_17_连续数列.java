package 动态规划;

public class _面试题_16_17_连续数列 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] >= 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
