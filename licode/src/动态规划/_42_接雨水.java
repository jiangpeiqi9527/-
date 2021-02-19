package 动态规划;

public class _42_接雨水 {
    public int trap(int[] height) {
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(height[i - 1],max_left[i - 1]);
        }
        for (int i = height.length - 2; i > 0; i--) {
            max_right[i] = Math.max(height[i + 1],max_right[i + 1]);
        }
        int maxWater = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[i] < max_left[i] && height[i] < max_right[i])
                maxWater += Math.min(max_left[i],max_right[i]) - height[i];
        }
        return maxWater;
    }
}
