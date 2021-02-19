package 动态规划;

public class _303_区域和检索_数组不可变 {

    private int[] nums;

    private int[] dp;

    public _303_区域和检索_数组不可变(int[] nums) {
        if (nums == null || nums.length == 0) return;
        this.nums = nums;
        dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = nums[i] + dp[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return i > 0 ? dp[j] - dp[i - 1] : dp[j];
    }
}
