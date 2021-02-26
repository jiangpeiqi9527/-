package 美团;

public class _53_最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] > 0 ? nums[i] + dp[i - 1] : nums[i];
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
