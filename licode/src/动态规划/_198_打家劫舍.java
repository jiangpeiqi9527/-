package 动态规划;

public class _198_打家劫舍 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 3) return nums.length == 1 ?
               nums[0] :
                (nums[0] > nums[1] ? nums[0] : nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int maxVal = dp[0] > dp[1] ? dp[0] : dp[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = nums[i];
            int maxPrev = 0;
            for (int j = i - 2; j >= 0; j--) {
                maxPrev = Math.max(maxPrev,dp[j]);
            }
            dp[i] += maxPrev;
            maxVal = Math.max(maxVal,dp[i]);
        }
        return maxVal;
    }
}
