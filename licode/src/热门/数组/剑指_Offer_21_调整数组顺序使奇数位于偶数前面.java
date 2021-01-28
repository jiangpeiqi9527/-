package 热门.数组;

public class 剑指_Offer_21_调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        // 像写快速排序一样
        if (nums == null || nums.length < 2) return nums;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // -->
            while (left < right) {
                if ((nums[left] & 1) == 0) {
                    break;
                }
                left++;
            }

            // <--
            while (left < right) {
                if ((nums[right] & 1) != 0) {
                    break;
                }
                right--;
            }
            if (left >= right) break;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
