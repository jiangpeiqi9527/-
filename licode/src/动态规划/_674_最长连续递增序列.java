package 动态规划;

public class _674_最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
