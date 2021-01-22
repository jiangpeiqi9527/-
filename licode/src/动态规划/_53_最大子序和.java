package 动态规划;

public class _53_最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] < 0 ? nums[i] : nums[i - 1] + nums[i];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
