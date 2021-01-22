package 动态规划;

public class _300_最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1 || nums.length == 0) return nums.length;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxSub = 1;
            boolean findChild = false;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    maxSub = Math.max(maxSub, dp[j]);
                    findChild = true;
                } else {
                    dp[i] = 1;
                }
            }
            dp[i] = findChild ? maxSub + 1 : 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        _300_最长递增子序列 test = new _300_最长递增子序列();
        test.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
