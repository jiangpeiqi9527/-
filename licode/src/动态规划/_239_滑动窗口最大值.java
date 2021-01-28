package 动态规划;

public class _239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        int[] neighbor = new int[nums.length - k + 1];
        for (int i = 0; i < neighbor.length; i++) {
            neighbor[i] = Math.max(nums[i + 1], nums[i + 2]);
        }
        int[] window = new int[neighbor.length];
        for (int i = 0; i < window.length; i++) {
            window[i] = Math.max(nums[i],neighbor[i]);
        }
        return window;
    }
}
