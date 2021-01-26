package 热门;

public class _977_有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        // 两个指针从左往右遍历，从右往左遍历
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int resIndex = nums.length - 1;
        while (resIndex >= 0) {
            int leftValue = nums[left] * nums[left];
            int rightValue = nums[right] * nums[right];
            if (leftValue > rightValue) {
                result[resIndex--] = leftValue;
                left++;
            } else {
                result[resIndex--] = rightValue;
                right--;
            }
        }
        return result;
    }
}
